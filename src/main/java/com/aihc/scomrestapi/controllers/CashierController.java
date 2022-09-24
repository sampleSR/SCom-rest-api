package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Cashier;
import com.aihc.scomrestapi.services.CashierService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndPoint.CASHIERS)
public class CashierController {

  private final CashierService cashierService;

  public CashierController(CashierService cashierService) {
    this.cashierService = cashierService;
  }

  @PostMapping
  public ResponseEntity<Cashier> save(@RequestBody Cashier cashier) {
    return ResponseEntity.ok(cashierService.save(cashier));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cashier> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(cashierService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cashier> updateUser(
      @PathVariable Integer id, @RequestBody Cashier cashier) {
    return ResponseEntity.accepted().body(cashierService.update(id, cashier));
  }
}
