package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.dtos.OrderRequestDTO;
import com.aihc.scomrestapi.dtos.OrderResponseDTO;
import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.services.OrderService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public ResponseEntity<Order> save(@RequestBody OrderRequestDTO order) {
    //Order order1 = orderService.save(order);
    return ResponseEntity.ok(new Order());
  }

  @GetMapping
  public ResponseEntity<List<OrderResponseDTO>> getAll() {
    return ResponseEntity.ok(new ArrayList<OrderResponseDTO>());
  }

}
