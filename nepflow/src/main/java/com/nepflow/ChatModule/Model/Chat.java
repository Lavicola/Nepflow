package com.nepflow.ChatModule.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private int conversationId;

    /**
     *
     */
    @ManyToOne(targetEntity = ChatUser.class)
    private ChatUser user1;

    /**
     *
     */
    @ManyToOne(targetEntity = ChatUser.class)
    private ChatUser user2;


    /**
     *
     */
    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages;

    /**
     * @param user1
     * @param user2
     */
    public Chat(final ChatUser user1, final ChatUser user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.messages = new ArrayList<>();
    }


    public Message addMessageToConversation(final String content, final Instant timestamp, final ChatUser chatUser) {
        Message message = null;
        if (chatUser.equals(this.user1) || chatUser.equals(this.user2)) {
            message = new Message(content, timestamp, chatUser, this);
            this.messages.add(message);
        }
        return message;

    }


    /**
     * @return
     */
    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }

    /**
     * @param id
     * @return
     */
    public boolean belongsToConversation(final String id) {
        return this.user1.getId().equals(id) || this.user2.getId().equals(id);

    }


}
