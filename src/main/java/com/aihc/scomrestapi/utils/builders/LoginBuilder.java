package com.aihc.scomrestapi.utils.builders;

import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;

public class LoginBuilder {

  private static LoginRequestDTO request = null;
  private static LoginResponseDTO response = null;

  public static LoginRequestDTO buildRequest() {
    if (request == null) {
      request = new LoginRequestDTO();
      request.setUsernameOrEmail("alvaro");
      request.setPassword("alvaro123");
    }
    return request;
  }

  public static LoginResponseDTO buildResponse() {
    if (response == null) {
      response = new LoginResponseDTO();
      response.setError("User or email wrong");
      response.setSuccess(false);
      response.setMessage("Bad credentials");
    }
    return response;
  }
}
