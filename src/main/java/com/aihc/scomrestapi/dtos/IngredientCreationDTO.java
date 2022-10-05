package com.aihc.scomrestapi.dtos;

import com.aihc.scomrestapi.db.entities.Ingredient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientCreationDTO {

  private String name;
  private Double price;
  private Integer stock;

  public Ingredient toEntity() {
    Ingredient ingredient = new Ingredient();
    ingredient.setName(name);
    ingredient.setStock(stock);
    ingredient.setPrice(price);
    return ingredient;
  }
}
