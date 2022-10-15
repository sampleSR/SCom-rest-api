package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.keys.OrderProductKey;
import com.aihc.scomrestapi.dtos.CustomerInfoForOrderDTO;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.services.OrderProductService;
import com.aihc.scomrestapi.services.OrderService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.ORDERS)
public class OrderController {

  private final OrderService orderService;
  private final OrderProductService orderProductService;

  public OrderController(OrderService orderService, OrderProductService orderProductService) {
    this.orderService = orderService;
    this.orderProductService = orderProductService;
  }

  @PostMapping
  public ResponseEntity<Order> save(@RequestBody OrderMdl order) {
    return ResponseEntity.ok(orderService.save(order));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Order> addProduct(@PathVariable Integer id, @RequestBody OrderMdl order) {
    return ResponseEntity.ok(orderService.update(id, order));
  }

  @PutMapping("/{id}/customer-info")
  public ResponseEntity<Order> updateCustomerInfo(
      @PathVariable Integer id, @RequestBody CustomerInfoForOrderDTO customerInfo) {
    return ResponseEntity.ok(orderService.updateCustomerInfo(id, customerInfo));
  }

  @GetMapping
  public ResponseEntity<List<OrderMdl>> getAll() {
    List<OrderMdl> orders = orderService.findAllModels();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/all-confirmed")
  public ResponseEntity<List<OrderMdl>> getConfirmedOrders() {
    List<OrderMdl> orders = orderService.findConfirmedOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/all-delivered")
  public ResponseEntity<List<OrderMdl>> getDeliveredOrders() {
    List<OrderMdl> orders = orderService.findDeliveredOrders();
    return ResponseEntity.ok(orders);
  }

  @PutMapping("/{orderId}/products/{productId}")
  public ResponseEntity<OrderProduct> updateProduct(
      @PathVariable Integer orderId,
      @PathVariable Integer productId,
      @RequestParam Integer amount) {
    OrderProduct orderProduct = new OrderProduct();
    orderProduct.setId(new OrderProductKey(orderId, productId));
    orderProduct.setAmount(amount);
    return ResponseEntity.ok(orderProductService.save(orderProduct));
  }

  @DeleteMapping("/{orderId}/products/{productId}")
  public ResponseEntity<OrderProduct> deleteProduct(
      @PathVariable Integer productId, @PathVariable Integer orderId) {
    return ResponseEntity.ok(orderProductService.delete(orderId, productId));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Order> switchFlag(
      @PathVariable Integer id, @RequestParam String flag, @RequestParam Boolean value) {
    return ResponseEntity.ok(orderService.updateFlag(id, flag, value));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Order> delete(@PathVariable Integer id) {
    return ResponseEntity.ok(orderService.delete(id));
  }
}
