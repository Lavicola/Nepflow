package com.nepflow.PollenExchange.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.PollenExchangeTestDataInserter;
import com.nepflow.PollenExchange.Projection.UserRating;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        PollenOffer offerUser1 = new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));

        Trade trade = new Trade(offerUser1, offerUser2);
        this.tradeRepository.save(trade);
        assertFalse(this.tradeRepository.tradeOrReverseTradeExists(offerUser2.getUuid() + " ", offerUser1.getUuid()));
    }


    @Test
    public void tradeOrReverseTradeExistsTest() {
        PollenOffer offerUser1 = new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));

        Trade trade = new Trade(offerUser1, offerUser2);
        this.tradeRepository.save(trade);
        assertTrue(this.tradeRepository.tradeOrReverseTradeExists(offerUser1.getUuid(), offerUser2.getUuid()));
        assertTrue(this.tradeRepository.tradeOrReverseTradeExists(offerUser2.getUuid(), offerUser1.getUuid()));
    }

    /**
     * Test to make sure that the Query returns all Trades and their references
     */
    @Test
    public void getTradesUserNeedsToRateTest() {
        PollenOffer offerUser1 = new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));

        Trade trade = new Trade(offerUser1, offerUser2);
        Trade trade2 = new Trade(offerUser1, offerUser2);
        trade.acceptTrade();
        trade2.acceptTrade();
        this.tradeRepository.save(trade);
        this.tradeRepository.save(trade2);
        List<Trade> trades = this.tradeRepository.getTradesUserNeedsToRate(offerUser1.getUser().getUsername());
        assertEquals(2, trades.size());
        for (int i = 0; i < 2; i++) {
            Trade trade1 = trades.get(i);
            assertNotNull(trade1.getUserWhoInitiatedTrade());
            assertNotNull(trade1.getUserWhoInitiatedTrade().getCountry());
            assertNotNull(trade1.getUserWhoInitiatedTrade());
            assertNotNull(trade1.getUserWhoInitiatedTrade().getCountry());
            assertNotNull(trade1.getInitiatedOffer());
            assertNotNull(trade1.getInitiatedOffer().getSpecimen());
            assertNotNull(trade1.getInitiatedOffer().getSpecimen().getClone());
            assertNotNull(trade1.getInitiatedOffer().getSpecimen().getClone().getLabel());
            assertNotNull(trade1.getInitiatedOffer().getSpecimen().getClone().getSex());
            assertNotNull(trade1.getInitiatedOffer().getSpecimen().getClone().getLocation());
            assertNotNull(trade1.getInitiatedOffer().getSpecimen().getClone().getSellerAsString());
            assertEquals(1, trade1.getRatings().size());
            assertNotNull(trade1.getRatings().get(0).getUser());

        }
    }

    @Test
    public void getTradeRatingsFromUserTest() {
        PollenOffer offerUser1 = new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));

        Trade trade = new Trade(offerUser1, offerUser2);
        Trade trade2 = new Trade(offerUser1, offerUser2);
        trade.acceptTrade();
        trade2.acceptTrade();
        this.tradeRepository.save(trade);
        this.tradeRepository.save(trade2);
        List<Trade> trades = this.tradeRepository.getTradesWithTradeRatingsByUsername(offerUser1.getUser().getUsername());
        assertEquals(2, trades.size());
        assertEquals(1, trades.get(0).getRatings().size());
        assertEquals(offerUser1.getUser(), trades.get(0).getRatings().get(0).getUser());
        assertEquals(offerUser1.getUser(), trades.get(1).getRatings().get(0).getUser());
    }

    @Test
    public void getReceivedRatingsTest() {
        PageRequest pageable = PageRequest.of(0, 1, Sort.by("receivedOn").ascending());
        PollenOffer offerUser1 = new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        PollenOffer offerUser2 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));
        Trade trade = new Trade(offerUser1, offerUser2);
        Trade trade2 = new Trade(offerUser1, offerUser2);
        trade.acceptTrade();
        trade2.acceptTrade();
        this.tradeRepository.save(trade);
        this.tradeRepository.save(trade2);
        Page<UserRating> ratings = this.tradeRepository.getReceivedRatings(offerUser1.getUser().getUsername(), pageable);
        assertEquals(2, ratings.getTotalElements());
        assertEquals(2, ratings.getTotalPages());
        for (int i = 0; i < ratings.getSize(); i++) {
            assertNotNull(ratings.getContent().get(i));
            assertNotNull(ratings.getContent().get(i).getRating());
            assertNotNull(ratings.getContent().get(i).getRater());
            assertNotNull(ratings.getContent().get(i).getTradeId());
        }

    }


    private Specimen updateEntityVersion(Specimen specimen) {
        return testDataInserter.getUpdatedSpecimenVersion(specimen);
    }


}

