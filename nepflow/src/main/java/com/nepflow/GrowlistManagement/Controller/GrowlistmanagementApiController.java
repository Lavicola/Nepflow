package com.nepflow.GrowlistManagement.Controller;

import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T01:31:25.659061300+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.nepflowUser.base-path:/api}")
public class GrowlistmanagementApiController implements GrowlistmanagementApi {

    private final GrowlistmanagementApiDelegate delegate;

    public GrowlistmanagementApiController(@Autowired(required = false) GrowlistmanagementApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new GrowlistmanagementApiDelegate() {});
    }

    @Override
    public GrowlistmanagementApiDelegate getDelegate() {
        return delegate;
    }

}
