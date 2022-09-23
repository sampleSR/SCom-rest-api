package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.User;
import com.aihc.scomrestapi.services.UserService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndPoint.USERS)
public class UserController {

  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> saveUser(@RequestBody User user) {

    return ResponseEntity.ok(userService.save(user));
  }

  @GetMapping
  public ResponseEntity<List<User>> retrieveAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> deleteById(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.deleteById(id));
  }

}
