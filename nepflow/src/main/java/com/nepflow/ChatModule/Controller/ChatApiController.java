package com.nepflow.ChatModule.Controller;

import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-03T23:30:04.829647900+01:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.nepflowChat.base-path:/api}")
public class ChatApiController implements ChatApi {

    private final ChatApiDelegate delegate;

    public ChatApiController(@Autowired(required = false) ChatApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ChatApiDelegate() {});
    }

    @Override
    public ChatApiDelegate getDelegate() {
        return delegate;
    }

}
