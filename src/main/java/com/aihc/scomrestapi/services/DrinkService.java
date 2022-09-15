package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Drink;
import com.aihc.scomrestapi.repositories.DrinkRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

  private final DrinkRepository drinkRepository;

  public DrinkService(DrinkRepository drinkRepository) {
    this.drinkRepository = drinkRepository;
  }

  public Drink save(Drink drink) {
    return drinkRepository.save(drink);
  }

  public List<Drink> findAll() {
    return drinkRepository.findAll();
  }
}
