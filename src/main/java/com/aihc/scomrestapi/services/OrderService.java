package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Bill;
import com.aihc.scomrestapi.db.entities.Cashier;
import com.aihc.scomrestapi.db.entities.Customer;
import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.dtos.CustomerInfoForOrderDTO;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.repositories.BillRepository;
import com.aihc.scomrestapi.repositories.CashierRepository;
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
  private final CashierRepository cashierRepository;
  private final BillRepository billRepository;
  private final RestaurantTableService restaurantTableService;

  public OrderService(
      final OrderRepository orderRepository,
      final ProductRepository productRepository,
      final ChefService chefService,
      final CustomerService customerService,
      final CashierRepository cashierRepository,
      final BillRepository billRepository,
      final RestaurantTableService restaurantTableService) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
    this.chefService = chefService;
    this.customerService = customerService;
    this.cashierRepository = cashierRepository;
    this.billRepository = billRepository;
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
    orders.forEach(
        order -> {
          orderMdlList.add(order.toModel());
        });
    return orderMdlList;
  }

  public List<OrderMdl> findConfirmedOrders() {
    List<Order> orders = orderRepository.findAll();
    List<OrderMdl> orderMdlList = new ArrayList<>();
    orders.stream()
        .filter(order -> order.getWaiterConfirmed() && order.getBill() == null)
        .forEach(
            order -> {
              orderMdlList.add(order.toModel());
            });
    return orderMdlList;
  }

  public List<OrderMdl> findBilledUndeliveredOrders() {
    List<Order> orders = orderRepository.findAll();
    List<OrderMdl> orderMdlList = new ArrayList<>();
    orders.stream()
        .filter(order -> order.getBill() != null && !order.getDelivered() && !order.getPrepared())
        .forEach(
            order -> {
              orderMdlList.add(order.toModel());
            });
    return orderMdlList;
  }

  public List<OrderMdl> findDeliveredOrders() {
    List<Order> orders = orderRepository.findAll();
    List<OrderMdl> orderMdlList = new ArrayList<>();
    orders.stream()
        .filter(order -> order.getDelivered())
        .forEach(
            order -> {
              orderMdlList.add(order.toModel());
            });
    return orderMdlList;
  }

  public Order getById(final Integer id) {
    Optional<Order> orderOptional = orderRepository.findById(id);
    if (orderOptional.isEmpty()) {
      throw new RuntimeException();
    }
    return orderOptional.get();
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

  public Order updateConfirmed(final Integer id, final Boolean confirmed) {
    Order order = getById(id);
    order.setWaiterConfirmed(confirmed);
    return orderRepository.save(order);
  }

  public Order delete(final Integer id) {
    Order order = getById(id);
    orderRepository.delete(order);
    return order;
  }

  public Order updateCustomerInfo(final Integer id, final CustomerInfoForOrderDTO customerInfo) {
    Order order = getById(id);
    Optional<Cashier> cashierOptional = cashierRepository.findById(customerInfo.getIdCashier());
    if (cashierOptional.isEmpty()) {
      throw new RuntimeException();
    }
    Customer customer = customerService.findById(customerInfo.getIdCustomer());
    Bill bill = new Bill();
    bill.setCustomer(customer);
    bill.setCashier(cashierOptional.get());
    Bill savedBill = billRepository.save(bill);
    customer.setNit(customerInfo.getNit());
    order.setCustomer(customer);
    order.setBill(savedBill);
    order.setDateBill(new Date());
    return orderRepository.save(order);
  }

  public Order updateFlag(final Integer id, final String flag, final Boolean value) {
    Order order = getById(id);
    switch (flag) {
      case "confirmed":
        order.setWaiterConfirmed(value);
        break;
      case "prepared":
        order.setPrepared(value);
        break;
      case "delivered":
        order.setDelivered(value);
        break;
    }
    return orderRepository.save(order);
  }
}
