package com.nepflow.ChatModule.Service;

import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.ChatUser;
import com.nepflow.ChatModule.Model.Message;
import com.nepflow.ChatModule.Repository.ChatRepository;
import com.nepflow.ChatModule.Repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;


@Service
public class ChatServiceImpl implements ChatService {

    /**
     *
     */
    @Autowired
    private ChatRepository chatRepository;

    /**
     *
     */
    @Autowired
    private ChatUserRepository chatUserRepository;


    /**
     * @param userId1
     * @param userId2
     * @return
     */
    @Override
    public Chat createNewPrivateConversation(final String userId1, final String userId2) {
        Chat chat = null;
        ChatUser user1 = this.chatUserRepository.findById(userId1);
        ChatUser user2 = this.chatUserRepository.findById(userId2);
        if (user1 != null && user2 != null && !user1.equals(user2)) {
            chat = new Chat(user1, user2);
            chat = this.chatRepository.save(chat);
        }


        return chat;
    }

    /**
     * @param conversationId
     * @param userId
     * @param content
     * @param timestamp
     * @return
     */
    @Override
    @Transactional(transactionManager = "transactionManager")
    public Message addMessageToConversation(final int conversationId, final String userId,
                                            final String content, final Instant timestamp) {
        Message message = null;
        Chat chat = this.chatRepository.findByConversationId(conversationId);
        ChatUser chatUser = this.chatUserRepository.findById(userId);
        if (chat != null) {
            message = chat.addMessageToConversation(content, timestamp, chatUser);
        }
        if (message != null) {
            this.chatRepository.save(chat);
        }
        return message;
    }

    /**
     * @param id
     * @param username
     * @return
     */
    @Override
    public ChatUser createChatUser(final String id, final String username) {
        if (this.chatUserRepository.findById(id) == null) {
            ChatUser chatUser = new ChatUser(id, username);
            return this.chatUserRepository.save(chatUser);
        }
        return null;
    }

    /**
     * @param userId         id of the user who requests the conversation
     * @param conversationId if of the conversation the user requests
     * @return
     */
    @Override
    public Chat getPrivateConversation(final String userId, final int conversationId) {
        Chat chat = this.chatRepository.findByConversationId(conversationId);
        if (chat == null) {
            return null;
        }
        if (chat.belongsToConversation(userId)) {
            return chat;
        }

        return null;
    }

    @Override
    public Page<Chat> getPrivateConversationSummary(final String userId, final Pageable page) {


        return this.chatRepository.getPrivateConversationSummary(userId, page);
    }
}
