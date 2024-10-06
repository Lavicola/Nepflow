package com.nepflow.PollenExchange.Repository;


import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Projection.TradeStatus;
import com.nepflow.PollenExchange.Projection.UserRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository mainly used to check for reverse Trades.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface TradeRepository extends Neo4jRepository<Trade, String> {


    /**
     * @param offerId  id of first Pollenoffer
     * @param offerId2 id of second Pollenoffer
     * @return true if either the exact trade exists or the reverse
     */
    @Query("Return EXISTS {\n" +
            "match(p:PollenOffer) -- (t:Trade) -- (p2:PollenOffer)\n" +
            "WHERE \n" +
            "    elementId(p) = $offerId \n" +
            "        AND elementId(p2) = $offerId2 \n" +
            "} as result\n")
    boolean tradeOrReverseTradeExists(String offerId, String offerId2);


    /**
     * @param username username of the User
     * @return List of all Trades and Ratings references from a User
     */
    @Query("match(t:Trade)-[r]->(tr:TradeRating)-[ru]->(u:User{username:$username})\n" +
            "return t, collect(r),collect(tr),collect(ru),collect(u)\n")
    List<Trade> getTradesWithTradeRatingsByUsername(String username);

    /**
     * @param username username of the User where the TradeRate reference is needed
     * @return List of all Trades(+ their references) the user needs to rate.
     */
    @Query("MATCH \n" +
            "(trade)-[tradeUserSelf]->(userSelf:User {username: $username}) <-[userRating]- (rating:TradeRating {rating: 'PENDING'}) <-[tradeRatingNeeded]- (trade:Trade)-[tradeUserOther]->(userOther:User)\n" +
            "WITH *\n" +
            "MATCH\n" +
            "(trade)-[tradeOfferSelf]->(offerSelf:PollenOffer)-[offerSpecimenSelf]->(specimenSelf:Specimen)-[specimenUserSelf]->(userSelf)\n" +
            "MATCH\n" +
            "(specimenSelf)-[specimenCloneSelf]->(cloneSelf:Clone)-[cloneSelfRel]->(cloneSelfNodes)  \n" +
            "WITH *\n" +
            "MATCH\n" +
            "(trade)-[tradeOfferOther]->(offerOther:PollenOffer)-[offerSpecimenOther]->(specimenOther:Specimen)-[specimenUserOther]->(userOther)\n" +
            "MATCH\n" +
            "(specimenOther)-[specimenCloneOther]->(cloneOther:Clone)-[cloneOtherRel]->(cloneOtherNodes)  \n" +
            "MATCH\n" +
            "(userSelf)-[countryUserSelf]->(countrySelf:Country)" +
            "MATCH\n" +
            "(userOther)-[countryUserOther]->(countryOther:Country)" +
            "RETURN trade,userSelf,rating,tradeUserSelf,userRating,tradeRatingNeeded,tradeUserOther,userOther," +
            "tradeOfferSelf,offerSelf,offerSpecimenSelf,specimenSelf,specimenUserSelf," +
            "specimenCloneSelf, cloneSelf,COLLECT(DISTINCT cloneSelfRel), COLLECT(DISTINCT cloneSelfNodes)," +
            "tradeOfferOther,offerOther,offerSpecimenOther,specimenOther,specimenUserOther,\n" +
            "specimenCloneOther, cloneOther,COLLECT(DISTINCT cloneOtherRel), COLLECT(DISTINCT cloneOtherNodes)," +
            "countryUserSelf,countrySelf,countryUserOther,countryOther")
    List<Trade> getTradesUserNeedsToRate(String username);


    /**
     * @param username username of the user to get the received ratings
     * @return TradeStatus which contains the status for a specific User
     */
    @Query(value = "match(userOther:User)<--(t:Trade) -->(userSelf:User{username:$username}) \n \n" +
            "WITH userOther,t\n" +
            "match (t)-->(tr:TradeRating)-->(userOther)" +
            "return  t, elementId(t) as tradeId," +
            "tr.rating as rating, tr.creationDate as creationDate " +
            "\n")
    List<TradeStatus> getReceivedRatingsStatus(String username);


    /**
     * @param username username of the user to get the received ratings
     * @param pageable pageable
     * @return Page of UserRating
     */
    @Query(value = "match(userOther:User)<--(t:Trade) -->(userSelf:User{username:$username}) \n \n" +
            "WITH userOther,t\n" +
            "match (t)-->(tr:TradeRating)-->(userOther)" +
            "return  t, elementId(t) as tradeId," +
            "userOther.username as rater,tr as rating " +
            "SKIP $skip LIMIT $limit" +
            "\n",
            countQuery = "match(userOther:User)<--(t:Trade) -->(userSelf:User{username:$username}) \n \n" +
                    "WITH userOther,t\n" +
                    "match (t)-->(tr:TradeRating)-->(userOther)" +
                    "return  count(t)" +
                    "\n")
    Page<UserRating> getReceivedRatings(String username, Pageable pageable);

}
