package com.nepflow.UserManagement.Model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

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

    public User(String username, String oAuthId,Country country) {
        this(oAuthId);
        this.username = username;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User))
            return false;
        User other = (User) o;
        return this.getOAuthId().equals(other.getOAuthId());

    }

    @Override
    public final int hashCode() {

        return this.getOAuthId().hashCode();
    }

}
