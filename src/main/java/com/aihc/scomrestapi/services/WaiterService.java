package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.models.Waiter;
import com.aihc.scomrestapi.repositories.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaiterService {

  @Autowired private WaiterRepository waiterRepository;

  public Waiter save(Waiter waiter) {
    return waiterRepository.save(waiter);
  }
}
