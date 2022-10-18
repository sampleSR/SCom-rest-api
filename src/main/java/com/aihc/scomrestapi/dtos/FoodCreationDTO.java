package com.aihc.scomrestapi.dtos;

import com.aihc.scomrestapi.db.entities.Food;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodCreationDTO {

  @JsonIgnore private Integer id;
  private Double price;
  private Boolean available;
  private String name;
  private String type;
  private Integer imageId;
  private List<IngredientPerFoodDTO> ingredients = new ArrayList<>();
  private List<NewIngredientPerFoodDTO> newIngredients = new ArrayList<>();

  public Food toEntity() {
    Food food = new Food();
    food.setPrice(price);
    food.setAvailable(available);
    food.setName(name);
    food.setType(type);
    return food;
  }
}
