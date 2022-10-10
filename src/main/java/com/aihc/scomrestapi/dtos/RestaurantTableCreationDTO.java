package com.aihc.scomrestapi.dtos;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableCreationDTO {
  private Integer capacity;
  private String number;
  private List<Integer> waiters = new ArrayList<>();
}
