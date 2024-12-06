package com.nepflow.ChatModule.Repository;

import com.nepflow.ChatModule.Model.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Integer> {


    List<Chat> findAll();

    Chat findByConversationId(int id);


    /**
     * @param userId
     * @param pageable amount of PrivateConversation to retrieve
     * @return List of the latest PrivateConversation depending on the parameters
     */
    @Query("SELECT ch FROM Chat ch " +
            "JOIN ch.messages m " +
            "WHERE (ch.user1.id = :userId OR ch.user2.id = :userId) " +
            "AND m.timestamp = (SELECT MAX(m2.timestamp) FROM Message m2 WHERE m2.chat = ch) " +
            "GROUP BY ch " +
            "ORDER BY MAX(m.timestamp) DESC")
    Page<Chat> getPrivateConversationSummary(String userId, Pageable pageable);





}
