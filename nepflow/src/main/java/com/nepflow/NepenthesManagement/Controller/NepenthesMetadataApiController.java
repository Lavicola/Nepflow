package com.nepflow.NepenthesManagement.Controller;


import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-12T02:15:56.817365600+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.nepflowNepenthes.base-path:/api}")
public class NepenthesMetadataApiController implements NepenthesMetadataApi {

    private final NepenthesMetadataApiDelegate delegate;

    public NepenthesMetadataApiController(@Autowired(required = false) NepenthesMetadataApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new NepenthesMetadataApiDelegate() {});
    }

    @Override
    public NepenthesMetadataApiDelegate getDelegate() {
        return delegate;
    }

}
