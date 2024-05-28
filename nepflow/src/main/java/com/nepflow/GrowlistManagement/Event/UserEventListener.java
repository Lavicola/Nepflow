package com.nepflow.GrowlistManagement.Event;

import com.nepflow.GrowlistManagement.Repository.GrowListRepository;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.UserManagement.Event.UserCreatedEvent;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * This event is used to automatically create a Growlist for a new User
 */
@Component
public class UserEventListener {

    @Autowired
    Growlistservice growlistservice;

    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        User user = event.getUser();
        this.growlistservice.createGrowlist(user);

    }

}
