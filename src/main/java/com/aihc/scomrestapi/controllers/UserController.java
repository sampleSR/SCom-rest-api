package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.models.User;
import com.aihc.scomrestapi.services.UserService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.USERS)
public class UserController {

  private final UserService userService;

  UserController (UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> saveUser(@RequestBody User user) {

    return ResponseEntity.ok(userService.save(user));

  }

}
