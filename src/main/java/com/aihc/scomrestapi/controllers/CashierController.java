package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.models.Cashier;
import com.aihc.scomrestapi.services.CashierService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
