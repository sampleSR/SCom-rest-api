package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.RestaurantTable;
import java.util.HashSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTableMdl {

  private Integer id;
  private Integer capacity;
  private String number;

  public RestaurantTableMdl(RestaurantTable table) {
    this.id = table.getId();
    this.capacity = table.getCapacity();
    this.number = table.getNumber();
  }

  public RestaurantTable toEntity() {
    return new RestaurantTable(id, capacity, number, new HashSet<>());
  }
}
