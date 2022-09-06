package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.models.Chef;
import com.aihc.scomrestapi.services.ChefService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.CHEFS)
public class ChefController {

  private final ChefService chefService;

  public ChefController(ChefService chefService) {
    this.chefService = chefService;
  }

  @PostMapping
  public ResponseEntity<Chef> save(@RequestBody Chef chef) {
    return ResponseEntity.ok(chefService.save(chef));
  }
}
