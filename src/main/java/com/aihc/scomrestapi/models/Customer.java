package com.aihc.scomrestapi.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = TableConstants.CUSTOMER_TABLE)
public class Customer extends User {

  private Integer nit;

}
