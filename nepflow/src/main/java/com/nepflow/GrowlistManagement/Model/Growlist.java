package com.nepflow.GrowlistManagement.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Growlist {

    @Id
    @GeneratedValue
    protected String uuid;

    @Relationship(value = "CONTAINS_COLLECTION",direction = Relationship.Direction.INCOMING)
    User user;
    @Relationship(value = "CONTAINS_SPECIMEN")
    List<Specimen> spezimenList;

    @Version
    private Long version;

    @Getter
    protected boolean isPublic;

    public Growlist(User user) {
        this.user = user;
        this.spezimenList = new ArrayList<>();
        this.isPublic = true;
    }

    public void addSpecimen(Specimen specimen){
        this.spezimenList.add(specimen);
    }
    public List<Specimen> getSpezimens() {
        return new ArrayList<>(spezimenList);
    }



}
