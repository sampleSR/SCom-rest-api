package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.repositories.OrderRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order save(Order orderDTO) {


    return null;
    //return order;

  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }
}
