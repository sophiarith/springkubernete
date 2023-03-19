package com.kshrd.registration.service;

public interface EmailService {
    void sendByMail(String to, String email) throws Exception;
}
