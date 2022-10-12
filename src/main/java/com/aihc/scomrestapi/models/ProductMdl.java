package com.aihc.scomrestapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMdl {

  private Integer id;
  private String type;
  private String nameOrBrand;
  private String description;
  private Double price;
  private Integer amount;
}
