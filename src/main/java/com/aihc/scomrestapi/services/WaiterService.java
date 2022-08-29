package com.aihc.scomrestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aihc.scomrestapi.models.Waiter;
import com.aihc.scomrestapi.repositories.WaiterRepository;

@Service
public class WaiterService {

  @Autowired
  private WaiterRepository waiterRepository;
  
  public Waiter save(Waiter waiter) {
    return waiterRepository.save(waiter);
  }

}
