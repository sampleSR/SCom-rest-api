package com.aihc.scomrestapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMdl {

  private Integer id;
  private String type;
  private String nameOrBrand;
  private String description;

}
