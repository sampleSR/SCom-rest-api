package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Ingredient;
import com.aihc.scomrestapi.dtos.IngredientBasicInfoDTO;
import com.aihc.scomrestapi.dtos.IngredientCreationDTO;
import com.aihc.scomrestapi.dtos.RequestIngredientsDTO;
import com.aihc.scomrestapi.services.IngredientService;
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
@RequestMapping(EndPoint.INGREDIENTS)
public class IngredientController {

  private final IngredientService ingredientService;

  public IngredientController(final IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @PostMapping
  public ResponseEntity<Ingredient> create(@RequestBody IngredientCreationDTO ingredient) {
    return new ResponseEntity<>(ingredientService.save(ingredient.toEntity()), HttpStatus.CREATED);
  }

  @PostMapping("request")
  public ResponseEntity<String> requestIngredients(@RequestBody RequestIngredientsDTO request) {
    ingredientService.saveRequest(request);
    return new ResponseEntity<>("Successful ingredients request", HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<IngredientBasicInfoDTO>> getAll() {
    return new ResponseEntity<>(ingredientService.getAllWithBasicInfo(), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<IngredientBasicInfoDTO> updateAllFields(
      @RequestBody IngredientBasicInfoDTO ingredient, @PathVariable Integer id) {
    return new ResponseEntity<>(
        new IngredientBasicInfoDTO(ingredientService.updateAll(id, ingredient.toEntity())),
        HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<IngredientBasicInfoDTO> delete(@PathVariable Integer id) {
    return new ResponseEntity<>(
        new IngredientBasicInfoDTO(ingredientService.deleteById(id)), HttpStatus.OK);
  }
}
