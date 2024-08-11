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

@Node
@NoArgsConstructor
public class Growlist {

    @Id
    @GeneratedValue
    @Getter
    protected String uuid;

    @Relationship(value = "CONTAINS_COLLECTION", direction = Relationship.Direction.INCOMING)
    @Getter
    User user;
    @Relationship(value = "CONTAINS_SPECIMEN")
    List<Specimen> specimenList;
    @Getter
    protected boolean isPublic;

    public Growlist(User user) {
        if (user == null) {
            throw new RuntimeException("User is Null");
        }
        this.user = user;
        this.specimenList = new ArrayList<>();
        this.isPublic = true;
    }

    public boolean addSpecimen(Specimen specimen) {
        if (specimen.getUser().equals(this.user)) {
            this.specimenList.add(specimen);
            return true;
        } else {
            return false;
        }
    }

    public List<Specimen> getSpecimens() {
        return new ArrayList<>(specimenList);
    }

}
