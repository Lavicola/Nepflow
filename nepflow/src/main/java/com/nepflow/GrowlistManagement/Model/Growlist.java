package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.UserManagement.Model.User;
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
    List<ICClone> cloneList;


    public Growlist(User user) {
        this.user = user;
        this.cloneList = new ArrayList<>();
    }

    public void addClone(ICClone icClone){
        this.cloneList.add(icClone);
    }

    public List<ICClone> getCloneList() {
        return new ArrayList<>(cloneList);
    }
}
