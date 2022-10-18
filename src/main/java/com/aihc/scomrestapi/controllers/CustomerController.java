package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Customer;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.services.CustomerService;
import com.aihc.scomrestapi.services.OrderService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = EndPoint.CUSTOMERS)
public class CustomerController {

  private final CustomerService customerService;
  private final OrderService orderService;

  public CustomerController(CustomerService customerService, OrderService orderService) {
    this.customerService = customerService;
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerService.save(customer));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(customerService.findById(id));
  }

  @GetMapping("/{id}/orders/not-billed")
  public ResponseEntity<List<OrderMdl>> getNotBilledOrdersByCustomerId(@PathVariable Integer id) {
    return ResponseEntity.ok(orderService.findNotBilledOrdersByUserId(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateUser(
      @PathVariable Integer id, @RequestBody Customer customer) {
    return ResponseEntity.accepted().body(customerService.update(id, customer));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Customer> deleteUser(@PathVariable Integer id) {
    return ResponseEntity.ok().body(customerService.deleteById(id));
  }
}
