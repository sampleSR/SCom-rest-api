package com.aihc.scomrestapi.dtos;

import lombok.Data;

@Data
public class LoginResponseDTO {

  private String error;

  private String message;

  private Boolean success;

  private String data;
}
