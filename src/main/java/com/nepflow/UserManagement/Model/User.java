package com.nepflow.UserManagement.Model;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Node
//@EntityListeners(AuditingEntityListener.class)
public class User {

    public enum Provider {
        LOCAL, FACEBOOK, GOOGLE, APPLE
    }

    /** The id. */
    @Id
    @GeneratedValue
    private String id;

    private String username;

    private String email;

    private Provider provider = Provider.LOCAL;

    private String password;

    private boolean enabled;

    //private Date registrationDate;

    //private Date lastActivityDate;

    private int failedLoginAttempts;

    private boolean locked;

    //@Temporal(TemporalType.TIMESTAMP)
    //private Date lockedDate;

    @Relationship("BELONGS_TO")
    private List<Role> roles;


    public User(String email,String username,String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
        this.enabled = false;
    }


    public List<Role> getRoles(){
        return this.roles;
    }

//    @PreUpdate
 //   public void setLastActivityDate() {
  //      setLastActivityDate(new Date());
   // }

}


