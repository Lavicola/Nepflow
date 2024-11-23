package com.nepflow.BaseModules;

import com.nepflow.BaseModules.ImageModule.Service.BucketImageService;
import com.nepflow.UserManagement.Service.Auth0UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Does not resolve @value yet
//@ExtendWith(value = {SpringExtension.class})
//@Import({EnableEncryptablePropertiesConfiguration.class,Auth0UserServiceImpl.class})
//@SpringBootConfiguration
@SpringBootTest
public class Aut0UserServiceTest {


    @Autowired
    Auth0UserService auth0UserService;

    @MockBean
    BucketImageService bucketImageService;

    @Test
    public void getUserEmailsTest() {
        List<String> a = new ArrayList<>();
        HashMap<String, String> users;
        a.add("google-oauth2|109597326519453519597");
        a.add("auth0|66e7144ef9a1e5c4993f6da5");
        users = this.auth0UserService.getUserEmails(a);
        assertEquals(2, users.size());
        assertEquals(2, this.auth0UserService.getUserCache().size());

    }

    @Test
    public void getUserEmailTest() {
        String user;
        user = this.auth0UserService.getUserEmail("google-oauth2|109597326519453519597");
        assertNotNull(user);
        assertEquals(1, this.auth0UserService.getUserCache().size());

    }

    @Test
    public void generateNewTokenTest() {
        assertNotNull(this.auth0UserService.generateNewToken());
    }


    @Test
    public void getValidTokenTest() {
        assertNotNull(this.auth0UserService.getValidToken());
    }

    @Test
    public void validateTokenAfterExpirationTest() {
        String token = this.auth0UserService.getValidToken();
        Instant expiredTokenInstant = Instant.ofEpochMilli(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 60 * 60);

        boolean beforeMock = false;
        boolean afterMock = true;

        beforeMock = this.auth0UserService.validateToken(token);
        try (MockedStatic<Instant> mocked = Mockito.mockStatic(Instant.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(Instant::now).thenReturn(expiredTokenInstant);
            afterMock = this.auth0UserService.validateToken(token);
        }
        Assertions.assertTrue(beforeMock);
        Assertions.assertFalse(afterMock);
    }






}
