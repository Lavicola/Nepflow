package com.nepflow.PollenExchange.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.PollenExchangeTestDataInserter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataNeo4jTest
@Import(value = {PollenExchangeTestDataInserter.class, PollenExchangeTestDataInserter.class})
public class TradeRepositoryTest {


    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    PollenExchangeTestDataInserter testDataInserter;

    private static Neo4j embeddedDatabaseServer;
    static boolean executedOnce = false;


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
    public void tradeOrReverseTradeExistsNotTest() {
        PollenOffer offerUser1 =  new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 =  new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));

        Trade trade = new Trade(offerUser1, offerUser2);
        this.tradeRepository.save(trade);
        assertFalse(this.tradeRepository.tradeOrReverseTradeExists(offerUser2.getUuid()+" ", offerUser1.getUuid()));
    }


    @Test
    public void tradeOrReverseTradeExistsTest() {
        PollenOffer offerUser1 =  new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 =  new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));

        Trade trade = new Trade(offerUser1, offerUser2);
        this.tradeRepository.save(trade);
        assertTrue(this.tradeRepository.tradeOrReverseTradeExists(offerUser1.getUuid(), offerUser2.getUuid()));
        assertTrue(this.tradeRepository.tradeOrReverseTradeExists(offerUser2.getUuid(), offerUser1.getUuid()));
    }


    private Specimen updateEntityVersion(Specimen specimen) {
        return testDataInserter.getUpdatedSpecimenVersion(specimen);
    }


}

