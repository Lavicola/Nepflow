package com.nepflow.PollenExchange.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeStartDate;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataNeo4jTest
@Import(value = {PollenExchangeTestDataInserter.class, PollenExchangeTestDataInserter.class})
public class TradeStartDateRepositoryTest {


    PollenOffer offerUser1;
    PollenOffer offerUser2;

    PollenOffer offerUser3;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    PollenOfferRepository pollenOfferRepository;

    @Autowired
    TradeStartDateRepository tradeStartDateRepository;

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
        this.offerUser1 = new PollenOffer(updateEntityVersion(testDataInserter.user1Specimen2Male));
        this.offerUser2 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen3Female));
        this.offerUser3 = new PollenOffer(updateEntityVersion(testDataInserter.user3Specimen3Female));

        this.pollenOfferRepository.deleteAll();
        this.tradeRepository.deleteAll();
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
    public void findAllTradesByUserTestIfNoNullValues() {
        TradeStartDate container = new TradeStartDate();
        List<TradeStartDate> rContainer;
        Trade trade1;
        Trade  rTrade;
        trade1 = new Trade(
                updateOfferVersion(offerUser1),
                updateOfferVersion(offerUser2));
        container.addTrade(trade1);
        this.tradeStartDateRepository.save(container);

        rContainer = this.tradeStartDateRepository.getTradesByUsernameAndDates(offerUser1.getUser().getUsername(),List.of(container.getMonthYearId()));

        assertNotNull(rContainer);
        assertEquals(1,rContainer.size());
        assertEquals(1,rContainer.get(0).getTrades().size());
        rTrade = rContainer.get(0).getTrades().get(0);

        assertNotNull(rTrade.getUserWhoAnswersTrade());
        assertNotNull(rTrade.getUserWhoAnswersTrade().getCountry());

        assertNotNull(rTrade.getUserWhoInitiatedTrade());
        assertNotNull(rTrade.getUserWhoInitiatedTrade().getCountry());

        assertNotNull(rTrade.getInitiatedOffer().getUser());
        assertNotNull(rTrade.getInitiatedOffer().getUser().getCountry());

        assertNotNull(rTrade.getInitiatedOffer());
        assertNotNull(rTrade.getInitiatedOffer().getSpecimen());
        assertNotNull(rTrade.getInitiatedOffer().getSpecimen().getClone());
        assertNotNull(rTrade.getInitiatedOffer().getSpecimen().getClone().getSex());
        assertNotNull(rTrade.getInitiatedOffer().getSpecimen().getClone().getLabel());
        assertNotNull(rTrade.getInitiatedOffer().getSpecimen().getClone().getLocation());
        assertNotNull(rTrade.getInitiatedOffer().getSpecimen().getClone().getSex());

        assertNotNull(rTrade.getRequestedOffer());
        assertNotNull(rTrade.getRequestedOffer().getSpecimen());
        assertNotNull(rTrade.getRequestedOffer().getSpecimen().getClone());
        assertNotNull(rTrade.getRequestedOffer().getSpecimen().getClone().getSex());
        assertNotNull(rTrade.getRequestedOffer().getSpecimen().getClone().getLabel());
        assertNotNull(rTrade.getRequestedOffer().getSpecimen().getClone().getLocation());
        assertNotNull(rTrade.getRequestedOffer().getSpecimen().getClone().getSex());












    }

        @Test
    public void findAllTradesByUserTest() {



        TradeStartDate container = new TradeStartDate();

        Trade trade1;
        Trade trade2;
        List<TradeStartDate> tradesUser1;
        List<TradeStartDate> tradesUser2;
        List<TradeStartDate> tradesUser3;

        trade1 = new Trade(
                updateOfferVersion(offerUser1),
                updateOfferVersion(offerUser2));
        trade2 = new Trade(
                updateOfferVersion(offerUser1),
                updateOfferVersion(offerUser3));

        container.addTrade(trade1);
        container.addTrade(trade2);
        this.tradeStartDateRepository.save(container);


        tradesUser1 = this.tradeStartDateRepository.getTradesByUsernameAndDates(offerUser1.getUser().getUsername(),List.of(container.getMonthYearId()));
        tradesUser2 = this.tradeStartDateRepository.getTradesByUsernameAndDates(offerUser2.getUser().getUsername(),List.of(container.getMonthYearId()));
        tradesUser3 = this.tradeStartDateRepository.getTradesByUsernameAndDates(offerUser3.getUser().getUsername(),List.of(container.getMonthYearId()));

        assertNotNull(tradesUser1);
        assertNotNull(tradesUser2);
        assertNotNull(tradesUser3);

        assertEquals(2,tradesUser1.get(0).getTrades().size());
        assertEquals(1,tradesUser2.get(0).getTrades().size());
        assertEquals(1,tradesUser3.get(0).getTrades().size());



    }


    private PollenOffer updateOfferVersion(PollenOffer pollenOffer){
        Optional<PollenOffer> pollenOffer1= this.pollenOfferRepository.findById(pollenOffer.getUuid());
        if(pollenOffer1.isPresent()){
            return pollenOffer1.get();

        }else {
            return pollenOffer;
        }

    }

    private Specimen updateEntityVersion(Specimen specimen) {
        return testDataInserter.getUpdatedSpecimenVersion(specimen);
    }
}
