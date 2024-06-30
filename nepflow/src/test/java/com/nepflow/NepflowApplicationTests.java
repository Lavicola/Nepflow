package com.nepflow;

import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class NepflowApplicationTests {

	// for now simply mock it, since dataInitializationService depends on files and database connection
	@MockBean
	DataInitializationService dataInitializationService;

	@Test
	void contextLoads() {
	}

}
