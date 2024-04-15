package com.nepflow.UserManagement.Model;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Date;
import java.util.List;


// TODO Change Date to timestmap UTC
@Data
@Node
public class User {


    /** The id. */
    @Id
    @GeneratedValue
    private Long id;

    @Property("username")
    private String username;

    @Property
    private String email;

    @Property
    private String password;

    @Property
    private String contactInformation;

    @Property
    private boolean isEnabled;

    @Property
    @CreatedDate
    private Date registrationDate;

    @Property
    private int failedLoginAttempts;

    @Property
    private boolean locked;

    @Property
    private Date lockedDate;

    @Relationship("BELONGS_TO")
    private List<Role> roles;


    public User(String email,String username,String password,String contactInformation){
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.contactInformation = contactInformation;
    }

    public User() {
        super();
        this.isEnabled = false;
        this.registrationDate = new Date();
    }


    public List<Role> getRoles(){
        return this.roles;
    }


}


