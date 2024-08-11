package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollenOfferStartDateRepository extends Neo4jRepository<PollenOfferStartDate, String> {

    @Query("MATCH (startDates:PollenOfferStartDate)<-[posted:POSTED_IN]-(offer:PollenOffer)-[published:PUBLISHED_BY]->(userss)-[userRel]->(userNodes)\n" +
            "WHERE NOT ANY(x IN $usernames WHERE x  IN userss.username) AND startDates.MonthYearId IN $dates\n" +
            "WITH *\n" +
            "MATCH  (offer)-[flower:FLOWERS]->(specimen)-[instance:INSTANCE_OF]-(clone:Clone)-[relations]->(entities)\n" +
            "\n" +
            "RETURN\n" +
            "startDates,\n" +
            "Collect(posted),\n" +
            "Collect(offer),\n" +
            "Collect(published),\n" +
            "Collect(userss),\n" +
            "Collect(flower),\n" +
            "Collect(specimen),\n" +
            "Collect(instance),\n" +
            "Collect(clone),\n" +
            "Collect(relations),\n" +
            "Collect(entities),\n" +
            "Collect(userRel),\n" +
            "Collect(userNodes)\n")
    List<PollenOfferStartDate> getAllOpenPollenOffersUsingDatesAndExcludeUsers(List<String> dates,List<String>  usernames);



    @Query("match(p:PollenOfferStartDate) return p.MonthYearId")
    List<String> getPollenOfferStartDates();

}
