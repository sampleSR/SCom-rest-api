package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.models.Customer;
import com.aihc.scomrestapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired private CustomerRepository customerRepository;

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }
}
