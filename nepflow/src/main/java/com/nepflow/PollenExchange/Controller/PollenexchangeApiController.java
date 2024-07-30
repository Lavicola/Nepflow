package com.nepflow.PollenExchange.Controller;

import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-30T13:56:32.107300400+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.nepflowPollenexchange.base-path:/api}")
public class PollenexchangeApiController implements PollenexchangeApi {

    private final PollenexchangeApiDelegate delegate;

    public PollenexchangeApiController(@Autowired(required = false) PollenexchangeApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PollenexchangeApiDelegate() {});
    }

    @Override
    public PollenexchangeApiDelegate getDelegate() {
        return delegate;
    }

}
