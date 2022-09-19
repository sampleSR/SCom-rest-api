package com.aihc.scomrestapi.dtos;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.Product;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class OrderRequestDTO {

  private Integer chefId;
  private Integer tableId;
  private List<Integer> products;

  public Order toOrder() {
    Order order = new Order();
    order.getChef().setId(chefId);
    order.getTable().setId(tableId);
    Set<OrderProduct> products = new HashSet<>();
    this.products.forEach(
        p -> {
          OrderProduct orderProduct = new OrderProduct();
          Product product = new Product();
          product.setId(p);
          orderProduct.setProduct(product);
          products.add(new OrderProduct());
        });
    order.setProducts(products);
    return order;
  }
}
