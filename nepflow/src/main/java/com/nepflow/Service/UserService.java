package com.nepflow.Service;

import com.nepflow.Models.User;

public interface UserService {

   public User createMinimalUser(String OAuthId);

   public User updateUser(String OAuthId,User user);


}
