package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Chef;
import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.repositories.ChefRepository;
import com.aihc.scomrestapi.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

  private final ChefRepository chefRepository;
  private final OrderRepository orderRepository;
  private final AuthenticationService authenticationService;
  private final UserService userService;

  public ChefService(
      final ChefRepository chefRepository,
      final OrderRepository orderRepository,
      final AuthenticationService authenticationService,
      final UserService userService) {
    this.chefRepository = chefRepository;
    this.orderRepository = orderRepository;
    this.authenticationService = authenticationService;
    this.userService = userService;
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

  public Chef deleteById(final Integer id) {
    Optional<Chef> userWrapper = chefRepository.findById(id);
    if (userWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    List<Order> orderList = orderRepository.findAllByChef_Id(id);
    orderList.forEach(
        order -> {
          order.setChef(null);
          orderRepository.save(order);
        });

    userService.deleteById(id);
    return userWrapper.get();
  }
}
