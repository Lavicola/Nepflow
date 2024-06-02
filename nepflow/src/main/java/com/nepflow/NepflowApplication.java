package com.nepflow;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEncryptableProperties
public class NepflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepflowApplication.class, args);
	}




	@Bean
	org.neo4j.cypherdsl.core.renderer.Configuration cypherDslConfiguration() {

		return org.neo4j.cypherdsl.core.renderer.Configuration.newConfig()
				.withDialect(Dialect.NEO4J_5).build();
	}




}
