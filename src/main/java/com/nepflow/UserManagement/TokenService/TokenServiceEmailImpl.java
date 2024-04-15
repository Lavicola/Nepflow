package com.nepflow.UserManagement.TokenService;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Model.VerificationToken;
import com.nepflow.UserManagement.Repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TokenServiceEmailImpl extends AbstractTokeServiceImpl {



    public TokenServiceEmailImpl(@Autowired VerificationTokenRepository verificationTokenRepository,@Value("${tokenservice.emailVerificationSecret}") String emailVerificationSecret) {
        super(verificationTokenRepository,emailVerificationSecret);
    }

    @Override
    public boolean deleteToken(String token, User user) {
        Optional<VerificationToken> verificationToken = ((VerificationTokenRepository) this.repository).findByTokenAndUser(token, user);
        if(verificationToken.isPresent()){
            this.repository.delete(verificationToken.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean isCurrentToken(String token, User user) {
        return ((VerificationTokenRepository) this.repository).findByTokenAndUser(token,user).isPresent();
    }


}
