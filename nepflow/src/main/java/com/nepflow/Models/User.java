package com.nepflow.Models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

@Data
@Node("User")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String OAuthId;

    @Property
    private String username;

    @Property
    // User gives contact information which will be shared for accepted Trades
    private String contactInformation;

    public User(){

    }

    public User(String username,String oAuthId, String contactInformation) {
        this.username = username;
        this.OAuthId = oAuthId;
        this.contactInformation = contactInformation;
    }

    @Relationship("LIVES_IN")
    Region region;


}
