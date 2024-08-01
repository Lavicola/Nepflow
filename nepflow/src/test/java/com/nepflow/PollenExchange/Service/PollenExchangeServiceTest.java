package com.nepflow.PollenExchange.Service;

import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
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
    PollenExchangeTestDataInserter testDataInserter;

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
            this.testDataInserter.insertData();
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


    @Test
    @Transactional
    public void createPollenOfferTest() {

        PollenOffer icPollenOffer;
        icPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(testDataInserter.user1));

        assertEquals(icPollenOffer.getSpecimen(), testDataInserter.user1Specimen3Female);
        assertEquals(testDataInserter.user1, icPollenOffer.getUser());
        assertEquals(LocalDate.now(), icPollenOffer.getStartDate());
        assertEquals(1, this.pollenOfferRepository.findAll().size());


    }


    @Test
    @Transactional
    public void createPollenOfferTestIfSpecimenNoSex() {

        PollenOffer icPollenOffer;
        icPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen1NoSex),
                testDataInserter.updateUserVersion(testDataInserter.user1));

        assertNull(icPollenOffer);


    }


    @Test
    @Transactional
    public void closePollenOfferTest() {
        User user1 = testDataInserter.user1;

        PollenOffer icPollenOffer;
        PollenOffer icPollenOfferClosed;

        icPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male),
                testDataInserter.updateUserVersion(user1));
        icPollenOfferClosed = this.pollenExchangeService.closePollenOffer(
                icPollenOffer.getSpecimen(),
                testDataInserter.updateUserVersion(user1));

        assertEquals(icPollenOffer, icPollenOfferClosed);
        assertEquals(icPollenOffer.getSpecimen(), testDataInserter.user1Specimen2Male);
        assertEquals(testDataInserter.user1, icPollenOffer.getUser());
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
        User user1 = testDataInserter.user1;
        PollenOffer opened;
        PollenOffer closed;
        PollenOffer reOpened;

        opened = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1));
        closed = this.pollenExchangeService.closePollenOffer(opened.getSpecimen(),
                testDataInserter.updateUserVersion(user1));
        reOpened = this.pollenExchangeService.createOrReOpenPollenOffer(opened.getSpecimen(),
                testDataInserter.updateUserVersion(user1));


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
        User user1 = testDataInserter.user1;
        User user2 = testDataInserter.user2;


        List<PollenOffer> pollenOffersOtherUserList;
        List<PollenOffer> allPollenOffers;
        List<PollenOffer> allFemalePollenOffers;


        this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1));
        this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male),
                testDataInserter.updateUserVersion(user1));
        this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen3Female),
                testDataInserter.updateUserVersion(user2));
        this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen2Male),
                testDataInserter.updateUserVersion(user2));


        pollenOffersOtherUserList = this.pollenOfferRepository.getAllOpenPollenOffersBySexExceptOwn(
                testDataInserter.user1.getUsername(),
                testDataInserter.user1Specimen3Female.getSexAsString());
        allFemalePollenOffers = this.pollenOfferRepository.getAllOpenPollenOffersBySexExceptOwn(
                testDataInserter.user1.getUsername() + "ddd",
                testDataInserter.user2Specimen2Male.getSexAsString());
        allPollenOffers = this.pollenOfferRepository.findAll();

        assertEquals(1, pollenOffersOtherUserList.size(), "Only one different Users owns a female specimen and therefore  the Result  should  be  1");
        assertEquals(2, allFemalePollenOffers.size(), "Two Users have one female  PollenOffers  there  this should return 2");
        assertEquals(4, allPollenOffers.size(), "4 PollenOffer should exists");


    }


    /**
     * Prevent creation of duplicate PollenOffers where Specimen is the same
     **/
    @Test
    @Transactional
    public void duplicatePollenOfferTest() {
        User user1 = testDataInserter.user1;
        PollenOffer pollenOffer;
        PollenOffer pollenOfferDuplicate;

        pollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1));
        pollenOfferDuplicate = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1));

        assertNotNull(pollenOffer);
        assertNull(pollenOfferDuplicate);

    }

    /**
     * Test what happens if a specimen which does not belong to an user is used to create a PollenOffer
     */
    @Test
    public void wrongSpecimenAndUserTest() {
        User user1 = testDataInserter.user1;
        User user2 = testDataInserter.user2;
        PollenOffer pollenOffer;
        PollenOffer pollenOfferWrongSpecimen;

        pollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1));
        pollenOfferWrongSpecimen = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male),
                testDataInserter.updateUserVersion(user2));

        assertNotNull(pollenOffer);
        assertNull(pollenOfferWrongSpecimen);


    }

    /**
     * This Test tries to open a Trade
     **/
    @Test
    public void openTradeTest() {
        PollenOffer initiatedOffer;
        PollenOffer requestedOffer;
        User initiatedUser = testDataInserter.user1;
        User requestedUser = testDataInserter.user2;
        Trade trade;
        initiatedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(initiatedUser));
        requestedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen2Male),
                testDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(
                testDataInserter.updateUserVersion(initiatedUser), initiatedOffer.getUuid(), requestedOffer.getUuid());

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
        User initiatedUser = testDataInserter.user1;
        User requestedUser = testDataInserter.user2;
        Trade trade;
        initiatedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(initiatedUser));
        requestedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen2Male),
                testDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(testDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer.getUuid(), requestedOffer.getUuid());
        trade = this.pollenExchangeService.refuseTrade(
                testDataInserter.updateUserVersion(requestedUser), trade.getUuid());

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
        User initiatedUser = testDataInserter.user1;
        User requestedUser = testDataInserter.user2;
        Trade trade;
        initiatedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(initiatedUser));
        requestedOffer = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen2Male),
                testDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(testDataInserter.updateUserVersion(initiatedUser)
                , initiatedOffer.getUuid(), requestedOffer.getUuid());
        trade = this.pollenExchangeService.acceptTrade(testDataInserter.updateUserVersion(requestedUser), trade.getUuid());

        assertNotNull(trade);
        assertTrue(trade.wasTradeAccepted());
        assertEquals(trade.getInitiatedOffer(), initiatedOffer);
        assertEquals(trade.getRequestedOffer(), requestedOffer);
        assertEquals(trade.getUserWhoInitiatedTrade(), initiatedUser);
        assertEquals(trade.getUserWhoAnswersTrade(), requestedUser);

    }

    /**
     * This Test makes sure, that the amount of Trades the User initiated is right
     **/
    @Test
    public void getInitiatedTradesTest() {
        List<PollenOffer> offers = new ArrayList<>(2);
        PollenOffer offeree;
        List<Trade> initiatedTrades;

        User initiatedUser = testDataInserter.user1;
        User requestedUser = testDataInserter.user2;
        Trade trade;
        Trade trade1;
        offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(initiatedUser)));
        offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male),
                testDataInserter.updateUserVersion(initiatedUser)));

        offeree = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen3Female),
                testDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(testDataInserter.updateUserVersion(initiatedUser)
                , offers.get(0).getUuid(), offeree.getUuid());
        trade1 = this.pollenExchangeService.openTrade(testDataInserter.updateUserVersion(initiatedUser)
                , offers.get(1).getUuid(), offeree.getUuid());
        initiatedTrades = this.tradeRepository.findInitiatedTrades(initiatedUser.getOAuthId());

        assertNotNull(trade);
        assertEquals(2, initiatedTrades.size());
        assertTrue(initiatedTrades.contains(trade));
        assertTrue(initiatedTrades.contains(trade1));
        assertTrue(offers.contains(trade.getInitiatedOffer()));
        assertTrue(offers.contains(trade1.getInitiatedOffer()));
        assertTrue(offeree.equals(trade.getRequestedOffer()));
        assertTrue(offeree.equals(trade1.getRequestedOffer()));


    }

    /**
     * Test if the amount of (requested) Trades the user got is right
     **/
    @Test
    public void getRequestedTradesTest() {
        List<PollenOffer> offers = new ArrayList<>(2);
        PollenOffer offeree;
        List<Trade> initiatedTrades;

        User initiatedUser = testDataInserter.user1;
        User requestedUser = testDataInserter.user2;
        Trade trade;
        Trade trade1;
        offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(initiatedUser)));
        offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male),
                testDataInserter.updateUserVersion(initiatedUser)));

        offeree = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen3Female),
                testDataInserter.updateUserVersion(requestedUser));

        trade = this.pollenExchangeService.openTrade(testDataInserter.updateUserVersion(initiatedUser)
                , offers.get(0).getUuid(), offeree.getUuid());
        trade1 = this.pollenExchangeService.openTrade(testDataInserter.updateUserVersion(initiatedUser)
                , offers.get(1).getUuid(), offeree.getUuid());
        initiatedTrades = this.tradeRepository.findRequestedTrades(requestedUser.getOAuthId());

        assertNotNull(trade);
        assertEquals(2, initiatedTrades.size());
        assertTrue(initiatedTrades.contains(trade));
        assertTrue(initiatedTrades.contains(trade1));
        assertTrue(offers.contains(trade.getInitiatedOffer()));
        assertTrue(offers.contains(trade1.getInitiatedOffer()));
        assertTrue(offeree.equals(trade.getRequestedOffer()));
        assertTrue(offeree.equals(trade1.getRequestedOffer()));
    }


    /**
     * Test if the amount of (requested) Trades the user got is right, user1 is of interested
     **/
    @Test
    public void getAllTradesFromUserTest() {
        // we care about user1 trades
        User user1 = testDataInserter.user1;
        User user2 = testDataInserter.user2;
        User user3 = testDataInserter.user3;
        List<PollenOffer> user1Offers = new ArrayList<>(2);
        List<PollenOffer> user2Offers = new ArrayList<>(2);
        List<PollenOffer> user3Offers = new ArrayList<>(2);
        List<Trade> tradesOfInterest = new ArrayList<>(2);
        List<Trade> dontCareTrade = new ArrayList<>(1);
        List<Trade> rTradesFromUser;
        List<Trade> allTrades;

        user1Offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1)));
        user1Offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen2Male),
                testDataInserter.updateUserVersion(user1)));

        user2Offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen3Female),
                testDataInserter.updateUserVersion(user2)));
        user2Offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen2Male),
                testDataInserter.updateUserVersion(user2)));

        user3Offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user3Specimen3Female),
                testDataInserter.updateUserVersion(user3)));
        user3Offers.add(this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user3Specimen2Male),
                testDataInserter.updateUserVersion(user3)));

        tradesOfInterest.add(this.pollenExchangeService.openTrade(
                testDataInserter.updateUserVersion(user1),
                user1Offers.get(0).getUuid(), user2Offers.get(1).getUuid()));
        tradesOfInterest.add(
                this.pollenExchangeService.openTrade(
                        testDataInserter.updateUserVersion(user3),
                        user3Offers.get(1).getUuid(), user1Offers.get(0).getUuid()));
        dontCareTrade.add(
                this.pollenExchangeService.openTrade(
                        testDataInserter.updateUserVersion(user3),
                        user3Offers.get(1).getUuid(), user2Offers.get(0).getUuid()));

        rTradesFromUser = this.pollenExchangeService.getAllTradesFromUser(user1.getOAuthId());
        allTrades = this.tradeRepository.findAll();

        assertEquals(tradesOfInterest.size(), rTradesFromUser.size());
        assertEquals(allTrades.size(), dontCareTrade.size() + tradesOfInterest.size());
        assertTrue(tradesOfInterest.contains(rTradesFromUser.get(0)));
        assertTrue(tradesOfInterest.contains(rTradesFromUser.get(1)));
        // we dont know the order, therefore check both
        assertTrue(
                tradesOfInterest.get(0).getInitiatedOffer().equals(rTradesFromUser.get(0).getInitiatedOffer())
                        ||
                        tradesOfInterest.get(1).getInitiatedOffer().equals(rTradesFromUser.get(0).getInitiatedOffer())
        );
        assertTrue(
                tradesOfInterest.get(0).getRequestedOffer().equals(rTradesFromUser.get(0).getRequestedOffer())
                        ||
                        tradesOfInterest.get(1).getRequestedOffer().equals(rTradesFromUser.get(0).getRequestedOffer())
        );
        assertTrue(
                tradesOfInterest.get(0).getUserWhoInitiatedTrade().equals(rTradesFromUser.get(0).getUserWhoInitiatedTrade())
                        ||
                        tradesOfInterest.get(1).getUserWhoInitiatedTrade().equals(rTradesFromUser.get(0).getUserWhoInitiatedTrade())
        );
        assertTrue(
                tradesOfInterest.get(0).getUserWhoAnswersTrade().equals(rTradesFromUser.get(0).getUserWhoAnswersTrade())
                        ||
                        tradesOfInterest.get(1).getUserWhoAnswersTrade().equals(rTradesFromUser.get(0).getUserWhoAnswersTrade())
        );


    }


    @Test
    public void  PollenOfferStartDateAddTest(){
        PollenOffer pollenOffer1;
        PollenOffer pollenOffer2;
        List<PollenOfferStartDate> pollenOfferStartDates;
        List<LocalDate> dates = new ArrayList<>(1);
        User user1 = testDataInserter.user1;
        User user2 = testDataInserter.user2;
        dates.add(LocalDate.now());
        pollenOffer1 = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user1Specimen3Female),
                testDataInserter.updateUserVersion(user1));
        pollenOffer2 = this.pollenExchangeService.createOrReOpenPollenOffer(
                testDataInserter.getUpdatedSpecimenVersion(testDataInserter.user2Specimen2Male),
                testDataInserter.updateUserVersion(user2));
        pollenOfferStartDates = this.pollenExchangeService.getPollenOffersByDates(dates);

        assertTrue(pollenOfferStartDates.get(0).getPollenOffers().contains(pollenOffer1));
        assertTrue(pollenOfferStartDates.get(0).getPollenOffers().contains(pollenOffer2));



    }




}