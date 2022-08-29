package com.aihc.scomrestapi.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.INGREDIENT_TABLE)
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.INGREDIENT_ID)
  private Integer id;

  @Column(name = TableConstants.NAME)
  private String name;

  private Integer stock;

  @Column(name = TableConstants.PRICE)
  private Double price;

  @OneToMany(mappedBy = "ingredient")
  Set<ChefIngredient> chefs;

  @OneToMany(mappedBy = "ingredient")
  Set<FoodIngredient> foods;

}
