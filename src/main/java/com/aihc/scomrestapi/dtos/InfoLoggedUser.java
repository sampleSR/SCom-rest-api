package com.aihc.scomrestapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoLoggedUser {
  private Integer id;
  private String role;
}
