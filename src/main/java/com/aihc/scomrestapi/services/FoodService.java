package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Food;
import com.aihc.scomrestapi.db.entities.Image;
import com.aihc.scomrestapi.repositories.FoodRepository;
import com.aihc.scomrestapi.repositories.ImageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

  private final FoodRepository foodRepository;
  private final ImageRepository imageRepository;

  public FoodService(FoodRepository foodRepository, ImageRepository imageRepository) {
    this.foodRepository = foodRepository;
    this.imageRepository = imageRepository;
  }

  public Food save(Food food) {
    Optional<Image> imageOptional = imageRepository.findById(food.getImageId());
    if (imageOptional.isEmpty()) {
      throw new RuntimeException();
    }
    food.setImage(imageOptional.get());
    Food storedFood = foodRepository.save(food);
    storedFood.setUrlImage(food.getImage().getUrl());
    return storedFood;
  }

  public List<Food> findAll() {
    List<Food> foods = foodRepository.findAll();
    foods.forEach(food -> food.setUrlImage(food.getImage().getUrl()));
    return foods;
  }
}
