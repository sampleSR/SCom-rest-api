package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.Waiter;
import com.aihc.scomrestapi.services.WaiterService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
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

  @GetMapping("/{id}/orders/pending")
  public ResponseEntity<List<Order>> getOrdersByWaiterId(@PathVariable Integer id) {
    return ResponseEntity.ok(waiterService.findOrdersByWaiterId(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Waiter> updateUser(@PathVariable Integer id, @RequestBody Waiter waiter) {
    return ResponseEntity.accepted().body(waiterService.update(id, waiter));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Waiter> deleteUser(@PathVariable Integer id) {
    return ResponseEntity.ok().body(waiterService.deleteById(id));
  }
}
