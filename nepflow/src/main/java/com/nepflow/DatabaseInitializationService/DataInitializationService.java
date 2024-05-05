package com.nepflow.DatabaseInitializationService;

import jakarta.annotation.PostConstruct;
import org.neo4j.driver.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class DataInitializationService {

    @Value("${spring.neo4j.uri}")
    String dbUri;
    @Value("${spring.neo4j.authentication.username}")
    String dbUser;
    @Value("${spring.neo4j.authentication.password}")
    String dbPassword;

    @Value("classpath:sql/nepenthes.sql")
    private Resource NepenthesSQL;
    @Value("classpath:sql/clones.sql")
    private Resource ClonesSQL;

    @Value("classpath:sql/country.sql")
    private Resource CountrySQL;


    @PostConstruct
    public void initializeDatabase() throws IOException {
         Driver driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, dbPassword));
         driver.verifyConnectivity();
         //DataInitializationService.executeStatements(driver,NepenthesSQL);
         //DataInitializationService.executeStatements(driver,ClonesSQL);
        //DataInitializationService.executeStatements(driver,CountrySQL);

    }

    public static boolean executeStatements(Driver driver, Resource resource) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                driver.executableQuery(line).execute();
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}







