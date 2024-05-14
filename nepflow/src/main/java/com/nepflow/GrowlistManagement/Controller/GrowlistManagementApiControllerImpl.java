package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Model.NepenthesClone;
import com.nepflow.GrowlistManagement.Service.GrowListService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

public class GrowlistManagementApiControllerImpl {

    /*
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    GrowListService growListService;

    public ResponseEntity<UserCloneDTO> userNepenthesPost(UserCloneDTO userCloneDTO) {
        NepenthesClone nepenthesClone;
        User user = this.authenticationService.getAuthenticatedUser();

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        nepenthesClone = this.growListService.addNepenthesCloneToUser(userCloneDTO.getCloneId(), userCloneDTO.getNepenthesName(), user);
        if (nepenthesClone == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        userCloneDTO.setId(nepenthesClone.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(userCloneDTO);
    }

    public ResponseEntity<List<UserCloneDTO>> userNepenthesGet_0(String username) {
        System.out.println("Called");
        User user = this.authenticationService.getUserByUsername(username);
        return ResponseEntity.ok().body(getNepenthesOfUser(user));
    }
    public ResponseEntity<List<UserCloneDTO>> userNepenthesGet() {
        System.out.println("Called");
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok().body(getNepenthesOfUser(user));
    }

    private List<UserCloneDTO> getNepenthesOfUser(User user) {
        List<NepenthesClone> nepenthesClones = this.growListService.getNepenthesOfUser(user);
        List<UserCloneDTO> userCloneDTOs = nepenthesClones.stream()
                .map(clone -> {
                    UserCloneDTO userCloneDTO = new UserCloneDTO();
                    userCloneDTO.setId(clone.getId());
                    userCloneDTO.setUser(clone.getUser().getUsername());
                    userCloneDTO.setCloneId(clone.getClone().getCloneId()); // Fixed the method name

                    return userCloneDTO;
                })
                .collect(Collectors.toList());
        return userCloneDTOs;
    }

*/
}

