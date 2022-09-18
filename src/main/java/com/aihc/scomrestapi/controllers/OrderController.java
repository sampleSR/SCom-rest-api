package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.dtos.OrderRequestDTO;
import com.aihc.scomrestapi.dtos.OrderResponseDTO;
import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.services.OrderService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.ORDERS)
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<Order> save(@RequestBody OrderMdl order) {
    return ResponseEntity.ok(orderService.save(order));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Order> update(@PathVariable Integer id, @RequestBody OrderMdl order) {
    return ResponseEntity.ok(orderService.update(id, order));
  }

  @GetMapping
  public ResponseEntity<List<OrderMdl>> getAll() {
    List<OrderMdl> orders = orderService.findAllModels();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Order>> getAllFields() {
    List<Order> orders = orderService.findAll();
    return ResponseEntity.ok(orders);
  }

}
