package com.nepflow.UserManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserEmailServiceImpl implements UserEmailService{

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public boolean sendVerificationEmail(String email,String username, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("davidschmidt777@t-online.de");
        message.setSubject("Test Email");
        message.setText(String.format("Hey hats geklappt? http://localhost:8080/verify/%s",token));
        message.setFrom("davidschmidt@nepflow.de");
        javaMailSender.send(message);

        return true;
    }

    @Override
    public boolean sendPasswordForgottenEmail(String email) {
        return false;
    }
}
