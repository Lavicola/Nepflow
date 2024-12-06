package com.nepflow.ChatModule.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ChatUser {


    /**
     *
     */
    @Id
    @NotNull
    @Getter
    @Setter
    private String id;

    /**
     *
     */
    @Column(unique = true)
    private String username;

    /**
     * @param id
     * @param username
     */
    public ChatUser(final String id, final String username) {
        this.id = id;
        this.username = username;
    }


    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * @param obj
     * @return true if Chatser id is same, else false
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {

            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return ((ChatUser) obj).id.equals(this.id);

    }


}
