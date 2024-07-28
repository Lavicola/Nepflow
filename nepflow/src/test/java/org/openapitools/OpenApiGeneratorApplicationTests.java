package org.openapitools;

import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class OpenApiGeneratorApplicationTests {

    @MockBean
    DataInitializationService dataInitializationService;

    @MockBean
    AuthenticationService authenticationService;

    @Test
    void contextLoads() {
    }

}