package com.nepflow.BaseModules.EmailModule;

import jakarta.mail.MessagingException;

public interface EmailService {


    /**
     * @param mailDTO@return true if successfully send
     */
    boolean sendEmail(MailDTO mailDTO) throws MessagingException;





}
