package com.nepflow.UserManagement.Model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.*;

@Data
@Node("User")
public class User {

    @Property
    @Id
    private String OAuthId;

    @Property
    private String contactInformation;

    @Property
    private String username;

    @Relationship("LIVES_IN")
    @Setter
    Country country;

    @Version
    private Long version;


    private User() {

    }

    public User(String oAuthId) {
        this.OAuthId = oAuthId;
    }


    public User(String username, String oAuthId) {
        this(oAuthId);
        this.username = username;
    }


}
