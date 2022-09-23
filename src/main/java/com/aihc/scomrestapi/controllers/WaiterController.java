package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.Waiter;
import com.aihc.scomrestapi.services.WaiterService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndPoint.WAITERS)
public class WaiterController {

  private final WaiterService waiterService;

  public WaiterController(WaiterService waiterService) {
    this.waiterService = waiterService;
  }

  @PostMapping
  public ResponseEntity<Waiter> save(@RequestBody Waiter waiter) {
    return ResponseEntity.ok(waiterService.save(waiter));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Waiter> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(waiterService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Waiter> updateUser(@PathVariable Integer id,
      @RequestBody Waiter waiter) {
    return ResponseEntity.accepted().body(waiterService.update(id, waiter));
  }
}
