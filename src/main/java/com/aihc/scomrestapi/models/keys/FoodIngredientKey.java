package com.aihc.scomrestapi.models.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class FoodIngredientKey implements Serializable {
  
  @Column(name = TableConstants.FOOD_AS_FOREIGN)
  private Integer foodId;

  @Column(name = TableConstants.INGREDIENT_AS_FOREIGN)
  private Integer ingredientId;

}
