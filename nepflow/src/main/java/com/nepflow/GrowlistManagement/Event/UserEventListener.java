package com.nepflow.GrowlistManagement.Event;

import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.UserManagement.Event.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * Lister to asynchronous create a Growlist for an User.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Component
public class UserEventListener {

    /**
     *
     */
    @Autowired
    private Growlistservice growlistservice;


    /**
     * @param event
     */
    @EventListener
    public void handleUserCreatedEvent(final UserCreatedEvent event) {
        this.growlistservice.createGrowlist(event.getId());

    }

}
