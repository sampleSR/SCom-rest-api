package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.repositories.CustomerRepository;
import com.aihc.scomrestapi.repositories.OrderRepository;
import com.aihc.scomrestapi.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;
  private final ChefService chefService;
  private final CustomerService customerService;
  private final RestaurantTableService restaurantTableService;

    public OrderService(
        final OrderRepository orderRepository,
        final ProductRepository productRepository,
        final ChefService chefService,
        final CustomerService customerService,
        final RestaurantTableService restaurantTableService)
    {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.chefService = chefService;
        this.customerService = customerService;
        this.restaurantTableService = restaurantTableService;
    }

    public Order save(OrderMdl orderMdl) {
    Order order = new Order();
    order.setDate(new Date());
    if (orderMdl.getChef() != null) {
      order.setChef(chefService.findById(orderMdl.getChef().getId()));
    }
    if (orderMdl.getTable() != null) {
      order.setTable(restaurantTableService.findById(orderMdl.getTable().getId()));
    }
      if (orderMdl.getCustomer() != null) {
          order.setCustomer(customerService.findById(orderMdl.getCustomer().getId()));
      }
    order
        .getProducts()
        .addAll(
            orderMdl.getProducts().stream()
                .map(
                    p -> {
                      Product product = productRepository.findById(p.getId()).get();
                      OrderProduct nop = new OrderProduct();
                      nop.setProduct(product);
                      nop.setOrder(order);
                      nop.setAmount(p.getAmount());
                      return nop;
                    })
                .collect(Collectors.toSet()));
    return orderRepository.save(order);
  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

//  public List<OrderMdl> findAllModels() {
//    List<Order> orders = orderRepository.findAll();
//    List<OrderMdl> orderMdlList = new ArrayList<>();
//    orders.stream()
//        .filter(order -> order.getBill() == null)
//        .forEach(
//            order -> {
//              orderMdlList.add(order.toModel());
//            });
//    return orderMdlList;
//  }
    public List<OrderMdl> findAllModels() {
        List<Order> orders = orderRepository.findAll();
        List<OrderMdl> orderMdlList = new ArrayList<>();
        orders
            .forEach(
                order -> {
                    orderMdlList.add(order.toModel());
                });
        return orderMdlList;
    }

  public Order update(Integer id, OrderMdl orderMdl) {

    Optional<Order> wrapper = orderRepository.findById(id);
    if (wrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Order order = wrapper.get();
    order.setDate(new Date());
    orderMdl
        .getProducts()
        .forEach(
            p -> {
              if (order.getProducts().stream()
                  .anyMatch(
                      po -> {
                        return Objects.equals(po.getProduct().getId(), p.getId());
                      })) {
                order
                    .getProducts()
                    .forEach(
                        orderProduct -> {
                          if (Objects.equals(orderProduct.getProduct().getId(), p.getId())) {
                            orderProduct.setAmount(p.getAmount());
                          }
                        });
              } else {
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setOrder(order);
                orderProduct.setAmount(p.getAmount());
                Product product = productRepository.findById(p.getId()).get();
                orderProduct.setProduct(product);
                order.getProducts().add(orderProduct);
              }
            });
    return orderRepository.save(order);
  }
}
