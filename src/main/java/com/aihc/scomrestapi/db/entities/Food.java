package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = TableConstants.FOOD_TABLE)
public class Food extends Product {

  @Column(name = TableConstants.NAME)
  private String name;

  @Column(name = TableConstants.TYPE)
  private String type;

  @OneToMany(mappedBy = "food")
  Set<FoodIngredient> ingredients;

  @Transient
  private List<Integer> newIngredients;

}
