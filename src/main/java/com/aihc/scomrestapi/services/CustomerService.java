package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Customer;
import com.aihc.scomrestapi.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }
}
