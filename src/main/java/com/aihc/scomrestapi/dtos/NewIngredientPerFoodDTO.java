package com.aihc.scomrestapi.dtos;

import com.aihc.scomrestapi.db.entities.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewIngredientPerFoodDTO {
  private String name;
  private Double price;
  private Integer stock = 0;
  private Integer amount;

  public Ingredient toEntity() {
    Ingredient ingredient = new Ingredient();
    ingredient.setName(name);
    ingredient.setPrice(price);
    ingredient.setStock(stock);
    return ingredient;
  }
}
