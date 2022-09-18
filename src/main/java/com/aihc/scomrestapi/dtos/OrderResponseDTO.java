package com.aihc.scomrestapi.dtos;

import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.db.entities.RestaurantTable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {

  private Integer id;

  private Date date;

  private List<Product> products;

  private RestaurantTable table;
}
