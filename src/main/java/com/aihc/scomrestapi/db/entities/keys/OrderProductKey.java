package com.aihc.scomrestapi.db.entities.keys;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductKey implements Serializable {

  @Column(name = TableConstants.ORDER_AS_FOREIGN)
  private Integer orderId;

  @Column(name = TableConstants.PRODUCT_AS_FOREIGN)
  private Integer productId;
}
