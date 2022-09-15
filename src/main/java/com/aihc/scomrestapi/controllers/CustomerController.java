package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Customer;
import com.aihc.scomrestapi.services.CustomerService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EndPoint.CUSTOMERS)
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerService.save(customer));
  }
}
