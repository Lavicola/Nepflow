package com.nepflow.UserManagement.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Calendar;
import java.util.Date;

@Data
@Node
public class VerificationToken {

    /** The Constant EXPIRATION. */
    private static final int EXPIRATION = 60 * 24;

    /** The id. */
    @Id
    @GeneratedValue
    private String id;

    private String token;

    @Relationship("VERIFIES")
    private User user;

    private Date expiryDate;

    /**
     * Instantiates a new verification token.
     */
    public VerificationToken() {
        super();
    }

    /**
     * Instantiates a new verification token.
     *
     * @param token the token
     */
    public VerificationToken(final String token) {
        super();
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    /**
     * Instantiates a new verification token.
     *
     * @param token the token
     * @param user the user
     */
    public VerificationToken(final String token, final User user) {
        super();
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    /**
     * Calculate expiry date.
     *
     * @param expiryTimeInMinutes the expiry time in minutes
     * @return the date
     */
    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    /**
     * Update token.
     *
     * @param token the token
     */
    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }


}
