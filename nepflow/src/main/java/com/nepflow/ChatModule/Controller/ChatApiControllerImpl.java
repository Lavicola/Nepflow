package com.nepflow.ChatModule.Controller;

import com.nepflow.ChatModule.Dto.ChatDTO;
import com.nepflow.ChatModule.Dto.ChatSummaryDTO;
import com.nepflow.ChatModule.Dto.NewMessageDTO;
import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.Message;
import com.nepflow.ChatModule.Service.ChatService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatApiControllerImpl implements ChatApiDelegate {

    /**
     *
     */
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    ChatService chatService;

    @Autowired
    @Qualifier("modelMapperChat")

    ModelMapper modelMapper;

    public ResponseEntity<ChatDTO> chatsChatIdGet(Integer chatId,
                                                  Pageable pageable) {

        User user = this.authenticationService.getAuthenticatedUser();
        Chat chat;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        chat = this.chatService.getPrivateConversation(user.getOAuthId(), chatId.intValue());
        if (chat != null) {
            return ResponseEntity.ok(this.modelMapper.map(chat, ChatDTO.class));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<NewMessageDTO> chatsChatIdPost(Integer chatId, NewMessageDTO newMessageDTO) {
        User user = this.authenticationService.getAuthenticatedUser();
        Message message;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        message = this.chatService.addMessageToConversation(chatId.intValue(), user.getOAuthId(),
                newMessageDTO.getContent(),
                newMessageDTO.getTimestamp());
        if (message != null) {
            return ResponseEntity.ok(this.modelMapper.map(message, NewMessageDTO.class));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<ChatSummaryDTO>> chatsGet(Pageable pageable) {
        User user = this.authenticationService.getAuthenticatedUser();
        Page<Chat> privateConversationPage;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        privateConversationPage = this.chatService.getPrivateConversationSummary(user.getOAuthId(), pageable);
        if (privateConversationPage != null) {
            return null;//ResponseEntity.ok(this.modelMapper.map(privateConversationPage, ChatSummaryDTO.class));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


    }

}