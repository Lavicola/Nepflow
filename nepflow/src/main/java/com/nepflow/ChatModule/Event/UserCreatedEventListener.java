package com.nepflow.ChatModule.Event;

import com.nepflow.ChatModule.Service.ChatService;
import com.nepflow.UserManagement.Event.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * Lister to asynchronous create a ChatUser for the Chatmodule.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Component
public class UserCreatedEventListener {

    /**
     *
     */
    @Autowired
    private ChatService chatService;


    /**
     * @param event
     */
    @EventListener
    public void handleUserCreatedEvent(final UserCreatedEvent event) {
        this.chatService.createChatUser(event.getId(), event.getUsername());

    }

}
