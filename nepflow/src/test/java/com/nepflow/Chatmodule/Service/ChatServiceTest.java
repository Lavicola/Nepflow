package com.nepflow.Chatmodule.Service;

import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.ChatUser;
import com.nepflow.ChatModule.Model.Message;
import com.nepflow.ChatModule.Service.ChatService;
import io.minio.MinioClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class ChatServiceTest {

    @Autowired
    ChatService chatService;


    @MockBean
    MinioClient minioClient;


    ChatUser hamata = new ChatUser("id", "hamata");
    ChatUser lavicola = new ChatUser("id2", "lavicola");

    static boolean  once = true;

    @BeforeEach
    public void createUsers() {
        if(once){
            hamata = this.chatService.createChatUser("id", "hamata");
            lavicola = this.chatService.createChatUser("id2", "lavicola");
            once = false;
        }else{
            return;
        }

    }


    @Test
    @DisplayName("Create a new valid private conversation")
    public void createPrivateConversationTest() {
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), lavicola.getId());
        assertNotNull(chat);
    }

    @Test
    @DisplayName("Create a invalid private conversation where both users are the same")
    public void createPrivateConversationSameUserTest() {
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), hamata.getId());
        assertNull(chat);
    }


    @Test
    @DisplayName("Return a PrivateConversation if User is part of it")
    public void getPrivateConversationTest() {
        Chat rChat = null;
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), lavicola.getId());
        rChat = this.chatService.getPrivateConversation(hamata.getId(), chat.getConversationId());
        assertNotNull(rChat);
    }

    @Test
    @DisplayName("Return null if User is not part of it")
    public void getPrivateConversationFalseUserTest() {
        Chat rChat = null;
        ChatUser wrongUser = this.chatService.createChatUser("id3", "false");
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), lavicola.getId());
        rChat = this.chatService.getPrivateConversation(wrongUser.getId(), chat.getConversationId());
        assertNull(rChat);
    }


    @Test
    @DisplayName("Return null if User does not exist")
    public void getPrivateConversationNotExistingUserTest() {
        Chat rChat = null;
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), lavicola.getId());
        rChat = this.chatService.getPrivateConversation("dsddsasdds", chat.getConversationId());
        assertNull(rChat);
    }

    @Test
    @DisplayName("Add Message to Conversation")
    public void addMessageToConversationTest() {
        Message message;
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), lavicola.getId());
        message = this.chatService.addMessageToConversation(chat.getConversationId(), lavicola.getId(),
                "test", Instant.now());
        assertNotNull(message);
    }

    @Test
    @DisplayName("dont add Message to Conversation if User is not part of conversation")
    public void addMessageToConversationUserNotPartTest() {
        Message message;
        ChatUser user = this.chatService.createChatUser("newId", "user");
        Chat chat = this.chatService.createNewPrivateConversation(hamata.getId(), lavicola.getId());
        message = this.chatService.addMessageToConversation(chat.getConversationId(), user.getId(),
                "test", Instant.now());
        assertNull(message);
    }

}
