package com.nepflow.ChatModule;

import org.modelmapper.ModelMapper;

import com.nepflow.ChatModule.Dto.ChatDTO;
import com.nepflow.ChatModule.Dto.ChatUserDTO;
import com.nepflow.ChatModule.Dto.MessageDTO;
import com.nepflow.ChatModule.Model.Chat;
import com.nepflow.ChatModule.Model.ChatUser;
import com.nepflow.ChatModule.Model.Message;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfigChat {

    ModelMapper modelMapper = new ModelMapper();


    @Bean
    public ModelMapper modelMapperChat() {

        modelMapper.addMappings(new PropertyMap<Chat, ChatDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getConversationId());
                map().setName("TODO");
                using(ctx -> modelMapper.map(((Chat) ctx.getSource()).getUser1(), ChatUserDTO.class))
                        .map(source, destination.getUser1());
                using(ctx -> modelMapper.map(((Chat) ctx.getSource()).getUser2(), ChatUserDTO.class))
                        .map(source, destination.getUser2());
                using(ctx -> modelMapper.map(((Chat) ctx.getSource()).getMessages(), new TypeToken<List<MessageDTO>>() {
                }.getType()))
                        .map(source, destination.getMessages());
            }
        });

        modelMapper.addMappings(new PropertyMap<ChatUser, ChatUserDTO>() {
            @Override
            protected void configure() {
                map().setUsername(source.getUsername());
            }
        });
        modelMapper.addMappings(new PropertyMap<Message, MessageDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setContent(source.getContent());
                map().setTimestamp(source.getTimestamp());
                using(ctx -> modelMapper.map(((Message) ctx.getSource()).getSender(), ChatUserDTO.class))
                        .map(source, destination.getSender());
            }
        });


        return modelMapper;
    }


}
