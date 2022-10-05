package com.aihc.scomrestapi.dtos;

import com.aihc.scomrestapi.db.entities.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientBasicInfoDTO {

  private Integer id;
  private String name;
  private Integer stock;
  private Double price;

  public IngredientBasicInfoDTO(Ingredient ingredient) {
    this.id = ingredient.getId();
    this.name = ingredient.getName();
    this.price = ingredient.getPrice();
    this.stock = ingredient.getStock();
  }

  public Ingredient toEntity() {
    Ingredient ingredient = new Ingredient();
    ingredient.setId(id);
    ingredient.setName(name);
    ingredient.setStock(stock);
    ingredient.setPrice(price);
    return ingredient;
  }
}
