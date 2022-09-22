package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.Waiter;
import com.aihc.scomrestapi.repositories.WaiterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WaiterService {

  private final WaiterRepository waiterRepository;
  private final AuthenticationService authenticationService;

  public WaiterService(WaiterRepository waiterRepository, AuthenticationService authenticationService) {
    this.waiterRepository = waiterRepository;
    this.authenticationService = authenticationService;
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
}
