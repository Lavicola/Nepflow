package com.nepflow.GrowlistManagement.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
/**
 * Model which abstracts the Growlist, a Container holding every Specimen
 * a User owns.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public class Growlist {

    /**
     *
     */
    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    /**
     *
     */
    @Relationship(value = "CONTAINS_COLLECTION", direction = Relationship.Direction.INCOMING)
    @Getter
    private User user;
    /**
     *
     */
    @Relationship(value = "CONTAINS_SPECIMEN")
    private List<Specimen> specimenList;
    /**
     *
     */
    @Getter
    private  boolean isPublic;

    /**
     * @param user user which the growlist shall reference
     */
    public Growlist(final User user) {
        if (user == null) {
            throw new RuntimeException("User is Null");
        }
        this.user = user;
        this.specimenList = new ArrayList<>();
        this.isPublic = true;
    }

    /**
     * @param specimen specimen which belongs to the User
     * @return true if success, else false
     */
    public boolean addSpecimen(final Specimen specimen) {
        if (specimen.isSpecimenOwner(this.user)) {
            this.specimenList.add(specimen);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return all Specimens a User own
     */
    public List<Specimen> getSpecimens() {
        return new ArrayList<>(specimenList);
    }

}
