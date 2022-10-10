package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.RestaurantTable;
import com.aihc.scomrestapi.dtos.RestaurantTableCreationDTO;
import com.aihc.scomrestapi.dtos.RestaurantTableInfoDTO;
import com.aihc.scomrestapi.services.RestaurantTableService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.RESTAURANT_TABLES)
public class RestaurantTableController {
  private final RestaurantTableService restaurantTableService;

  public RestaurantTableController(final RestaurantTableService restaurantTableService) {
    this.restaurantTableService = restaurantTableService;
  }

  @PostMapping
  public ResponseEntity<RestaurantTable> create(@RequestBody RestaurantTableCreationDTO tableDTO) {
    return new ResponseEntity<>(restaurantTableService.save(tableDTO), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<RestaurantTable>> getAll() {
    return new ResponseEntity<>(restaurantTableService.getAll(), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RestaurantTable> updateBasicInfo(
      @PathVariable Integer id, @RequestBody RestaurantTableInfoDTO table) {
    return new ResponseEntity<>(restaurantTableService.updateBasicInfo(id, table), HttpStatus.OK);
  }

  @PutMapping("/{id}/waiters")
  public ResponseEntity<?> setWaiters(
      @PathVariable Integer id, @RequestBody List<Integer> waiters) {
    return new ResponseEntity<>(restaurantTableService.setWaiters(id, waiters), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RestaurantTable> delete(@PathVariable Integer id) {
    return new ResponseEntity<>(restaurantTableService.deleteById(id), HttpStatus.OK);
  }
}
