package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to retrieve and save Pollenoffers by Months.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface PollenOfferStartDateRepository extends Neo4jRepository<PollenOfferStartDate, String> {

    /**
     * @param dates     dates in Format MM-yyyy
     * @param usernames usernames to exclude
     * @return List of PollenOfferStartDate containing Pollenoffers
     */
    @Query("MATCH (startDates:PollenOfferStartDate)<-[posted:POSTED_IN]-(offer:PollenOffer)-[flower:FLOWERS|HAS_FLOWERED]->(specimen)-[grows:GROWS_BY]->(userss:User)-[userRel]->(userNodes)\n" +
            "WHERE startDates.MonthYearId IN $dates AND NOT userss.username IN $usernames\n" +
            "\n" +
            "WITH *\n" +
            "MATCH  (specimen)-[instance:INSTANCE_OF]-(clone:Clone)-[relations]->(entities)\n" +
            "RETURN\n" +
            "startDates,\n" +
            "Collect(posted),\n" +
            "Collect(offer),\n" +
            "COLLECT(grows),\n" +
            "Collect(userss),\n" +
            "Collect(flower),\n" +
            "Collect(specimen),\n" +
            "Collect(instance),\n" +
            "Collect(clone),\n" +
            "Collect(relations),\n" +
            "Collect(entities),\n" +
            "Collect(userRel),\n" +
            "Collect(userNodes)\n")
    List<PollenOfferStartDate> getAllOpenPollenOffersUsingDatesAndExcludeUsers(List<String> dates, List<String> usernames);


    /**
     * @return all stored Dates in Format MM-yyyy
     */
    @Query("match(p:PollenOfferStartDate) return p.MonthYearId")
    List<String> getPollenOfferStartDates();

}
