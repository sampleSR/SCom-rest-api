package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = TableConstants.CHEF_INGREDIENT_RELATIONSHIP)
@Data
public class IngredientRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.REQUEST_ID)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = TableConstants.CHEF_AS_FOREIGN)
  private Chef chef;

  @ManyToOne
  @JoinColumn(name = TableConstants.INGREDIENT_AS_FOREIGN)
  private Ingredient ingredient;

  @Column(name = TableConstants.DATE)
  private Date date;

  @Column(name = TableConstants.AMOUNT)
  private Integer amount;
}
