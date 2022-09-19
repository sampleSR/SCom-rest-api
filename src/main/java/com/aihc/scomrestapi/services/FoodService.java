package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Food;
import com.aihc.scomrestapi.repositories.FoodRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

  private final FoodRepository foodRepository;

  public FoodService(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  public Food save(Food food) {
    return foodRepository.save(food);
  }

  public List<Food> findAll() {
    return foodRepository.findAll();
  }
}
