package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = TableConstants.CASHIER_TABLE)
public class Cashier extends User {

  @Column(name = TableConstants.SALARY)
  private Double salary;

  @Column(name = TableConstants.DEGREE)
  private String degree;
}
