package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.keys.OrderProductKey;
import com.aihc.scomrestapi.repositories.OrderProductRepository;
import com.aihc.scomrestapi.repositories.OrderRepository;
import com.aihc.scomrestapi.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

  private final OrderProductRepository orderProductRepository;
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  public OrderProductService(
      OrderProductRepository orderProductRepository,
      OrderRepository orderRepository,
      ProductRepository productRepository) {
    this.orderProductRepository = orderProductRepository;
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  public OrderProduct save(OrderProduct orderProduct) {
    orderProduct.setProduct(productRepository.findById(orderProduct.getId().getProductId()).get());
    orderProduct.setOrder(orderRepository.findById(orderProduct.getId().getOrderId()).get());
    return orderProductRepository.save(orderProduct);
  }

  public OrderProduct delete(Integer orderId, Integer productId) {
    Optional<OrderProduct> wrapper =
        orderProductRepository.findById(new OrderProductKey(orderId, productId));
    if (wrapper.isEmpty()) {
      throw new RuntimeException();
    }
    OrderProduct orderProduct = wrapper.get();
    orderProductRepository.delete(orderProduct);
    return orderProduct;
  }
}
