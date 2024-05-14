package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneHybridsGet200ResponseInner;
import com.nepflow.NepenthesManagement.Dto.CloneSpeciesGet200ResponseInner;
import com.nepflow.NepenthesManagement.Dto.ICCloneDTO;
import com.nepflow.NepenthesManagement.Dto.IVCloneDTO;
import com.nepflow.NepenthesManagement.Dto.NepenthesClonesDTO;
import com.nepflow.NepenthesManagement.Dto.NepenthesNameCloneGet200Response;


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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-13T23:03:32.853119600+02:00[Europe/Berlin]")
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
