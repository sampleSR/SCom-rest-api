package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Ingredient;
import com.aihc.scomrestapi.dtos.IngredientBasicInfoDTO;
import com.aihc.scomrestapi.repositories.IngredientRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  private final IngredientRepository ingredientRepository;

  public IngredientService(final IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public Ingredient save(Ingredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public Ingredient getById(Integer id) {
    Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
    if (ingredientOptional.isEmpty()) {
      throw new RuntimeException();
    }
    return ingredientOptional.get();
  }

  public List<Ingredient> getAll() {
    return ingredientRepository.findAll();
  }

  public Ingredient updateAll(Integer id, Ingredient ingredient) {
    Ingredient ingredientFromRepo = getById(id);
    ingredient.setId(id);
    return ingredientRepository.save(ingredient);
  }

  public Ingredient deleteById(Integer id) {
    Ingredient ingredientFromRepo = getById(id);
    ingredientRepository.delete(ingredientFromRepo);
    return ingredientFromRepo;
  }

  public List<IngredientBasicInfoDTO> getAllWithBasicInfo() {
    List<Ingredient> ingredients = getAll();
    return ingredients.stream()
        .map(ingredient -> new IngredientBasicInfoDTO(ingredient))
        .collect(Collectors.toList());
  }
}
