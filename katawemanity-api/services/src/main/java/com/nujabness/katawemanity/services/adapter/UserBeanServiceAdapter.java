package com.nujabness.katawemanity.services.adapter;

import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.data.entity.User;

public class UserBeanServiceAdapter {

  private UserBeanServiceAdapter() {
      throw new IllegalStateException("Utility class");
    }

  public static UserBean transformToUserBeanService(User user) {
    UserBean userBeanService = new UserBean();
    userBeanService.setId(user.getId());
    userBeanService.setNom(user.getNom());
    userBeanService.setPrenom(user.getPrenom());
    userBeanService.setPassword(user.getPassword());
    userBeanService.setEmail(user.getEmail());

    return userBeanService;
  }

}
