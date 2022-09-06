package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.models.Administrator;
import com.aihc.scomrestapi.repositories.AdministratorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

  private final AdministratorRepository administratorRepository;

  public AdministratorService(AdministratorRepository administratorRepository) {
    this.administratorRepository = administratorRepository;
  }

  public Administrator save(Administrator admin) {
    return administratorRepository.save(admin);
  }
}
