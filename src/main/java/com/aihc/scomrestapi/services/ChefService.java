package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.Chef;
import com.aihc.scomrestapi.repositories.ChefRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

  private final ChefRepository chefRepository;
  private final AuthenticationService authenticationService;


  public ChefService(ChefRepository chefRepository, AuthenticationService authenticationService) {
    this.chefRepository = chefRepository;
    this.authenticationService = authenticationService;
  }

  public Chef save(Chef chef) {
    return chefRepository.save(chef);
  }

  public Chef findById(Integer id) {
    Optional<Chef> chefWrapper = chefRepository.findById(id);
    if (chefWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Chef chef = chefWrapper.get();
    chef.setRole(authenticationService.getRoleByUserId(chef.getId()));
    return chef;
  }

  public Chef update(final Integer id, final Chef chef) {
    Optional<Chef> chefWrapper = chefRepository.findById(id);
    if (chefWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    chef.setId(id);
    chef.setPassword(chefWrapper.get().getPassword());
    chef.setRole(authenticationService.getRoleByUserId(id));
    return chefRepository.save(chef);
  }
}
