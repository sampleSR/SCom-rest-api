package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Bill;
import com.aihc.scomrestapi.db.entities.User;
import com.aihc.scomrestapi.services.BillService;
import com.aihc.scomrestapi.services.UserService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndPoint.USERS)
public class UserController {

  private final UserService userService;
  private final BillService billService;

  public UserController(final UserService userService, final BillService billService) {
    this.userService = userService;
    this.billService = billService;
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

  @GetMapping("/{id}/bills")
  public ResponseEntity<List<Bill>> getBillsByUserId(@PathVariable Integer id) {
    return ResponseEntity.ok(billService.findByCustomerId(id));
  }
}
