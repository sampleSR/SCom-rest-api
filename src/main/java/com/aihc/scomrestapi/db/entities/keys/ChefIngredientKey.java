package com.aihc.scomrestapi.db.entities.keys;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ChefIngredientKey implements Serializable {

  @Column(name = TableConstants.CHEF_AS_FOREIGN)
  private Integer chefId;

  @Column(name = TableConstants.INGREDIENT_AS_FOREIGN)
  private Integer ingredientId;
}
