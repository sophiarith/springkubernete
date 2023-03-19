package com.kshrd.registration.exception;


import com.kshrd.registration.payload.response.ResponseRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(value = {AppExceptionHandler.class})
    public ResponseEntity<Object> exceptionHandler(AppExceptionHandler ex, WebRequest request){

        ResponseRes responseRes = new ResponseRes<>();

        if(ex.getStatusCode() == 400){
            responseRes = new ResponseRes(
                    HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST, ex.getMessage(),
                    ex.getPath(), false, null, null
            );
        }else if(ex.getStatusCode() == 401){
            responseRes = new ResponseRes(
                    HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now(),
                    HttpStatus.UNAUTHORIZED, ex.getMessage(),
                    ex.getPath(), false, null, null
            );
        }else if(ex.getStatusCode() == 403){
            responseRes = new ResponseRes(
                    HttpStatus.FORBIDDEN.value(), LocalDateTime.now(),
                    HttpStatus.FORBIDDEN, ex.getMessage(),
                    ex.getPath(), false, null, null
            );
        }else if(ex.getStatusCode() == 404){
            responseRes = new ResponseRes(
                    HttpStatus.NOT_FOUND.value(), LocalDateTime.now(),
                    HttpStatus.NOT_FOUND, ex.getMessage(),
                    ex.getPath(), false, null, null
            );
        }else if(ex.getStatusCode() == 500){
            responseRes = new ResponseRes(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now(),
                    HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),
                    ex.getPath(), false, null, null
            );
        }

        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }



}
