package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.repositories.AdministratorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService {

  private final AdministratorRepository administratorRepository;
  private final AuthenticationService authenticationService;

  public AdministratorService(AdministratorRepository administratorRepository, AuthenticationService authenticationService) {
    this.administratorRepository = administratorRepository;
    this.authenticationService = authenticationService;
  }

  public Administrator save(Administrator admin) {
    return administratorRepository.save(admin);
  }

  public Administrator findById(Integer id) {
    Optional<Administrator> adminWrapper = administratorRepository.findById(id);
    if (adminWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Administrator admin = adminWrapper.get();
    admin.setRole(authenticationService.getRoleByUserId(admin.getId()));
    return admin;
  }
}
