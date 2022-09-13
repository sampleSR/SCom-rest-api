package com.aihc.scomrestapi.utils.builders;

import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;

public class LoginBuilder {

  private static LoginRequestDTO request = null;
  private static LoginResponseDTO response = null;

  public static LoginRequestDTO buildValidRequest() {

    if (request == null) {
      request = new LoginRequestDTO();
    }
    request.setUsernameOrEmail("alvaro");
    request.setPassword("alvaro123");
    return request;
  }

  public static LoginResponseDTO buildBadResponse() {

    if (response == null) {
      response = new LoginResponseDTO();
    }
    response.setError("Username or email wrong");
    response.setSuccess(false);
    response.setMessage("Bad credentials");
    response.setData(null);

    return response;
  }
}
