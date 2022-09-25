package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.db.entities.keys.FoodIngredientKey;
import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = TableConstants.FOOD_INGREDIENT_RELATIONSHIP)
@Data
public class FoodIngredient {

  @JsonIgnore @EmbeddedId private FoodIngredientKey id;

  @ManyToOne
  @MapsId("foodId")
  @JoinColumn(name = TableConstants.FOOD_AS_FOREIGN)
  private Food food;

  @ManyToOne
  @MapsId("ingredientId")
  @JoinColumn(name = TableConstants.INGREDIENT_AS_FOREIGN)
  private Ingredient ingredient;

  @Column(name = TableConstants.AMOUNT)
  private Integer amount;
}
