package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.TradeStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to retrieve and save Trades by Months.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface TradeStartDateRepository extends Neo4jRepository<TradeStartDate, String> {


    /**
     * @param username username
     * @param dates    dates in Format MM-yyyy
     * @return List of TradeStartDate containing all Trades from a user
     */
    @Query("MATCH (startDates:TradeStartDate)<-[opened:OPENED_IN]-(trades)-[i:OFFERS|WANTS]->(offer:PollenOffer)-[flower:FLOWERS|HAS_FLOWERED]->(s)-[grows:GROWS_BY]->(userInQuestion{username:$username})-[userRel]->(userNodes)\n" +
            "WHERE startDates.MonthYearId IN $dates\n" +
            "WITH *\n" +
            "MATCH (s)-[instance:INSTANCE_OF]-(clone:Clone)-[relations]->(entities)\n" +
            "WITH *\n" +
            "MATCH  (trades)-[ii:INITIATED|NEEDS_TO_ANSWER]->(userInQuestion)\n" +
            "WITH *\n" +
            "MATCH  (trades)-[i2:OFFERS|WANTS]->(otherOffer:PollenOffer)-[flower2:FLOWERS|HAS_FLOWERED]->(specimen2:Specimen)-[grows2:GROWS_BY]->(otherUser)-[userRel2]->(userNodes2)\n" +
            "WITH *\n" +
            "MATCH  (specimen2)-[instance2:INSTANCE_OF]-(clone2:Clone)-[relations2]->(entities2)\n" +
            "WITH  *\n" +
            "MATCH  (trades)-[a:INITIATED|NEEDS_TO_ANSWER]->(otherUser)\n" +
            "RETURN \n" +
            "startDates ,\n" +
            "    Collect(opened) ,\n" +
            "    Collect(trades) ,\n" +
            "    Collect(i),\n" +
            "    Collect(ii),Collect(a),Collect(s),Collect(grows),\n" +
            "    Collect(offer),\n" +
            "    Collect(userInQuestion),\n" +
            "    Collect(userRel),\n" +
            "    Collect(userNodes),\n" +
            "    COLLECT(flower),\n" +
            "    COLLECT(instance),\n" +
            "    COLLECT(relations),\n" +
            "    COLLECT(clone),\n" +
            "    COLLECT(entities),\n" +
            "    COLLECT(i2),\n" +
            "    Collect(userRel2),\n" +
            "    Collect(userNodes2),\n" +
            "    COLLECT(otherUser), \n" +
            "    COLLECT(otherOffer),\n" +
            "    COLLECT(grows),COLLECT(grows2),\n" +
            "    COLLECT(flower2),\n" +
            "    COLLECT(specimen2), \n" +
            "    COLLECT(instance2),\n" +
            "    COLLECT(relations2),\n" +
            "    COLLECT(clone2),\n" +
            "    COLLECT(entities2)"
    )
    List<TradeStartDate> getTradesByUsernameAndDates(String username, List<String> dates);


    /**
     * @return all stored Dates in Format MM-yyyy
     */
    @Query("match(p:TradeStartDate) return p.MonthYearId")
    List<String> getTradeDates();

}
