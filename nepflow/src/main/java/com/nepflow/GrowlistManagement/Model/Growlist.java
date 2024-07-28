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

    @Relationship(value = "CONTAINS_COLLECTION",direction = Relationship.Direction.INCOMING)
    @Getter
    User user;
    @Relationship(value = "CONTAINS_SPECIMEN")
    List<Specimen> specimenList;
    @Getter
    protected boolean isPublic;

    public Growlist(User user) {
        this.user = user;
        this.specimenList = new ArrayList<>();
        this.isPublic = true;
    }

    public void addSpecimen(Specimen specimen){
        this.specimenList.add(specimen);
    }
    public List<Specimen> getSpecimens() {
        return new ArrayList<>(specimenList);
    }

}
