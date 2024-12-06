package com.nepflow.ChatModule.Repository;

import com.nepflow.ChatModule.Model.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, Integer> {

    /**
     * @param id
     * @return
     */
    ChatUser findById(String id);

}
