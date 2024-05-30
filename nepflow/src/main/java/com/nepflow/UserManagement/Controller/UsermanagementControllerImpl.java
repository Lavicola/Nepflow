package com.nepflow.UserManagement.Controller;

import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import com.nepflow.UserManagement.Service.UserManagementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class UsermanagementControllerImpl implements UsermanagementApiDelegate {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<UserDTO> userPost(UserDTO userDTO) {
        String id = this.authenticationService.getOauthId();
        // for now manual mapping
        User user = new User(userDTO.getUsername(),id);
        if(id == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        if(this.userManagementService.createMinimalUser(user,userDTO.getCountry()) == null){
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok(userDTO);
    }

    public ResponseEntity<UserDTO> userGet() {
        String id = this.authenticationService.getOauthId();
        User user = this.userManagementService.getUserByOAuthId(id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(this.modelMapper.map(user,UserDTO.class));

    }


    }