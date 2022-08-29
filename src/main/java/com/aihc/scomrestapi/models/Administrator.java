package com.aihc.scomrestapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = TableConstants.ADMINISTRATOR_TABLE)
public class Administrator extends User {

  @Column(name = TableConstants.SALARY)
  private Double salary;
  
  @Column(name = TableConstants.SPECIALTY)
  private String specialty;

}
