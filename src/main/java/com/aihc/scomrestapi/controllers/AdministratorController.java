package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.services.AdministratorService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public ResponseEntity<Administrator> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(administratorService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Administrator> updateUser(
      @PathVariable Integer id, @RequestBody Administrator administrator) {
    return ResponseEntity.accepted().body(administratorService.update(id, administrator));
  }
}
