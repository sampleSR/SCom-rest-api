package com.aihc.scomrestapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.aihc.scomrestapi.models.keys.ChefIngredientKey;
import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Data;

@Entity
@Table(name = TableConstants.CHEF_INGREDIENT_RELATIONSHIP)
@Data
public class ChefIngredient {
  
  @EmbeddedId
  private ChefIngredientKey id;

  @ManyToOne
  @MapsId("chefId")
  @JoinColumn(name = TableConstants.CHEF_AS_FOREIGN)
  private Chef chef;

  @ManyToOne
  @MapsId("ingredientId")
  @JoinColumn(name = TableConstants.INGREDIENT_AS_FOREIGN)
  private Ingredient ingredient;

  @Column(name = TableConstants.DATE)
  private Date date;

}
