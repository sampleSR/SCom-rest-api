package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.utils.constants.TableConstants;
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
@Data
@Table(name = TableConstants.BILL_TABLE)
public class Bill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.BILL_ID)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = TableConstants.CUSTOMER_AS_FOREIGN)
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = TableConstants.CASHIER_AS_FOREIGN)
  private Cashier cashier;
}
