package com.nepflow.UserManagement.Controller;

import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Dto.UserPrivacyDTO;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import com.nepflow.UserManagement.Service.UserManagementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UsermanagementControllerImpl implements UsermanagementApiDelegate {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired

    @Qualifier("modelMapperUser")
    ModelMapper modelMapper;

    public ResponseEntity<UserDTO> userPost(UserDTO userDTO) {
        String id = this.authenticationService.getOauthId();
        if (id == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        if (this.userManagementService.createMinimalUser(id, userDTO.getUsername(), userDTO.getContactInformation(), userDTO.getCountry()) == null) {
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok(userDTO);
    }

    public ResponseEntity<UserDTO> userGet() {
        String id = this.authenticationService.getOauthId();
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        User user = this.userManagementService.getUserByOAuthId(id);
        if (user == null) {
            return ResponseEntity.ok(new UserDTO());

        }
        return ResponseEntity.ok(this.modelMapper.map(user, UserDTO.class));

    }

    public ResponseEntity<UserDTO> userPut(UserDTO userDTO) {
        String id = this.authenticationService.getOauthId();
        if (id != null) {
            return ResponseEntity.ok().body(this.modelMapper.map(this.userManagementService.updateUser(id, userDTO.getContactInformation()), UserDTO.class));
        } else {
            return ResponseEntity.internalServerError().body(null);

        }

    }

    public ResponseEntity<List<UserPrivacyDTO>> usersGet() {
        User user = this.authenticationService.getAuthenticatedUser();
        List<User> users;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        users = this.userManagementService.getUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<UserPrivacyDTO>());
        }

        return ResponseEntity.ok(users.stream()
                .map(user1 -> this.modelMapper.map(user1, UserPrivacyDTO.class))
                .collect(Collectors.toList()));


    }


}