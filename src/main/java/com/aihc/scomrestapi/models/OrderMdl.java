package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.db.entities.RestaurantTable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMdl {

  private Integer id;
  private Date date;
  private RestaurantTableMdl table;
  private ChefMdl chef;
  private List<ProductMdl> products;

  public Order toEntity() {
    Order order = new Order();
    order.setId(id);
    return order;
  }

}
