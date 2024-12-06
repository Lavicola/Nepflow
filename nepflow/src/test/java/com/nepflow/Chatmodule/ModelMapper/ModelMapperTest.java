package com.nepflow.Chatmodule.ModelMapper;

import com.nepflow.ChatModule.Dto.ChatDTO;
import com.nepflow.ChatModule.Dto.ChatUserDTO;
import com.nepflow.ChatModule.Dto.MessageDTO;
import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.ChatUser;
import com.nepflow.ChatModule.Model.Message;
import com.nepflow.ChatModule.ModelMapperConfigChat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = ModelMapperConfigChat.class)
@ExtendWith(SpringExtension.class)

public class ModelMapperTest {


    @Autowired
    ModelMapper modelMapper;

    ChatUser chatUser = new ChatUser("id","username");
    ChatUser chatUser2 = new ChatUser("id2","username2");

    Chat chat = new Chat(chatUser,chatUser2);


    @Test
    public void mapChatUserTest(){
        ChatUserDTO chatUserDTO;
        ChatUser chatUser;

        chatUser = this.chatUser;
        chatUserDTO = this.modelMapper.map(chatUser, ChatUserDTO.class);

        assertEquals(chatUser.getUsername(),chatUserDTO.getUsername());

    }

    @Test
    public void mapMessageTest(){
        MessageDTO messageDTO;
        ChatUser chatUser = this.chatUser;
        Chat chat = this.chat;
        Instant timestamp = Instant.now();
        Message message = chat.addMessageToConversation("content", timestamp,chatUser);
        messageDTO = this.modelMapper.map(message,MessageDTO.class);

        assertEquals(message.getContent(),messageDTO.getContent());
        assertEquals(message.getId(),messageDTO.getId());
        assertNotNull(messageDTO.getSender());
        assertEquals(message.getSender().getUsername(),messageDTO.getSender().getUsername());
        assertEquals(message.getTimestamp(),messageDTO.getTimestamp());

    }

    @Test
    public void mapChatWithMessagesTest(){
        ChatDTO chatDTO;
        ChatUser chatUser = this.chatUser;
        Chat chat = this.chat;
        Instant timestamp = Instant.now();
        chat.addMessageToConversation("content", timestamp,chatUser);
        chat.addMessageToConversation("content3", timestamp,chatUser);

        chatDTO = this.modelMapper.map(chat,ChatDTO.class);

        assertEquals(chat.getConversationId(),chatDTO.getId());
        assertNotNull(chatDTO.getUser1());
        assertNotNull(chatDTO.getUser2());
        assertEquals(chat.getUser1().getUsername(),chatDTO.getUser1().getUsername());
        assertEquals(chat.getUser2().getUsername(),chatDTO.getUser2().getUsername());
        assertNotNull(chatDTO.getMessages());
        assertEquals(chat.getMessages().size(),chatDTO.getMessages().size());

    }



}
