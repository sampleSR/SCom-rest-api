package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Chef;
import com.aihc.scomrestapi.repositories.ChefRepository;
import java.util.Optional;
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

  public Chef findById(Integer id) {
    Optional<Chef> chefWrapper = chefRepository.findById(id);
    if (chefWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    return chefWrapper.get();
  }
}
