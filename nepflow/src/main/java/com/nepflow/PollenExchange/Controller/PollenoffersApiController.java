package com.nepflow.PollenExchange.Controller;

import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-01T15:51:56.515590500+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.nepflowPollenexchange.base-path:/api}")
public class PollenoffersApiController implements PollenoffersApi {

    private final PollenoffersApiDelegate delegate;

    public PollenoffersApiController(@Autowired(required = false) PollenoffersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PollenoffersApiDelegate() {});
    }

    @Override
    public PollenoffersApiDelegate getDelegate() {
        return delegate;
    }

}
