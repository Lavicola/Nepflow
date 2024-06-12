package com.nepflow.NepenthesManagement.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

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
