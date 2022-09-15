package com.aihc.scomrestapi.utils.builders;

import com.aihc.scomrestapi.db.entities.User;

public class UserBuilder {

  private static User user = null;

  public static User buildAcceptedUser() {
    if (user == null) {
      user = new User();
      user.setId(1);
      user.setPassword("alvaro123");
    }
    return user;
  }
}
