package com.nepflow.BaseModules.EmailModule;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
@Profile("!test")
public class EmailServiceImpl implements EmailService {


    /**
     *
     */
    @Autowired
    private SpringTemplateEngine templateEngine;


    /**
     *
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * @return true if sent, else false
     */
    @Override
    public boolean sendEmail(final MailDTO mail) throws MessagingException {
        Context context = new Context();
        if (!mail.getVariables().isEmpty()) {
            context.setVariables(mail.getVariables());
        }

        final String htmlContent = this.templateEngine.process(mail.getTemplateName(), context);
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setFrom(mail.getSender());
        message.setTo(mail.getReceiver());
        message.setSubject(mail.getSubject());
        message.setText(htmlContent);
        this.mailSender.send(mimeMessage);
        return true;
    }
}
