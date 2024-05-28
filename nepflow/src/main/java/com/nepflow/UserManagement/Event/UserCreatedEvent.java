package com.nepflow.UserManagement.Event;

import com.nepflow.UserManagement.Model.User;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
    private final User user;


    public UserCreatedEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
