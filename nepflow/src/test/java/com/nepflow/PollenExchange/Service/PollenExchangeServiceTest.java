package com.nepflow.PollenExchange.Service;

import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.PollenExchangeTestDataInserter;
import com.nepflow.PollenExchange.Repository.PollenOfferRepository;
import com.nepflow.PollenExchange.Repository.TradeRepository;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PollenExchangeServiceTest {

    private static Neo4j embeddedDatabaseServer;

    @MockBean
    DataInitializationService dataInitializationService;

    @MockBean
    AuthenticationService authenticationService;

    @Autowired
    PollenExchangeService pollenExchangeService;

    @Autowired
    PollenOfferRepository pollenOfferRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    PollenExchangeTestDataInserter pollenExchangeTestDataInserter;

    static boolean executedOnce = false;


    @BeforeAll
    static void initializeNeo4j() {
        embeddedDatabaseServer = Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()
                .build();


    }

    @BeforeEach
    public void setUp() {
        if (!executedOnce) {
            this.pollenExchangeTestDataInserter.insertData();
            executedOnce = true;
        }
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


    /**
     * In order to create a PollenOfffer, it is necessary to create the User first (which usually happens in the frontend)
     * After that a new Clone can be created and added and after that a Specimen can be added to the User which can then be used to create a PollenOffer
     */
    @Test
    @Transactional
    public void createPollenOfferTest() {

        PollenOffer icPollenOffer;
        icPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(pollenExchangeTestDataInserter.user1));

        assertEquals(icPollenOffer.getSpecimen(), pollenExchangeTestDataInserter.user1Specimen);
        assertEquals(pollenExchangeTestDataInserter.user1, icPollenOffer.getUser());
        assertEquals(LocalDate.now(), icPollenOffer.getStartDate());
        assertEquals(1, this.pollenOfferRepository.findAll().size());


    }

    /**
     * In order to close a PollenOfffer, it is necessary to create the User first (which usually happens in the frontend)
     * After that a new Clone can be created and added and after that a Specimen can be added to the User which can then be used to create a PollenOffer
     * which can then be closed
     */
    @Test
    @Transactional
    public void closePollenOfferTest() {
        User user1 = pollenExchangeTestDataInserter.user1;

        PollenOffer icPollenOffer;
        PollenOffer icPollenOfferClosed;

        icPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(user1));
        icPollenOfferClosed = this.pollenExchangeService.closePollenOffer(icPollenOffer.getSpecimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));

        assertEquals(icPollenOffer, icPollenOfferClosed);
        assertEquals(icPollenOffer.getSpecimen(), pollenExchangeTestDataInserter.user1Specimen2);
        assertEquals(pollenExchangeTestDataInserter.user1, icPollenOffer.getUser());
        assertEquals(LocalDate.now(), icPollenOffer.getStartDate());
        assertEquals(1, this.pollenOfferRepository.findAll().size());


    }

    /**
     * In order to close a PollenOfffer, it is necessary to create the User first (which usually happens in the frontend)
     * After that a new Clone can be created and added and after that a Specimen can be added to the User which can then be used to create a PollenOffer
     * which can then be closed and opened again
     */
    @Test
    public void closeAndOpenPollenOfferTest() {
        User user1 = pollenExchangeTestDataInserter.user1;
        PollenOffer opened;
        PollenOffer closed;
        PollenOffer reOpened;

        opened = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.user1Specimen, pollenExchangeTestDataInserter.updateUserVersion(user1));
        closed = this.pollenExchangeService.closePollenOffer(opened.getSpecimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));
        reOpened = this.pollenExchangeService.createOrReOpenPollenOffer(opened.getSpecimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));


        assertNotNull(opened);
        assertNotNull(closed);
        assertNotNull(reOpened);

        assertEquals(opened, closed);
        assertEquals(opened, reOpened);
        assertEquals(closed, reOpened);


    }

    /**
     * Make sure that even if more users have the same specimen, that only the non owned PollenOffers are shown
     **/
    @Test
    @Transactional
    public void getPollenOffersVariantsTest() {
        User user1 = pollenExchangeTestDataInserter.user1;
        User user2 = pollenExchangeTestDataInserter.user2;


        List<PollenOffer> pollenOffersOtherUserList;
        List<PollenOffer> allPollenOffers;
        List<PollenOffer> allFemalePollenOffers;


        this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));
        this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(user1));
        this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen(), pollenExchangeTestDataInserter.updateUserVersion(user2));
        this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(user2));


        pollenOffersOtherUserList = this.pollenOfferRepository.getAllOpenPollenOffersBySexExceptOwn(pollenExchangeTestDataInserter.user1.getUsername(), pollenExchangeTestDataInserter.user1Specimen.getSexAsString());
        allFemalePollenOffers = this.pollenOfferRepository.getAllOpenPollenOffersBySexExceptOwn(pollenExchangeTestDataInserter.user1.getUsername() + "ddd", pollenExchangeTestDataInserter.user1Specimen.getSexAsString());
        allPollenOffers = this.pollenOfferRepository.findAll();

        assertEquals(1, pollenOffersOtherUserList.size(), "Only one different Users owns a female specimen and therefore  the Result  should  be  1");
        assertEquals(2, allFemalePollenOffers.size(), "Two Users have one female  PollenOffers  there  this should return 2");
        assertEquals(4, allPollenOffers.size(), "4 PollenOffer should exists");


    }


    /**
     * Prevent creation of duplicate PollenOffers where Specimen
     **/
    @Test
    @Transactional
    public void duplicatePollenOfferTest() {
        User user1 = pollenExchangeTestDataInserter.user1;
        PollenOffer pollenOffer;
        PollenOffer pollenOfferDuplicate;

        pollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));
        pollenOfferDuplicate = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));

        assertNotNull(pollenOffer);
        assertNull(pollenOfferDuplicate);

    }

    /**
     * Test what happens if a specimen  which does not belong to an user is used to create a PollenOffer
     */
    @Test
    public void wrongSpecimenAndUserTest() {
        User user1 = pollenExchangeTestDataInserter.user1;
        User user2 = pollenExchangeTestDataInserter.user2;
        PollenOffer pollenOffer;
        PollenOffer pollenOfferWrongSpecimen;

        pollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(user1));
        pollenOfferWrongSpecimen = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(user2));

        assertNotNull(pollenOffer);
        assertNull(pollenOfferWrongSpecimen);




    }

        /**
         * This Test tries to open a simple Trade
         **/
    @Test
    public void openTradeTest() {
        PollenOffer initiatedOffer;
        PollenOffer requestedOffer;
        User initiatedUser = pollenExchangeTestDataInserter.user1;
        User requestedUser = pollenExchangeTestDataInserter.user2;
        Trade trade;
        initiatedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser));
        requestedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen(), pollenExchangeTestDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer.getUuid(), requestedOffer.getUuid());

        assertNotNull(trade);
        assertEquals(trade.getInitiatedOffer(), initiatedOffer);
        assertEquals(trade.getRequestedOffer(), requestedOffer);
        assertEquals(trade.getUserWhoInitiatedTrade(), initiatedUser);
        assertEquals(trade.getUserWhoAnswersTrade(), requestedUser);

    }

    /**
     * This Test tries to refuse an open Trade
     **/
    @Test
    public void RefuseTradeTest() {
        PollenOffer initiatedOffer;
        PollenOffer requestedOffer;
        User initiatedUser = pollenExchangeTestDataInserter.user1;
        User requestedUser = pollenExchangeTestDataInserter.user2;
        Trade trade;
        initiatedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser));
        requestedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen(), pollenExchangeTestDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer.getUuid(), requestedOffer.getUuid());
        trade = this.pollenExchangeService.refuseTrade(pollenExchangeTestDataInserter.updateUserVersion(requestedUser), trade.getUuid());

        assertNotNull(trade);
        assertTrue(trade.wasTradeRefused());
        assertEquals(trade.getInitiatedOffer(), initiatedOffer);
        assertEquals(trade.getRequestedOffer(), requestedOffer);
        assertEquals(trade.getUserWhoInitiatedTrade(), initiatedUser);
        assertEquals(trade.getUserWhoAnswersTrade(), requestedUser);

    }

    /**
     * This Test tries to accept an open Trade
     **/
    @Test
    public void AcceptTradeTest() {
        PollenOffer initiatedOffer;
        PollenOffer requestedOffer;
        User initiatedUser = pollenExchangeTestDataInserter.user1;
        User requestedUser = pollenExchangeTestDataInserter.user2;
        Trade trade;
        initiatedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser));
        requestedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen(), pollenExchangeTestDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer.getUuid(), requestedOffer.getUuid());
        trade = this.pollenExchangeService.acceptTrade(pollenExchangeTestDataInserter.updateUserVersion(requestedUser), trade.getUuid());

        assertNotNull(trade);
        assertTrue(trade.wasTradeAccepted());
        assertEquals(trade.getInitiatedOffer(), initiatedOffer);
        assertEquals(trade.getRequestedOffer(), requestedOffer);
        assertEquals(trade.getUserWhoInitiatedTrade(), initiatedUser);
        assertEquals(trade.getUserWhoAnswersTrade(), requestedUser);

    }

    /**
     * This Test tries to accept an open Trade
     **/
    @Test
    public void getInitiatedTradesTest() {
        PollenOffer initiatedOffer1;
        PollenOffer initiatedOfferOtherUser;
        PollenOffer requestedOffer1;

        PollenOffer initiatedOffer2;
        List<Trade> initiatedTrades;

        User initiatedUser = pollenExchangeTestDataInserter.user1;
        User requestedUser = pollenExchangeTestDataInserter.user2;
        Trade trade;
        Trade trade1;
        initiatedOffer1 = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser));
        initiatedOffer2 = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser));
        initiatedOfferOtherUser = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser));

        requestedOffer1 = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer1.getUuid(), requestedOffer1.getUuid());
        trade1 = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer2.getUuid(), requestedOffer1.getUuid());
        initiatedTrades = this.tradeRepository.findInitiatedTrades(initiatedUser.getOAuthId());

        assertNotNull(trade);
        assertEquals(2, initiatedTrades.size());
        assertTrue(initiatedTrades.contains(trade));
        assertTrue(initiatedTrades.contains(trade1));


    }

    /**
     * This Test tries to accept an open Trade
     **/
    @Test
    public void getRequestTradesTest() {
        List<PollenOffer> initiatedOffers  = new ArrayList<>(2);
        PollenOffer initiatedOffer1;
        PollenOffer initiatedOffer2;
        PollenOffer requestedOffer1;

        List<Trade> initiatedTrades;

        User initiatedUser = pollenExchangeTestDataInserter.user1;
        User requestedUser = pollenExchangeTestDataInserter.user2;
        Trade trade;
        Trade trade1;
        initiatedOffers.add(this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)));
        initiatedOffers.add(this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser1Specimen2(), pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)));

        requestedOffer1 = this.pollenExchangeService.createOrReOpenPollenOffer(pollenExchangeTestDataInserter.getUser2Specimen(), pollenExchangeTestDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffers.get(0).getUuid(), requestedOffer1.getUuid());
        trade1 = this.pollenExchangeService.openTrade(pollenExchangeTestDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffers.get(1).getUuid(), requestedOffer1.getUuid());
        initiatedTrades = this.tradeRepository.findRequestedTrades(requestedUser.getOAuthId());

        assertNotNull(trade);
        assertEquals(2, initiatedTrades.size());
        assertTrue(initiatedTrades.contains(trade));
        assertTrue(initiatedTrades.contains(trade1));
        assertTrue(initiatedOffers.contains(trade.getInitiatedOffer()));
        assertTrue(initiatedOffers.contains(trade1.getInitiatedOffer()));
        assertTrue(requestedOffer1.equals(trade.getRequestedOffer()));
        assertTrue(requestedOffer1.equals(trade1.getRequestedOffer()));


    }

}