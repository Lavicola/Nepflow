package com.nepflow.NepenthesManagement.Controller;

import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T22:42:44.669728600+02:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.nepflowNepenthes.base-path:/api}")
public class NepenthesManagementApiController implements NepenthesManagementApi {

    private final NepenthesManagementApiDelegate delegate;

    public NepenthesManagementApiController(@Autowired(required = false) NepenthesManagementApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new NepenthesManagementApiDelegate() {});
    }

    @Override
    public NepenthesManagementApiDelegate getDelegate() {
        return delegate;
    }

}
