package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.Chef;
import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.db.entities.RestaurantTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMdl {

  @JsonProperty(access = Access.READ_ONLY)
  private Integer id;
  @JsonProperty(access = Access.READ_ONLY)
  private Date date;
  private RestaurantTableMdl table;
  private ChefMdl chef;
  private Set<ProductMdl> products;

  public Order toEntity() {
    Order order = new Order();
    order.setDate(new Date());
    var orderProducts = new HashSet<OrderProduct>();
    products.forEach(p -> {
      OrderProduct orderProduct = new OrderProduct();
      Product product = new Product();
      product.setId(p.getId());
      orderProduct.setOrder(order);
      orderProduct.setProduct(product);
      orderProduct.setAmount(5);
      order.getProducts().add(orderProduct);
    });
    order.setProducts(orderProducts);
    return order;
  }

}
