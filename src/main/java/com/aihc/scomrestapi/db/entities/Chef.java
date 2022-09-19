package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = TableConstants.CHEF_TABLE)
public class Chef extends User {

  @Column(name = TableConstants.SALARY)
  private Double salary;

  @Column(name = TableConstants.NATIONALITY)
  private String nationality;

  @Column(name = TableConstants.SPECIALTY)
  private String specialty;

  @Column(name = TableConstants.HEALTH_CODE)
  private String healthCode;

  @OneToMany(mappedBy = "chef")
  Set<ChefIngredient> ingredients;
}
