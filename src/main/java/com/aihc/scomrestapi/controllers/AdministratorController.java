package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.models.Administrator;
import com.aihc.scomrestapi.services.AdministratorService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.ADMINISTRATORS)
public class AdministratorController {

  private final AdministratorService administratorService;

  public AdministratorController(AdministratorService administratorService) {
    this.administratorService = administratorService;
  }

  @PostMapping
  public ResponseEntity<Administrator> save(@RequestBody Administrator admin) {
    return ResponseEntity.ok(administratorService.save(admin));
  }
}
