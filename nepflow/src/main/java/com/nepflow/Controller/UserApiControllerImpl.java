package com.nepflow.Controller;

import com.nepflow.Dto.UserDTO;

import com.nepflow.Models.Species;
import com.nepflow.Models.User;
import com.nepflow.Repository.CloneRepository;
import com.nepflow.Service.CloneService;
import com.nepflow.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;

@Controller
public class UserApiControllerImpl implements UserApiDelegate {

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;




    public ResponseEntity<UserDTO> userGet() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.OK);
        } else {
            OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
            UserDTO userDTO = new UserDTO();
            //userDTO.setUsername(oAuth2User.getName());
            return ResponseEntity.ok().body(userDTO);
        }
    }

    public ResponseEntity<UserDTO> userPost(UserDTO userDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.OK);
        }

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        User user = this.userService.createMinimalUser(oAuth2User.getAttributes().get("sub").toString());
        if (user == null) {
            // User already exists
            return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.CONFLICT);
        }

        userDTO = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(userDTO);

    }


    public ResponseEntity<Void> userPut(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);


        return ResponseEntity.ok(null);

    }
}



