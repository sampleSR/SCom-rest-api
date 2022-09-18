package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.db.entities.keys.OrderProductKey;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.repositories.OrderRepository;
import com.aihc.scomrestapi.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  public OrderService(OrderRepository orderRepository,
      ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }


  public Order saveWithProducts(Order order) {
    Order newOrder = new Order();
    newOrder.setDate(new Date());
    newOrder.getProducts().addAll(order.getProducts()
        .stream()
        .map(p -> {
          Product product = productRepository.findById(p.getProduct().getId()).get();
          OrderProduct nop = new OrderProduct();
          nop.setProduct(product);
          nop.setOrder(newOrder);
          nop.setAmount(15);
          return nop;
        })
        .collect(Collectors.toSet())
    );
    return orderRepository.save(newOrder);
  }
  //  public Order saveWithProducts(Order order) {        Update
//    Optional<Order> wO = orderRepository.findById(17);
//    Order newOrder = wO.orElseGet(Order::new);
//    newOrder.setDate(new Date());
////    newOrder.getProducts().addAll(order.getProducts()
////        .stream()
////        .map(p -> {
////          Product product = productRepository.findById(p.getProduct().getId()).get();
////          OrderProduct nop = new OrderProduct();
////          nop.setProduct(product);
////          nop.setOrder(newOrder);
////          nop.setAmount(150);
////          return nop;
////        })
////        .collect(Collectors.toSet())
////    );
//    return orderRepository.save(newOrder);
//  }
  public Order save(Order order) {

    order.getProducts().forEach(orderProduct -> {
      orderProduct.setOrder(order);
      orderProduct.setProduct(productRepository.findById(orderProduct.getProduct().getId()).get());
      var key = new OrderProductKey();
      key.setOrderId(order.getId());
      key.setProductId(orderProduct.getProduct().getId());
      orderProduct.setId(key);
    });

//    order.getProducts().forEach(op -> {
//      op.setProduct(productRepository.findById(op.getProduct().getId()).get());
//    });
    return orderRepository.saveAndFlush(order);
    //return order;

  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public List<OrderMdl> findAllModels() {
    List<Order> orders = orderRepository.findAll();
    List<OrderMdl> orderMdls = new ArrayList<>();
    orders.forEach(order -> {
      orderMdls.add(order.toModel());
    });
    return orderMdls;
  }
}
