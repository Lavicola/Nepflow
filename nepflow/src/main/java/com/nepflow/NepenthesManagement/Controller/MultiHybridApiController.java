package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;


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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-11T01:56:15.806697200+02:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.nepflowNepenthes.base-path:/api}")
public class MultiHybridApiController implements MultiHybridApi {

    private final MultiHybridApiDelegate delegate;

    public MultiHybridApiController(@Autowired(required = false) MultiHybridApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new MultiHybridApiDelegate() {});
    }

    @Override
    public MultiHybridApiDelegate getDelegate() {
        return delegate;
    }

}
