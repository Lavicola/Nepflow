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

/**
 * Model(Container) which contains all PollenOffers for every Month.
 * The Container can therefore be seen  as a way to optimize queries.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class PollenOfferStartDate {

    /**
     *
     */
    @Transient
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM-yyyy");


    /**
     * Primary Key in Format MM-yyyy.
     */
    @Id
    @Getter
    private String MonthYearId;

    /**
     *
     */
    @Relationship(value = "POSTED_IN", direction = Relationship.Direction.INCOMING)
    private List<PollenOffer> pollenOffers = new ArrayList<>();


    /**
     *  formatter to gain the MM-yyy Format.
     */
    public PollenOfferStartDate() {
        this.MonthYearId = LocalDate.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * @param pollenOffer PollenOffer which shall be added to the Model(Container)
     * @return true if it could be added, else false
     */
    public boolean addPollenOffer(final PollenOffer pollenOffer) {
        if (pollenOffer.getStartDate().format(DATE_TIME_FORMATTER).equals(this.MonthYearId)) {
            this.pollenOffers.add(pollenOffer);
            return true;

        } else {
            return false;
        }
    }

    /**
     * @return a copy of all PollenOffers from the Model(Container)
     */
    public List<PollenOffer> getPollenOffers() {
        return new ArrayList<>(pollenOffers);
    }


}
