package com.nepflow.PollenExchange.Model;

import lombok.Getter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Node
public class PollenOfferStartDate {


    @Id
    @Getter
    String MonthYearId;

    @Relationship(value = "POSTED_IN",direction = Relationship.Direction.INCOMING)
    List<PollenOffer> pollenOffers = new ArrayList<>();

    @Transient
   private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");

    public PollenOfferStartDate(){
        this.MonthYearId = LocalDate.now().format(formatter);
    }

    public void addPollenOffer(PollenOffer pollenOffer){
        this.pollenOffers.add(pollenOffer);
    }

    public List<PollenOffer> getPollenOffers(){
        return new ArrayList<>(pollenOffers);
    }

    public static DateTimeFormatter getDateFormatter(){
        return formatter;
    }


}
