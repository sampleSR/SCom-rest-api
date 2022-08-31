package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = TableConstants.WAITER_TABLE)
public class Waiter extends User {

  @Column(name = TableConstants.SALARY)
  private Double salary;

  @Column(name = TableConstants.EXPERIENCE)
  private String experience;

  @Column(name = TableConstants.HEALTH_CODE)
  private String healthCode;

  @ManyToMany
  @JoinTable(
      name = TableConstants.WAITER_RESTAURANT_TABLE_RELATIONSHIP,
      joinColumns = @JoinColumn(name = TableConstants.WAITER_AS_FOREIGN),
      inverseJoinColumns = @JoinColumn(name = TableConstants.RESTAURANT_TABLE_AS_FOREIGN))
  Set<RestaurantTable> tables;
}
