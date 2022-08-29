package com.aihc.scomrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aihc.scomrestapi.models.Waiter;
import com.aihc.scomrestapi.services.WaiterService;

@RestController
@RequestMapping("/waiters")
public class WaiterController {
  
  @Autowired
  private WaiterService waiterService;

  @PostMapping
  public ResponseEntity<Waiter> save(@RequestBody Waiter waiter) {
    return ResponseEntity.ok(waiterService.save(waiter));
  }

}
