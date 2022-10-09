package com.aihc.scomrestapi.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerInfoForOrderDTO {
  private Integer nit;
  private Integer idCustomer;
  private Integer idCashier;
}
