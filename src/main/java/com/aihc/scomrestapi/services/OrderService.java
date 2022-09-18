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
import java.util.Objects;
import java.util.Optional;
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


  public Order save(OrderMdl orderMdl) {
    Order order = new Order();
    order.setDate(new Date());
    order.getProducts().addAll(orderMdl.getProducts()
        .stream()
        .map(p -> {
          Product product = productRepository.findById(p.getId()).get();
          OrderProduct nop = new OrderProduct();
          nop.setProduct(product);
          nop.setOrder(order);
          nop.setAmount(p.getAmount());
          return nop;
        })
        .collect(Collectors.toSet())
    );
    return orderRepository.save(order);
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

  public Order update(Integer id, OrderMdl orderMdl) {

    Optional<Order> wrapper = orderRepository.findById(id);
    if (wrapper.isEmpty()){
      throw new RuntimeException();
    }
    Order order = wrapper.get();
    order.setDate(new Date());
    orderMdl.getProducts()
        .forEach(p -> {
          if (order.getProducts().stream().anyMatch(po -> {
            return Objects.equals(po.getProduct().getId(), p.getId());
          })){
            order.getProducts().forEach(orderProduct -> {
              if (Objects.equals(orderProduct.getProduct().getId(), p.getId())) {
                orderProduct.setAmount(p.getAmount());
              }
            });
          }//Add logic for a new product in a product
        });
    return orderRepository.save(order);
  }
}
