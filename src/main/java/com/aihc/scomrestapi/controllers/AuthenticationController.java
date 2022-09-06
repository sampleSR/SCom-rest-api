package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;
import com.aihc.scomrestapi.services.AuthenticationService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.AUTH)
public class AuthenticationController {

  private final AuthenticationService authService;

  public AuthenticationController(AuthenticationService authService) {
    this.authService = authService;
  }

  @PostMapping(value = EndPoint.LOGIN)
  public ResponseEntity<LoginResponseDTO> logIn(@RequestBody LoginRequestDTO request) {
    return ResponseEntity.ok(authService.authenticateUser(request));
  }
}
