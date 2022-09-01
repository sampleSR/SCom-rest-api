package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.models.Waiter;
import com.aihc.scomrestapi.services.WaiterService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
