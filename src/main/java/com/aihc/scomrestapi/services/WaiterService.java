package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Waiter;
import com.aihc.scomrestapi.repositories.WaiterRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class WaiterService {

  private final WaiterRepository waiterRepository;
  private final AuthenticationService authenticationService;
  private final UserService userService;

  public WaiterService(
      final WaiterRepository waiterRepository,
      final AuthenticationService authenticationService,
      final UserService userService) {
    this.waiterRepository = waiterRepository;
    this.authenticationService = authenticationService;
    this.userService = userService;
  }

  public Waiter save(Waiter waiter) {
    return waiterRepository.save(waiter);
  }

  public Waiter findById(Integer id) {
    Optional<Waiter> waiterWrapper = waiterRepository.findById(id);
    if (waiterWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Waiter waiter = waiterWrapper.get();
    waiter.setRole(authenticationService.getRoleByUserId(waiter.getId()));
    return waiter;
  }

  public Waiter update(final Integer id, final Waiter waiter) {
    Optional<Waiter> waiterWrapper = waiterRepository.findById(id);
    if (waiterWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    waiter.setId(id);
    waiter.setPassword(waiterWrapper.get().getPassword());
    waiter.setRole(authenticationService.getRoleByUserId(id));
    return waiterRepository.save(waiter);
  }

  public Waiter deleteById(final Integer id) {
    Optional<Waiter> userWrapper = waiterRepository.findById(id);
    if (userWrapper.isEmpty()) {
      throw new RuntimeException();
    }

    userService.deleteById(id);
    return userWrapper.get();
  }
}
