package com.nepflow.Growlistmanagement.models;

import com.nepflow.GrowlistManagement.Repository.NepenthesCloneRepository;
import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.SpeciesCloneRepository;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@DataNeo4jTest
public class NepenthesCloneTest {

    @Autowired
    NepenthesCloneRepository nepenthesCloneRepository;


    @Autowired
    UserRepository userRepository;

    @Autowired
    SpeciesCloneRepository speciesCloneRepository;


    private static Neo4j embeddedDatabaseServer;

    @BeforeAll
    static void initializeNeo4j() {

        embeddedDatabaseServer = Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()
                .build();
    }

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.neo4j.uri", embeddedDatabaseServer::boltURI);
        registry.add("spring.neo4j.authentication.username", () -> "neo4j");
        registry.add("spring.neo4j.authentication.password", () -> null);
    }

    @AfterAll
    static void stopNeo4j() {

        embeddedDatabaseServer.close();
    }



    @Test
    public void noDuplicateNodeTest(){
        /*
        User user = new User("namef","oatuh");
        Nepenthes nepenthes = new Nepenthes("villosa");
        IVClone ivClone = new IVClone("BE-ddd",nepenthes);
        this.ivCloneRepository.save(ivClone);
        this.userRepository.save(user);
        Clone ivClone1 = this.speciesCloneRepository.findCloneByCloneIdAndNepenthesName(ivClone.getCloneId(), nepenthes.getName());
        User user1 = this.userRepository.findUserByOAuthId(user.getOAuthId());
        //NepenthesClone nepenthesClone = new NepenthesClone(user1,ivClone1);
        //this.nepenthesCloneRepository.save(nepenthesClone);


        System.out.println("IVCLone:" +this.ivCloneRepository.findAll().size());
        System.out.println( "Clone: "+this.speciesCloneRepository.findAll().size());


*/
    }



}
