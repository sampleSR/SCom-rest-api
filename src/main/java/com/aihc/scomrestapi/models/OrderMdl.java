package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.Chef;
import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.OrderProduct;
import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.db.entities.RestaurantTable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMdl {

  private Integer id;
//  private Date date;
  private RestaurantTableMdl table;
  private ChefMdl chef;
  private List<ProductMdl> products;

  public Order toEntity() {
    Order order = new Order();
    //order.setId(id);
    order.setDate(new Date());
//    Chef chef = new Chef();
//    chef.setId(chef.getId());
//    order.setChef(chef);
    var orderProducts = new HashSet<OrderProduct>();
    products.forEach(p -> {
      OrderProduct orderProduct = new OrderProduct();
      Product product = new Product();
      product.setId(p.getId());
      orderProduct.setOrder(order);
      orderProduct.setProduct(product);
//      orderProduct.setOrder(order);
      orderProduct.setAmount(5);
      //orderProducts.add(orderProduct);
      order.getProducts().add(orderProduct);
    });
    order.setProducts(orderProducts);
    return order;
  }

}
