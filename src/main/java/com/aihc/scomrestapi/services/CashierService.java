package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.models.Cashier;
import com.aihc.scomrestapi.repositories.CashierRepository;
import org.springframework.stereotype.Service;

@Service
public class CashierService {

  private final CashierRepository cashierRepository;

  public CashierService(CashierRepository cashierRepository) {
    this.cashierRepository = cashierRepository;
  }

  public Cashier save(Cashier cashier) {
    return cashierRepository.save(cashier);
  }
}
