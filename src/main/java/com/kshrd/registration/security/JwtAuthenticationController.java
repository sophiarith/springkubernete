package com.kshrd.registration.security;


import com.kshrd.registration.exception.AppExceptionHandler;
import com.kshrd.registration.model.AppUser;
import com.kshrd.registration.payload.request.*;
import com.kshrd.registration.payload.response.AppUserRes;
import com.kshrd.registration.payload.response.JwtRes;
import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/auth")
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final AppUserService userDetailsService;

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, AppUserService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtReq jwtReq) throws Exception {

        if(jwtReq.getEmail().isEmpty() || jwtReq.getPassword().isEmpty())
            throw new NullPointerException("Email or Password is empty!");

        authenticate(jwtReq.getEmail(), jwtReq.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(jwtReq.getEmail());
        System.out.println("userDetails: " + userDetails);

        final String token = jwtTokenUtil.generateToken(userDetails);
        AppUserRes appUserRes = userDetailsService.getUserByEmail(jwtReq.getEmail());
        appUserRes.setJwtToken(token);

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Sign in successfully!",
                "/auth/signin",true, appUserRes,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> addNewUser(@RequestBody EmailReq email) throws Exception {
        AppUserRes appUserRes = userDetailsService.addNewUser(email);

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Sign up successfully!",
                "/auth/signup",true, appUserRes,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

    @PostMapping
    public ResponseEntity<Object> verifyByToken(@RequestBody TokenReq token) throws Exception {
        AppUserRes appUserRes = userDetailsService.verifyByToken(token);

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Sign in with token successfully!",
                "/auth",true, appUserRes,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

    @PutMapping("/user")
    public ResponseEntity<Object> updateUserInfoByEmail(@RequestBody UpdateUserReq updateUserReq) throws Exception {
        AppUserRes appUserRes = userDetailsService.updateUserInfoByEmail(updateUserReq);

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Update user with email successfully!",
                "/auth",true, appUserRes,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

    @PostMapping("signup-with-google")
    public ResponseEntity<Object> signUpWithGoogle(@RequestBody EmailPasswordReq emailPasswordReq) throws Exception {
        AppUserRes appUserRes = userDetailsService.addNewUserFromGoogle(emailPasswordReq);

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Sign up with google successfully!",
                "/auth/signup-with-google",true, appUserRes,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception ex){
            throw new Exception("OTHERS");
        }
    }
}