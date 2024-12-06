package com.nepflow.ChatModule.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(  )
    private ChatUser sender = null;  // This is still useful for fetching related data

    @ManyToOne() // Many messages to one conversation
    @JoinColumn(name = "chat_id") // Foreign key reference to PrivateConversation
    private Chat chat;

    private String content;
    private Instant timestamp;

    // Constructor
    protected Message(final String content, final Instant timestamp,
                   final ChatUser sender, final Chat chat) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.chat = chat;
    }


    public String getSenderId() {
        return this.sender.getId();
    }

}
