package com.nepflow.ChatModule.Service;

import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.ChatUser;
import com.nepflow.ChatModule.Model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;

public interface ChatService {


    /**
     * @param userId1
     * @param userId2
     * @return
     */
    Chat createNewPrivateConversation(String userId1, String userId2);

    /**
     * @param conversationId
     * @param userId
     * @param content
     * @param timestamp
     * @return
     */
    Message addMessageToConversation(int conversationId, String userId, String content, Instant timestamp);


    /**
     * @param id
     * @param username
     * @return
     */
    ChatUser createChatUser(String id, String username);

    /**
     * @param userId         id of the user who requests the conversation
     * @param conversationId if of the conversation the user requests
     * @return
     */
    Chat getPrivateConversation(String userId, int conversationId);

    /**
     * @param userId
     * @param page
     * @return
     */
    Page<Chat> getPrivateConversationSummary(String userId, Pageable page);


}
