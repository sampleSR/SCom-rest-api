package com.aihc.scomrestapi.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.ORDER_TABLE)
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.ORDER_ID)
  private Integer id;

  @Column(name = TableConstants.DATE)
  private Date date;

  @Column(name = TableConstants.DATE_BILL)
  private Date dateBill;

  @ManyToOne
  @JoinColumn(name = TableConstants.BILL_AS_FOREIGN)
  private Bill bill;

  @ManyToOne
  @JoinColumn(name = TableConstants.RESTAURANT_TABLE_AS_FOREIGN)
  private RestaurantTable table;

  @ManyToOne
  @JoinColumn(name = TableConstants.CHEF_AS_FOREIGN)
  private Chef chef;

  @OneToMany(mappedBy = "order")
  Set<OrderProduct> products;

}
