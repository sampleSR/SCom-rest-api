package com.aihc.scomrestapi.models.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.aihc.scomrestapi.utils.constants.TableConstants;

import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class OrderProductKey implements Serializable {
  
  @Column(name = TableConstants.ORDER_AS_FOREIGN)
  private Integer orderId;

  @Column(name = TableConstants.PRODUCT_AS_FOREIGN)
  private Integer productId;
  
}
