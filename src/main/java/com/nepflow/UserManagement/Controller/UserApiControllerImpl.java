package com.nepflow.UserManagement.Controller;

import com.nepflow.UserManagement.Dto.User;
import com.nepflow.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiControllerImpl implements UserApiDelegate{

    @Autowired
    UserService userService;

    public ResponseEntity<String> userRegisterPost(User user) {
        this.userService.createUserLocked(user.getEmail(),user.getUsername(),user.getPassword(),user.getContactInformation());
        return ResponseEntity.status(HttpStatus.OK).body("");

    }

    public ResponseEntity<String> userVerifyTokenGet(String token) {
        if(this.userService.enableUser(token)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }



}
