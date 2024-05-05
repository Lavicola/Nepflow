package com.nepflow.UserManagement.Controller;

import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Dto.UserPrivacyDTO;


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
