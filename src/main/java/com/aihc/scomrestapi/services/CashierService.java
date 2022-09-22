package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.Cashier;
import com.aihc.scomrestapi.repositories.CashierRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashierService {

  private final CashierRepository cashierRepository;
  private final AuthenticationService authenticationService;


  public CashierService(CashierRepository cashierRepository, AuthenticationService authenticationService) {
    this.cashierRepository = cashierRepository;
    this.authenticationService = authenticationService;
  }

  public Cashier save(Cashier cashier) {
    return cashierRepository.save(cashier);
  }

  public Cashier findById(Integer id) {
    Optional<Cashier> adminWrapper = cashierRepository.findById(id);
    if (adminWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Cashier cashier = adminWrapper.get();
    cashier.setRole(authenticationService.getRoleByUserId(cashier.getId()));
    return cashier;
  }

}
