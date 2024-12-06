package com.nepflow.Chatmodule.Repository;

import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.ChatUser;
import com.nepflow.ChatModule.Repository.ChatRepository;
import com.nepflow.ChatModule.Repository.ChatUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class ChatRepositoryTest {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    ChatRepository chatRepository;

    ChatUser hamata = new ChatUser("id", "hamata");
    ChatUser lavicola = new ChatUser("id2", "lavicola");

    ChatUser otherUser = new ChatUser("id3", "villosa");

    @BeforeEach
    public void createUsers() {
        hamata = this.chatUserRepository.save(hamata);
        lavicola = this.chatUserRepository.save(lavicola);
        otherUser = this.chatUserRepository.save(otherUser);
    }


    /**
     * Check the Custom Query in order verify that the Query only returns the Conversations
     * the User in question is part of while making sure to only retrieve the X latest conversations
     * which are determined by the timestamp of the latest message
     */
    @Test
    public void getPrivateConversationSummaryTest() {
        PageRequest pageOneResult = PageRequest.of(0, 1);
        PageRequest pageTwoResult = PageRequest.of(0, 2);
        String contentFirstMessage = "first";
        String contentSecondMessage = "second";
        Chat chat1;
        Chat newestConversation;
        Chat foreignConversation = new Chat(hamata,otherUser);
        Page<Chat> privateConversationsOne;
        Page<Chat> privateConversationsTwo;
        chat1 = this.chatRepository.save(new Chat(lavicola, hamata));
        newestConversation = this.chatRepository.save(new Chat(hamata, lavicola));
        foreignConversation  =  this.chatRepository.save(foreignConversation);
        chat1.addMessageToConversation(contentFirstMessage, Instant.now().minusSeconds(4), lavicola);
        chat1.addMessageToConversation(contentSecondMessage, Instant.now().minusSeconds(3), lavicola);
        newestConversation.addMessageToConversation(contentFirstMessage, Instant.now().minusSeconds(2), hamata);
        newestConversation.addMessageToConversation(contentSecondMessage, Instant.now(), hamata);
        foreignConversation.addMessageToConversation(contentSecondMessage, Instant.now(), hamata);
        this.chatRepository.save(chat1);
        newestConversation = this.chatRepository.save(newestConversation);
        this.chatRepository.save(foreignConversation);
        privateConversationsOne = this.chatRepository.getPrivateConversationSummary(lavicola.getId(),pageOneResult);
        privateConversationsTwo = this.chatRepository.getPrivateConversationSummary(lavicola.getId(),pageTwoResult);

        assertEquals(1,privateConversationsOne.getSize());
        assertEquals(2,privateConversationsOne.getTotalPages());
        assertEquals(2,privateConversationsTwo.getSize());
        assertEquals(1,privateConversationsTwo.getTotalPages());
        assertEquals(3,this.chatRepository.findAll().size());
        // make sure that the latest PrivateConversation is the second one
        assertEquals(newestConversation,privateConversationsTwo.get().collect(Collectors.toList()).get(0));
        assertEquals(newestConversation,privateConversationsOne.get().collect(Collectors.toList()).get(0));

    }

}
