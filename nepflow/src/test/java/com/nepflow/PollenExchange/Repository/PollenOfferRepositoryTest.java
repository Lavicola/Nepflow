package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.PollenExchangeTestDataInserter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataNeo4jTest
@Import(value = {PollenExchangeTestDataInserter.class, PollenExchangeTestDataInserter.class})
public class PollenOfferRepositoryTest {


    @Autowired
    PollenOfferRepository pollenOfferRepository;

    @Autowired
    PollenExchangeTestDataInserter testDataInserter;

    private static Neo4j embeddedDatabaseServer;


    @BeforeAll
    static void initializeNeo4j() {
        embeddedDatabaseServer = Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()
                .build();


    }

    @BeforeEach
    public void setUp() {
        this.testDataInserter.deleteData();
        this.testDataInserter.insertData();

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
    public void getNewestPollenOfferIdBySpecimenTest() {

        LocalDate nextDay = LocalDate.now().plusDays(1);

        PollenOffer newestOffer;
        String newestId;

        this.pollenOfferRepository.save(new PollenOffer(testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male)));
        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(nextDay);
            newestOffer = this.pollenOfferRepository.save(new PollenOffer(testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male)));

        }
        newestId = this.pollenOfferRepository.getNewestPollenOfferIdBySpecimen(newestOffer.getSpecimen().getUuid());

        assertEquals(newestId, newestOffer.getUuid());


    }


}
