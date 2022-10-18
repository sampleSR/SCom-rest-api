package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Drink;
import com.aihc.scomrestapi.db.entities.Image;
import com.aihc.scomrestapi.repositories.DrinkRepository;
import com.aihc.scomrestapi.repositories.ImageRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

  private final DrinkRepository drinkRepository;
  private final ImageRepository imageRepository;

  public DrinkService(
      final DrinkRepository drinkRepository, final ImageRepository imageRepository) {
    this.drinkRepository = drinkRepository;
    this.imageRepository = imageRepository;
  }

  public Drink save(Drink drink) {
    Optional<Image> imageOptional = imageRepository.findById(drink.getImageId());
    if (imageOptional.isEmpty()) {
      throw new RuntimeException();
    }
    drink.setImage(imageOptional.get());
    drink.setImageId(imageOptional.get().getId());
    Drink storedDrink = drinkRepository.save(drink);
    storedDrink.setUrlImage(drink.getImage().getUrl());
    return storedDrink;
  }

  public List<Drink> findAll() {
    List<Drink> drinks = drinkRepository.findAll();
    drinks.forEach(
        drink -> {
          drink.setUrlImage(drink.getImage().getUrl());
          drink.setImageId(drink.getImage().getId());
        });
    return drinks.stream().filter(drink -> !drink.getDeleted()).collect(Collectors.toList());
  }
}
