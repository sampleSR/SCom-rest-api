package com.aihc.scomrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;
import com.aihc.scomrestapi.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  
  @Autowired
  AuthenticationService authService;
  
  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> logIn(@RequestBody LoginRequestDTO request) {
    return ResponseEntity.ok(authService.authenticateUser(request));
  }

}
