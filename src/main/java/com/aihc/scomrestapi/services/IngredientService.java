package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Chef;
import com.aihc.scomrestapi.db.entities.Ingredient;
import com.aihc.scomrestapi.db.entities.IngredientRequest;
import com.aihc.scomrestapi.dtos.IngredientBasicInfoDTO;
import com.aihc.scomrestapi.dtos.IngredientPerFoodDTO;
import com.aihc.scomrestapi.dtos.RequestIngredientsDTO;
import com.aihc.scomrestapi.repositories.ChefRepository;
import com.aihc.scomrestapi.repositories.IngredientRepository;
import com.aihc.scomrestapi.repositories.IngredientRequestRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  private final IngredientRepository ingredientRepository;
  private final IngredientRequestRepository requestRepository;
  private final ChefRepository chefRepository;

  public IngredientService(
      final IngredientRepository ingredientRepository,
      final IngredientRequestRepository requestRepository,
      final ChefRepository chefRepository) {
    this.ingredientRepository = ingredientRepository;
    this.requestRepository = requestRepository;
    this.chefRepository = chefRepository;
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

  public void saveRequest(final RequestIngredientsDTO request) {

    request
        .getNewIngredients()
        .forEach(
            newIngredient -> {
              Ingredient ingredient = new Ingredient();
              ingredient.setName(newIngredient.getName());
              ingredient.setPrice(newIngredient.getPrice());
              ingredient.setStock(newIngredient.getStock());
              ingredient = ingredientRepository.save(ingredient);
              request
                  .getIngredients()
                  .add(new IngredientPerFoodDTO(ingredient.getId(), newIngredient.getAmount()));
            });

    Chef chef = chefRepository.findById(request.getChefId()).get();
    request
        .getIngredients()
        .forEach(
            ingredient -> {
              IngredientRequest newRequest = new IngredientRequest();
              Ingredient ingredientFromRepo =
                  ingredientRepository.findById(ingredient.getId()).get();
              ingredientFromRepo.addStock(ingredient.getAmount());
              //        ingredientFromRepo.setStock(ingredientFromRepo.getStock() +
              // ingredient.getAmount());
              newRequest.setIngredient(ingredientFromRepo);
              newRequest.setChef(chef);
              newRequest.setDate(new Date());
              newRequest.setAmount(ingredient.getAmount());
              requestRepository.save(newRequest);
            });
  }
}
