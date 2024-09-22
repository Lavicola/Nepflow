package com.nepflow.UserManagement.Model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
/**
 * Model which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Data
@Node("User")
public class User {

    /**
     *
     */
    @Property
    @Id
    private String OAuthId;

    /**
     *
     */
    @Property
    private String contactInformation;

    /**
     *
     */
    @Property
    private String username;

    /**
     *
     */
    @Relationship("LIVES_IN")
    @Setter
    Country country;

    /**
     *
     */
    @Version
    private Long version;


    private User() {

    }

    /**
     * @param oAuthId
     */
    public User(String oAuthId) {
        this.OAuthId = oAuthId;
    }


    /**
     * @param username
     * @param oAuthId
     */
    public User(String username, String oAuthId) {
        this(oAuthId);
        this.username = username;
    }

    /**
     * @param username
     * @param oAuthId
     * @param country
     */
    public User(String username, String oAuthId,Country country) {
        this(oAuthId);
        this.username = username;
        this.country = country;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User))
            return false;
        User other = (User) o;
        return this.getOAuthId().equals(other.getOAuthId());

    }

    /**
     * @return
     */
    @Override
    public final int hashCode() {

        return this.getOAuthId().hashCode();
    }

}
