package com.nepflow.UserManagement.service;



public interface UserEmailService {

     boolean sendVerificationEmail(String email,String username,String token);
     boolean sendPasswordForgottenEmail(String email);




}
