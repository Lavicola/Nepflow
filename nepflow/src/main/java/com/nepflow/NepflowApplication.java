package com.nepflow;

import org.modelmapper.ModelMapper;

import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@EnableNeo4jRepositories(basePackages = {"com.nepflow.NepenthesManagement"})
public class NepflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepflowApplication.class, args);
	}



	@Configuration
	public class ModelMapperConfig {



		@Bean
		public ModelMapper modelMapper() {
			ModelMapper modelMapper = new ModelMapper();


			return modelMapper;
		}
	}



	@Bean
	org.neo4j.cypherdsl.core.renderer.Configuration cypherDslConfiguration() {

		return org.neo4j.cypherdsl.core.renderer.Configuration.newConfig()
				.withDialect(Dialect.NEO4J_5).build();
	}




}
