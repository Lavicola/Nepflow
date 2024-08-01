package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollenOfferStartDateRepository extends Neo4jRepository<PollenOfferStartDate, String> {

    @Query("match(a:PollenOfferStartDate)\n" +
            "WHERE ALL(x IN $dates WHERE x IN a.MonthYearId)\n" +
            "WITH a\n" +
            "match(a)<-[posted:POSTED_IN]-(pollenOffer)-[flowers:FLOWERS]->(specimen)-[i:INSTANCE_OF]->(clone)-[lab:CLONE_OF_SPECIES]-(labelname)\n" +
            "WITH a,posted,pollenOffer,flowers,specimen,i,clone,lab,labelname\n" +
            "match(pollenOffer)-[published:PUBLISHED_BY]->(user)-[living:LIVES_IN]->(country)\n" +
            "WITH a,posted,pollenOffer,flowers,specimen,i,clone,lab,labelname,published,user,living,country\n" +
            "\n" +
            "optional match(clone)-[loc:ORIGIN]->(location)\n" +
            "WITH a,posted,pollenOffer,flowers,specimen,i,clone,lab,labelname,loc,location,published,user,living,country\n" +
            "match(clone)-[s:HAS_SEX]->(sex:Sex)\n" +
            "WITH a,posted,pollenOffer,flowers,specimen,i,clone,lab,labelname,loc,location,published,user,living,country,s,sex\n" +
            "match(clone)-[oo]->(seller:Seller)\n" +
            "return a,COLLECT(posted),COLLECT(pollenOffer),COLLECT(flowers),COLLECT(specimen),COLLECT(i),COLLECT(clone),COLLECT(lab),COLLECT(labelname),COLLECT(loc),COLLECT(location),COLLECT(published),COLLECT(user),COLLECT(living),COLLECT(country),COLLECT(s),COLLECT(sex),COLLECT(oo),COLLECT(seller)\n")
    List<PollenOfferStartDate> getAllOpenPollenOffersUsingDates(List<String>  dates);



    @Query("match(p:PollenOfferStartDate) return p")
    List<PollenOfferStartDate> getPollenOfferStartDatesWithoutOffers();

}
