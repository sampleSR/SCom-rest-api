package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Food;
import com.aihc.scomrestapi.dtos.FoodCreationDTO;
import com.aihc.scomrestapi.services.FoodService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.FOODS)
public class FoodController {

  private final FoodService foodService;

  FoodController(FoodService foodService) {
    this.foodService = foodService;
  }

  @PostMapping("/previous")
  public ResponseEntity<Food> saveUser(@RequestBody Food food) {

    return ResponseEntity.ok(foodService.save(food));
  }

  @PostMapping
  public ResponseEntity<Food> save(@RequestBody FoodCreationDTO food) {

    return ResponseEntity.ok(foodService.saveFromDTO(food));
  }

  @PutMapping("{id}")
  public ResponseEntity<Food> update(@PathVariable Integer id, @RequestBody FoodCreationDTO food) {
    //    food.setId(id);
    return ResponseEntity.ok(foodService.updateFromDTO(id, food));
  }

  @GetMapping
  public ResponseEntity<List<Food>> getFoods() {
    return ResponseEntity.ok(foodService.findAll());
  }
}
