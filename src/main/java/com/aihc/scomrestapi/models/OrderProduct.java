package com.aihc.scomrestapi.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.aihc.scomrestapi.models.keys.OrderProductKey;
import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.Data;

@Entity
@Table(name = TableConstants.ORDER_PRODUCT_RELATIONSHIP)
@Data
public class OrderProduct {
  
  @EmbeddedId
  private OrderProductKey id;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = TableConstants.ORDER_AS_FOREIGN)
  private Order order;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = TableConstants.PRODUCT_AS_FOREIGN)
  private Product product;

  @Column(name = TableConstants.AMOUNT)
  private Integer amount;

}
