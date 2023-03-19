package com.kshrd.registration.service;

import com.kshrd.registration.exception.AppExceptionHandler;
import com.kshrd.registration.model.AppUser;
import com.kshrd.registration.payload.request.EmailPasswordReq;
import com.kshrd.registration.payload.request.EmailReq;
import com.kshrd.registration.payload.request.TokenReq;
import com.kshrd.registration.payload.request.UpdateUserReq;
import com.kshrd.registration.payload.response.AppUserRes;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    AppUserRes addNewUser(EmailReq email) throws Exception;
    AppUserRes verifyByToken(TokenReq token) throws Exception;
    AppUserRes addNewUserFromGoogle(EmailPasswordReq emailPasswordReq) throws Exception;
    AppUserRes getUserByEmail(String email) throws Exception;
    AppUserRes updateUserInfoByEmail(UpdateUserReq updateUserReq) throws Exception;
//    AppUser signIn(AppUserSigninReq signInReq);
}
