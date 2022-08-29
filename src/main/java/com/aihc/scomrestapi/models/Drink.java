package com.aihc.scomrestapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = TableConstants.DRINK_TABLE)
public class Drink extends Product {

  @Column(name = TableConstants.BRAND)
  private String brand;
  
  @Column(name = TableConstants.ALCOHOLIC_GRADE)
  private String alcoholicGrade;

  @Column(name = TableConstants.VOLUME)
  private Double volume;
  
}
