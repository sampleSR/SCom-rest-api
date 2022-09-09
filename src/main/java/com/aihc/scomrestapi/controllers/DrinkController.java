package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.models.Drink;
import com.aihc.scomrestapi.services.DrinkService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.DRINKS)
public class DrinkController {
  private final DrinkService drinkService;

  DrinkController(DrinkService drinkService) {
    this.drinkService = drinkService;
  }

  @PostMapping
  public ResponseEntity<Drink> saveUser(@RequestBody Drink drink) {

    return ResponseEntity.ok(drinkService.save(drink));
  }

  @GetMapping
  public ResponseEntity<List<Drink>> getDrinks() {
    return ResponseEntity.ok(drinkService.findAll());
  }
}
