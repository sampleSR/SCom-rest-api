package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

  @Autowired
  OrderProductRepository orderProductRepository;

  public OrderProduct save(OrderProduct orderProduct) {
    return orderProductRepository.save(orderProduct);
  }

}
