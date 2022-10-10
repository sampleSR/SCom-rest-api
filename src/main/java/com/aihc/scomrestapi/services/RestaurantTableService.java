package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.RestaurantTable;
import com.aihc.scomrestapi.db.entities.Waiter;
import com.aihc.scomrestapi.dtos.RestaurantTableCreationDTO;
import com.aihc.scomrestapi.dtos.RestaurantTableInfoDTO;
import com.aihc.scomrestapi.repositories.RestaurantTableRepository;
import com.aihc.scomrestapi.repositories.WaiterRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

  private final RestaurantTableRepository restaurantTableRepository;
  private final WaiterRepository waiterRepository;

  public RestaurantTableService(
      final RestaurantTableRepository restaurantTableRepository,
      final WaiterRepository waiterRepository) {
    this.restaurantTableRepository = restaurantTableRepository;
    this.waiterRepository = waiterRepository;
  }

  public RestaurantTable findById(Integer id) {
    Optional<RestaurantTable> tableWrapper = restaurantTableRepository.findById(id);
    if (tableWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    return tableWrapper.get();
  }

  public RestaurantTable save(RestaurantTableCreationDTO tableDTO) {
    RestaurantTable table = new RestaurantTable();
    table.setCapacity(tableDTO.getCapacity());
    table.setNumber(tableDTO.getNumber());
    table.setWaiters(new HashSet<>());
    tableDTO
        .getWaiters()
        .forEach(
            waiterId -> {
              Waiter waiter = waiterRepository.findById(waiterId).get();
              waiter.getTables().add(table);
              table.getWaiters().add(waiterRepository.findById(waiterId).get());
            });
    return restaurantTableRepository.save(table);
  }

  public List<RestaurantTable> getAll() {
    return restaurantTableRepository.findAll().stream()
        .filter(table -> !table.getDeleted())
        .collect(Collectors.toList());
  }

  public RestaurantTable update(final Integer id, final RestaurantTable table) {
    if (findById(id).getId() != table.getId()) {
      throw new RuntimeException();
    }
    return restaurantTableRepository.save(table);
  }

  public RestaurantTable updateBasicInfo(final Integer id, final RestaurantTableInfoDTO tableDTO) {
    RestaurantTable table = findById(id);
    table.setCapacity(tableDTO.getCapacity());
    table.setNumber(tableDTO.getNumber());
    return restaurantTableRepository.save(table);
  }

  public RestaurantTable setWaiters(final Integer id, final List<Integer> waiters) {
    RestaurantTable table = findById(id);
    table.getWaiters().forEach(waiter -> waiter.getTables().remove(table));
    table.setWaiters(new HashSet<>());
    waiters.forEach(
        waiterId -> {
          Waiter waiter = waiterRepository.findById(waiterId).get();
          waiter.getTables().add(table);
          table.getWaiters().add(waiter);
        });
    return restaurantTableRepository.save(table);
  }

  public RestaurantTable deleteById(final Integer id) {
    RestaurantTable table = findById(id);
    table.setDeleted(true);
    return restaurantTableRepository.save(table);
  }
}
