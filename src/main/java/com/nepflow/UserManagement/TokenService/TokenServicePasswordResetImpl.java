package com.nepflow.UserManagement.TokenService;

import com.nepflow.UserManagement.Model.PasswordResetToken;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.PasswordResetTokenRepository;
import com.nepflow.UserManagement.Repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenServicePasswordResetImpl extends AbstractTokeServiceImpl {


    @Autowired
    public TokenServicePasswordResetImpl(@Autowired PasswordResetTokenRepository passwordResetTokenRepository,@Value("${tokenservice.passwordResetSecret}") String passwortResetSecret) {
        super(passwordResetTokenRepository,passwortResetSecret);
    }


    @Override
    public boolean deleteToken(String token, User user) {
        Optional<PasswordResetToken> passwordResetToken = ((PasswordResetTokenRepository) this.repository).findByTokenAndUser(token, user);
        if (passwordResetToken.isPresent()) {
            this.repository.delete(passwordResetToken.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean isCurrentToken(String token, User user) {
        return ((VerificationTokenRepository) this.repository).findByTokenAndUser(token, user).isPresent();
    }


}
