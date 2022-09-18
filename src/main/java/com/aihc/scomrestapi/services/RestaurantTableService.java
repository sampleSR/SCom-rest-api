package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.RestaurantTable;
import com.aihc.scomrestapi.repositories.RestaurantTableRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

  private final RestaurantTableRepository restaurantTableRepository;

  public RestaurantTableService(RestaurantTableRepository restaurantTableRepository) {
    this.restaurantTableRepository = restaurantTableRepository;
  }

  public RestaurantTable findById(Integer id) {
    Optional<RestaurantTable> tableWrapper = restaurantTableRepository.findById(id);
    if (tableWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    return tableWrapper.get();
  }
}
