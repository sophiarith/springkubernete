package com.kshrd.registration.service.serviceimp;

import com.kshrd.registration.configuration.EmailValidator;
import com.kshrd.registration.exception.AppExceptionHandler;
import com.kshrd.registration.model.AppUser;
import com.kshrd.registration.payload.request.EmailPasswordReq;
import com.kshrd.registration.payload.request.EmailReq;
import com.kshrd.registration.payload.request.TokenReq;
import com.kshrd.registration.payload.request.UpdateUserReq;
import com.kshrd.registration.payload.response.AppUserRes;
import com.kshrd.registration.repository.AppUserRepo;
import com.kshrd.registration.security.JwtTokenUtil;
import com.kshrd.registration.service.AppUserService;
import com.kshrd.registration.service.EmailService;
import com.kshrd.registration.utillity.DecodeCryptoJS;
import com.kshrd.registration.utillity.GenerateCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class AppUserServiceImp implements AppUserService {

    private final AppUserRepo appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;
    private final EmailService emailService;
    private final JwtTokenUtil jwtTokenUtil;

    public AppUserServiceImp(AppUserRepo appUserRepository, PasswordEncoder passwordEncoder, EmailValidator emailValidator, EmailService emailService, JwtTokenUtil jwtTokenUtil, GenerateCode code) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailValidator = emailValidator;
        this.emailService = emailService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.getUserByEmail(email);
        System.out.println("loadUserByUsername: "+appUser);
        /** CHECK USER IS ENABLED OR NOT */
//        if(appUser != null && appUser.getStatus()){
//            return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(),
//                    appUser.getAuthorities());
//        }else {
//            throw new UsernameNotFoundException("User is disabled!");
//        }

        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(),
                    appUser.getAuthorities());
    }

    @Override
    public AppUserRes addNewUser(EmailReq email) throws Exception {
        //Validate email before sending
        boolean isEmailValid = emailValidator.test(email.getEmail());
        if (!isEmailValid) throw new IllegalStateException("Email is invalid!");

        AppUserRes appUserRes = new AppUserRes();
//        String myPassword = String.valueOf(UUID.randomUUID());
//        System.out.println("myPassword: " + myPassword);
//        String encode = passwordEncoder.encode(myPassword);

        GenerateCode code = new GenerateCode();
        String getCode = code.generateUserId(8);
        System.out.println("getCode: " +  getCode);
        String encode = passwordEncoder.encode(getCode);

        EmailPasswordReq userReq = new EmailPasswordReq(email.getEmail(), encode);
        AppUser findUserByEmail = appUserRepository.getUserByEmail(email.getEmail());
        ModelMapper modelMapper = new ModelMapper();
        System.out.println("findUserByEmail: " + findUserByEmail);

        try{
            if (findUserByEmail != null){
                EmailPasswordReq userReq2 = new EmailPasswordReq(email.getEmail(), encode);
                AppUser updateUser = appUserRepository.updateUserByEmail(userReq2);
                System.out.println("tokenURL: " + findUserByEmail.getToken());
                String tokenURL = code.EncryptPassword(findUserByEmail.getToken());
//                System.out.println("tokenURL: " + tokenURL);
                sendEmailVerification("leangsengk90@gmail.com",getCode,tokenURL);
//                System.out.println("updateUser: " + updateUser);

//                AppUser user = appUserRepository.getUserByEmail(email.getEmail());
                appUserRes = modelMapper.map(updateUser, AppUserRes.class);
                System.out.println("EXISTED USER: " + appUserRes);
                return appUserRes;
            }else {
                String uuid = UUID.randomUUID().toString();
                //String generateToken = code.EncryptPassword(uuid);
                System.out.println("ORIGIN UUID: " + uuid);
                AppUser user = appUserRepository.addNewUser(userReq, uuid);
                appUserRes = modelMapper.map(user, AppUserRes.class) ;
                System.out.println("NEW USER: " + appUserRes);
                //After add new user and apply role as "USER" to them;
                appUserRepository.addUserInRoleUSER(appUserRes.getId());

                if(appUserRes != null){
                    System.out.println("tokenURL: " + user.getToken());
                    String tokenURL = code.EncryptPassword(user.getToken());
//                    System.out.println("tokenURL: " + tokenURL);
                    sendEmailVerification("leangsengk90@gmail.com",getCode, tokenURL);
                }
                return appUserRes;
            }
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public AppUserRes verifyByToken(TokenReq token) throws Exception {
        if (token.getToken().isEmpty()) throw new NullPointerException("Token is empty!");
        ModelMapper modelMapper = new ModelMapper();
        GenerateCode code = new GenerateCode();

        try{
            String getToken = code.DecryptPassword(token.getToken());
            AppUser appUser = appUserRepository.getUserByToken(getToken);
            if(appUser != null){
                EmailPasswordReq emailPasswordReq = new EmailPasswordReq(appUser.getEmail(), token.getPassword());
                AppUserRes appUserRes = addNewUserFromGoogle(emailPasswordReq);
                appUserRes = modelMapper.map(appUser, AppUserRes.class);
                final String jwtToken = jwtTokenUtil.generateToken(appUser);
                appUserRes.setJwtToken(jwtToken);
                return appUserRes;
            }else {
                throw new UsernameNotFoundException("User is not found via token!");
            }
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public AppUserRes addNewUserFromGoogle(EmailPasswordReq emailPasswordReq) throws Exception {

        String decodeEmail = DecodeCryptoJS.getDecode(emailPasswordReq.getEmail());

        //Validate email before sending
        boolean isEmailValid = emailValidator.test(decodeEmail);
        if (!isEmailValid) throw new IllegalStateException("Email is invalid!");

        AppUserRes appUserRes = new AppUserRes();

       // GenerateCode code = new GenerateCode();
      //  String getCode = code.generateUserId(8);
//        System.out.println("getCode: " +  getCode);
        String encode = passwordEncoder.encode(emailPasswordReq.getPassword());

        EmailPasswordReq userReq = new EmailPasswordReq(decodeEmail, encode);
        AppUser findUserByEmail = appUserRepository.getUserByEmail(decodeEmail);
        ModelMapper modelMapper = new ModelMapper();
        System.out.println("findUserByEmail: " + findUserByEmail);

        try{
            if (findUserByEmail != null){
                EmailPasswordReq userReq2 = new EmailPasswordReq(decodeEmail, encode);
                AppUser updateUser = appUserRepository.updateUserByEmail(userReq2);
                appUserRes = modelMapper.map(updateUser, AppUserRes.class);
                System.out.println("EXISTED USER: " + appUserRes);

                final String jwtToken = jwtTokenUtil.generateToken(updateUser);
                appUserRes.setJwtToken(jwtToken);
                return appUserRes;
            }else {
                String uuid = UUID.randomUUID().toString();
                System.out.println("ORIGIN UUID: " + uuid);
                AppUser user = appUserRepository.addNewUser(userReq, uuid);
                appUserRes = modelMapper.map(user, AppUserRes.class) ;
                System.out.println("NEW USER: " + appUserRes);
                //After add new user and apply role as "USER" to them;
                appUserRepository.addUserInRoleUSER(appUserRes.getId());

                final String jwtToken = jwtTokenUtil.generateToken(user);
                appUserRes.setJwtToken(jwtToken);
                return appUserRes;
            }
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public AppUserRes getUserByEmail(String email) throws Exception {
        if (email.isEmpty()) throw new UsernameNotFoundException("Email cannot be empty!");
        try {
            AppUser appUser = appUserRepository.getUserByEmail(email);
            ModelMapper modelMapper = new ModelMapper();
            AppUserRes appUserRes = modelMapper.map(appUser, AppUserRes.class);
            return appUserRes;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public AppUserRes updateUserInfoByEmail(UpdateUserReq updateUserReq) throws Exception {
        try{
            AppUser appUser = appUserRepository.updateUserInfoByEmail(updateUserReq);
            ModelMapper modelMapper = new ModelMapper();
            AppUserRes appUserRes = modelMapper.map(appUser, AppUserRes.class);
            final String jwtToken = jwtTokenUtil.generateToken(appUser);
            appUserRes.setJwtToken(jwtToken);
            return  appUserRes;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Value("${base.token.url}")
    private String baseToken;

    /** URLEncoder.encode(encryptToken, StandardCharsets.UTF_8.name()) */
    private void sendEmailVerification(String toEmail, String code, String encryptToken) throws Exception {
        emailService.sendByMail(toEmail, "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            font-family: Helvetica, sans-serif;\n" +
                "        }\n" +
                "\n" +
                "        h2 {\n" +
                "            letter-spacing: 2px;\n" +
                "        }\n" +
                "\n" +
                "        ul li {\n" +
                "            color: grey;\n" +
                "        }\n" +
                "\n" +
                "        ul li span {\n" +
                "            color: brown;\n" +
                "        }\n" +
                "\n" +
                "        .code {\n" +
                "            background-color: rgb(255, 170, 0);\n" +
                "            color: rgb(0, 0, 0);\n" +
                "            width: 244px;\n" +
                "            height: 60px;\n" +
                "        }\n" +
                "\n" +
                "        .link {\n" +
                "            width: 300px;\n" +
                "        }\n" +
                "\n" +
                "        .or {\n" +
                "            width: 244px;\n" +
                "            height: 60px;\n" +
                "            color: grey;\n" +
                "        }\n" +
                "\n" +
                "        div p {\n" +
                "            font-size: 20px;\n" +
                "            font-weight: bold;\n" +
                "            font-family: monospace;\n" +
                "            text-align: center;\n" +
                "            padding-top: 14px;\n" +
                "        }\n" +
                "\n" +
                "        #url {\n" +
                "            font-size: 16px;\n" +
                "            font-weight: bold;\n" +
                "            font-family: monospace;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <h2>VERIFICATION CODE</h2>\n" +
                "    <div class=\"code\">\n" +
                "        <p>"+code+"</p>\n" +
                "    </div>\n" +
                "    <div class=\"or\">\n" +
                "        <p>–– OR ––</p>\n" +
                "    </div>\n" +
                "    <div class=\"link\">\n" +
                "        <a id=\"url\" href=\""+baseToken+URLEncoder.encode(encryptToken, StandardCharsets.UTF_8.name())+"\">CLICK HERE TO VERIFY DIRECTLY</a>\n" +
                "    </div>\n" +
                "    <ul style=\"list-style-type: none; padding: 0;\">\n" +
                "        <li><span>*</span> Please use this verification code to login into the system</li>\n" +
                "        <li>and you can register to be an applicant for entrance exam.</li>\n" +
                "        <li>------------------------------------------------------------------------------------------------</li>\n" +
                "        <li>Korea Software HRD Center / Foundation for Korea Software Global Aid</li>\n" +
                "        <li>No. 12, St. 323, Sangkat Boeung Kak II, Khan Toul Kork, Phnom Penh, Cambodia</li>\n" +
                "        <li>Tel: (+855)17-503-532, (+855) 93-379-803</li>\n" +
                "        <li>Facebook: www.facebook.com/polen.sok.3</li>\n" +
                "        <li>Email: polen.hrd@gmail.com</li>\n" +
                "        <li>Website: www.kshrd.com.kh</li>\n" +
                "    </ul>\n" +
                "</body>\n" +
                "\n" +
                "</html>");
    }

}
