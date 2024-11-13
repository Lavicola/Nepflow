
package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.PollenExchange.Dto.RatingDTO;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeRating;
import com.nepflow.PollenExchange.PollenExchangeTestDataInserter;
import com.nepflow.PollenExchange.Repository.PollenOfferRepository;
import com.nepflow.PollenExchange.Repository.PollenOfferStartDateRepository;
import com.nepflow.PollenExchange.Repository.TradeRepository;
import com.nepflow.PollenExchange.Repository.TradeStartDateRepository;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    PollenOfferStartDateRepository pollenOfferStartDateRepository;

    @Autowired
    PollenOfferRepository pollenOfferRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    TradeStartDateRepository tradeStartDateRepository;

    @Autowired
    PollenExchangeTestDataInserter testDataInserter;

    @Autowired
    SpecimenRepository specimenRepository;


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
            //   this.testDataInserter.insertData();
            executedOnce = true;
        }
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
    @Transactional
    public void createNewPollenOfferTest() {
        Specimen specimen = updateEntityVersion(this.testDataInserter.user3Specimen2Male);
        PollenOffer pollenOffer = pollenExchangeService.createNewPollenOffer(specimen);

        assertNotNull(pollenOffer);
        assertEquals(1, this.pollenOfferRepository.findAll().size());

    }


    @Test
    @Transactional
    public void closePollenOfferTest() {
        Specimen specimen = updateEntityVersion(testDataInserter.user1Specimen2Male);
        PollenOffer pollenOffer = new PollenOffer(specimen);
        this.pollenOfferRepository.save(pollenOffer);
        PollenOffer rPollenOffer = this.pollenExchangeService.closePollenOffer(pollenOffer.getSpecimen());

        assertNotNull(rPollenOffer);
        assertFalse(rPollenOffer.isOpen());
        assertTrue(rPollenOffer.isPollenOfferValid());

    }

    /**
     * The first case: A PollenOffer for this specimen does not exist and therefore gets created
     */

    @Test
    @Transactional
    public void createOrReOpenPollenOfferNoOfferAtFirstTest() {
        Specimen specimen = updateEntityVersion(testDataInserter.user3Specimen2Male);
        PollenOffer pollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(specimen);

        assertTrue(pollenOffer.isOpen());
        assertTrue(pollenOffer.isPollenOfferValid());
        assertEquals(1, this.pollenOfferRepository.findAll().size());
        assertEquals(pollenOffer, this.pollenOfferRepository.findAll().get(0));

    }

    /**
     * The second case: A PollenOffer for this specimen exists but is closed
     * and therefore the PollenOffer must be opened
     */

    @Test
    @Transactional
    public void createOrReOpenPollenOfferExistingOfferClosed() {
        Specimen specimen = updateEntityVersion(testDataInserter.user2Specimen3Female);
        PollenOffer rPollenOffer;
        PollenOffer pollenOffer = new PollenOffer(specimen);
        pollenOffer.closePollenOffer();
        this.pollenOfferRepository.save(pollenOffer);
        rPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(specimen);
        assertNotNull(rPollenOffer);
        assertTrue(rPollenOffer.isPollenOfferValid());
        assertTrue(rPollenOffer.isOpen());
        assertEquals(rPollenOffer, pollenOffer);

    }

    /**
     * The third case: A PollenOffer for this specimen exists but is expired
     * and therefore a new PollenOffer must be created
     */

    @Test
    @Transactional
    public void createOrReOpenPollenOfferExistingButExpiredOfferClosed() {


        PollenOffer newPollenOffer;
        LocalDate nextOfferDate = LocalDate.now().plusDays(21);

        Specimen specimen = updateEntityVersion(testDataInserter.user2Specimen3Female);
        PollenOffer pollenOffer = new PollenOffer(specimen);
        pollenOffer.closePollenOffer();

        this.pollenOfferRepository.save(pollenOffer);
        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(nextOfferDate);
            newPollenOffer = this.pollenExchangeService.createOrReOpenPollenOffer(pollenOffer.getSpecimen());
        }

        assertNotEquals(pollenOffer, newPollenOffer);
        assertEquals(2, this.pollenOfferRepository.findAll().size());

    }

    @Test
    @Transactional
    public void addPollenOfferToMonthYearContainerTest() {
        Specimen specimen = updateEntityVersion(testDataInserter.user2Specimen3Female);
        PollenOffer pollenOffer = new PollenOffer(specimen);
        pollenExchangeService.addPollenOfferToMonthYearContainer(pollenOffer);

        assertEquals(1, this.pollenOfferRepository.findAll().size());
        assertEquals(1, this.pollenOfferStartDateRepository.findAll().size());
        assertEquals(this.pollenOfferRepository.findAll().size(), this.pollenOfferStartDateRepository.findAll().get(0).getPollenOffers().size());

    }

    @Test
    @Transactional
    public void getAllDatesPollenOfferTest() {
        LocalDate nextOfferDate = LocalDate.now().plusMonths(1);
        PollenOfferStartDate offerStartDate = new PollenOfferStartDate();
        PollenOfferStartDate nextMonth;
        List<String> dates;

        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(nextOfferDate);
            nextMonth = new PollenOfferStartDate();

        }
        this.pollenOfferStartDateRepository.save(offerStartDate);
        this.pollenOfferStartDateRepository.save(nextMonth);
        dates = this.pollenExchangeService.getAllDatesPollenOffer();

        assertEquals(2, dates.size());
        assertTrue(dates.contains(offerStartDate.getMonthYearId()));
        assertTrue(dates.contains(nextMonth.getMonthYearId()));


    }

    @Test
    @Transactional
    public void openTradeTest() {
        PollenOffer offer = this.pollenExchangeService.createOrReOpenPollenOffer(updateEntityVersion(testDataInserter.user2Specimen2Male));
        PollenOffer offer2 = this.pollenExchangeService.createOrReOpenPollenOffer(updateEntityVersion(testDataInserter.user3Specimen3Female));

        Trade trade = this.pollenExchangeService.openTrade(offer.getUser(), offer.getUuid(), offer2.getUuid());

        assertNotNull(trade);
        assertEquals(1, this.tradeRepository.findAll().size());
        assertEquals(trade.getUserWhoInitiatedTrade(), offer.getUser());
        assertEquals(trade.getUserWhoAnswersTrade(), offer2.getUser());
        assertEquals(trade.getInitiatedOffer(), offer);
        assertEquals(trade.getRequestedOffer(), offer2);

    }

    @Test
    @Transactional
    public void addTradeToMonthYearContainerTest() {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        Trade tradeNextMonth;
        Specimen specimenUser2Female = updateEntityVersion(testDataInserter.user2Specimen3Female);
        Specimen specimenUser1Male = updateEntityVersion(testDataInserter.user2Specimen2Male);
        PollenOffer pollenOffer1 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen2Male));
        pollenOffer1 = this.pollenOfferRepository.save(pollenOffer1);
        PollenOffer pollenOffer2 = new PollenOffer(updateEntityVersion(testDataInserter.user3Specimen3Female));
        pollenOffer2 = this.pollenOfferRepository.save(pollenOffer2);
        // retrieve the PollenOffer since in a Trade creation the  offer version will always be retrieved
        // otherwise Optimistic Locking
        Trade tradeThisMonth = new Trade(
                this.pollenOfferRepository.findById(pollenOffer1.getUuid()).get(),
                this.pollenOfferRepository.findById(pollenOffer2.getUuid()).get());

        pollenExchangeService.addTradeToMonthYearContainer(tradeThisMonth);

        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(nextMonth);
            pollenOffer1 = new PollenOffer(updateEntityVersion(specimenUser1Male));
            pollenOffer1 = this.pollenOfferRepository.save(pollenOffer1);
            pollenOffer2 = new PollenOffer(updateEntityVersion(specimenUser2Female));
            pollenOffer2 = this.pollenOfferRepository.save(pollenOffer2);
            // retrieve the PollenOffer since in a Trade creation the  offer version will always be retrieved
            // otherwise Optimistic Locking
            tradeNextMonth = new Trade(
                    this.pollenOfferRepository.findById(pollenOffer1.getUuid()).get(),
                    this.pollenOfferRepository.findById(pollenOffer2.getUuid()).get());
            pollenExchangeService.addTradeToMonthYearContainer(tradeNextMonth);

        }


        assertEquals(2, this.tradeStartDateRepository.findAll().size());
        assertEquals(2, this.tradeRepository.findAll().size());


    }

    @Test
    @Transactional
    public void refuseTradeTest() {
        PollenOffer pollenOffer1 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen2Male));
        pollenOffer1 = this.pollenOfferRepository.save(pollenOffer1);
        PollenOffer pollenOffer2 = new PollenOffer(updateEntityVersion(testDataInserter.user3Specimen3Female));
        pollenOffer2 = this.pollenOfferRepository.save(pollenOffer2);
        Trade trade = new Trade(
                this.pollenOfferRepository.findById(pollenOffer1.getUuid()).get(),
                this.pollenOfferRepository.findById(pollenOffer2.getUuid()).get());
        trade = this.tradeRepository.save(trade);
        trade = this.pollenExchangeService.refuseTrade(pollenOffer2.getUser(), trade.getUuid());

        assertTrue(trade.wasTradeRefused());
        assertEquals(1, tradeRepository.findAll().size());


    }

    @Test
    @Transactional
    public void acceptTradeTest() {
        PollenOffer pollenOffer1 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen2Male));
        pollenOffer1 = this.pollenOfferRepository.save(pollenOffer1);
        PollenOffer pollenOffer2 = new PollenOffer(updateEntityVersion(testDataInserter.user3Specimen3Female));
        pollenOffer2 = this.pollenOfferRepository.save(pollenOffer2);
        Trade trade = new Trade(
                this.pollenOfferRepository.findById(pollenOffer1.getUuid()).get(),
                this.pollenOfferRepository.findById(pollenOffer2.getUuid()).get());
        trade = this.tradeRepository.save(trade);
        trade = this.pollenExchangeService.acceptTrade(pollenOffer2.getUser(), trade.getUuid());
        assertTrue(trade.wasTradeAccepted());
        assertEquals(1, tradeRepository.findAll().size());
    }


    @Test
    @Transactional
    public void setRatingForTradeTest() {
        LocalDate timeToWaitForRate = LocalDate.now().plusDays(31);

        PollenOffer pollenOffer1;
        PollenOffer pollenOffer2;
        Trade trade;
        Trade tradeAfterRatingSave;
        TradeRating tradeRating;
        RatingDTO ratingDTO = new RatingDTO();
        String testComment = "test";

        ratingDTO.setComment(testComment);
        ratingDTO.setReviewType(TradeRating.RATING.SUCCESS);
        pollenOffer1 = new PollenOffer(updateEntityVersion(testDataInserter.user2Specimen2Male));
        pollenOffer1 = this.pollenOfferRepository.save(pollenOffer1);
        pollenOffer2 = new PollenOffer(updateEntityVersion(testDataInserter.user3Specimen3Female));
        pollenOffer2 = this.pollenOfferRepository.save(pollenOffer2);
        trade = new Trade(
                this.pollenOfferRepository.findById(pollenOffer1.getUuid()).get(),
                this.pollenOfferRepository.findById(pollenOffer2.getUuid()).get());
        trade.acceptTrade();
        trade = this.tradeRepository.save(trade);
        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(timeToWaitForRate);
            tradeRating = this.pollenExchangeService.setRatingForTrade(trade.getUuid(), ratingDTO.getComment(),
                    null, ratingDTO.getReviewType(), pollenOffer1.getUser());

        }

        tradeAfterRatingSave = this.tradeRepository.findById(trade.getUuid()).get();

        assertEquals(tradeRating.getUuid(), tradeAfterRatingSave.getRating(pollenOffer1.getUser()).getUuid());
        assertEquals(tradeRating.getRating(), tradeAfterRatingSave.getRating(pollenOffer1.getUser()).getRating());
        assertEquals(tradeRating.getComment(), tradeAfterRatingSave.getRating(pollenOffer1.getUser()).getComment());
    }


    private Specimen updateEntityVersion(Specimen specimen) {
        return testDataInserter.getUpdatedSpecimenVersion(specimen);
    }


}

