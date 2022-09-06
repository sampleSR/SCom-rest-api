package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.models.Administrator;
import com.aihc.scomrestapi.models.Chef;
import com.aihc.scomrestapi.repositories.AdministratorRepository;
import com.aihc.scomrestapi.repositories.ChefRepository;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

  private final ChefRepository chefRepository;

  public ChefService(ChefRepository chefRepository) {
    this.chefRepository = chefRepository;
  }

  public Chef save(Chef chef) {
    return chefRepository.save(chef);
  }

}
