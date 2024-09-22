package com.nepflow.UserManagement.Event;

import com.nepflow.UserManagement.Model.User;
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
    private final User user;


    /**
     * @param source
     * @param user
     */
    public UserCreatedEvent(final Object source, final User user) {
        super(source);
        this.user = user;
    }

    /**
     * @return
     */
    public User getUser() {
        return this.user;
    }

}
