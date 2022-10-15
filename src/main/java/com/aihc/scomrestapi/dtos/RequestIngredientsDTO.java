package com.aihc.scomrestapi.dtos;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestIngredientsDTO {

  private List<IngredientPerFoodDTO> ingredients = new ArrayList<>();
  private List<NewIngredientPerFoodDTO> newIngredients = new ArrayList<>();
  private Integer chefId;
}
