package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.db.entities.keys.OrderProductKey;
import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TableConstants.ORDER_PRODUCT_RELATIONSHIP)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {

  @EmbeddedId private OrderProductKey id = new OrderProductKey();

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = TableConstants.ORDER_AS_FOREIGN)
  @JsonIgnore
  private Order order;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = TableConstants.PRODUCT_AS_FOREIGN)
  private Product product;

  @Column(name = TableConstants.AMOUNT)
  private Integer amount;
}
