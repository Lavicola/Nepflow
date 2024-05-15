package com.nepflow;

import com.nepflow.NepenthesManagement.Dto.ICCloneDTO;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import org.modelmapper.spi.MappingContext;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

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
