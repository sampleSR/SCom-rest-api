package com.aihc.scomrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aihc.scomrestapi.models.Customer;
import com.aihc.scomrestapi.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
  
  @Autowired
  private CustomerService customerService;

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerService.save(customer));
  }

}
