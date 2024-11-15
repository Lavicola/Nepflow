package com.nepflow.BaseModules.EmailModule;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@Profile("!test")
public class MailConfiguration {


    /**
     * @param password
     * @param host
     * @param username
     * @param port
     * @return
     */
    @Bean
    public JavaMailSender getJavaMailSender(
            final @Value("${spring.mail.password}") String password,
            final @Value("${spring.mail.host}") String host,
            final @Value("${spring.mail.username}") String username,
            final @Value("${spring.mail.port}") int port

    ) throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        return mailSender;
    }
}
