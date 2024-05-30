package com.nepflow.UserManagement.Controller;

import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-01T19:01:53.601610227+02:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.nepflowUser.base-path:/api}")
public class UsermanagementApiController implements UsermanagementApi {

    private final UsermanagementApiDelegate delegate;

    public UsermanagementApiController(@Autowired(required = false) UsermanagementApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new UsermanagementApiDelegate() {});
    }

    @Override
    public UsermanagementApiDelegate getDelegate() {
        return delegate;
    }

}
