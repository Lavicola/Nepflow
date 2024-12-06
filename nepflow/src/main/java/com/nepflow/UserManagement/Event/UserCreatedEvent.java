package com.nepflow.UserManagement.Event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event to asynchronously notify other Modules that a User was created.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

public class UserCreatedEvent extends ApplicationEvent {
    /**
     *
     */
    @Getter
    private String id;

    /**
     *
     */
    @Getter
    private String username;


    /**
     * @param source
     * @param id
     * @param username
     */
    public UserCreatedEvent(final Object source, final String id, final String username) {
        super(source);
        this.id = id;
        this.username = username;
    }

}
