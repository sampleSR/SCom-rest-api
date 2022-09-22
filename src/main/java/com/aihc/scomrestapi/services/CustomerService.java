package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.Customer;
import com.aihc.scomrestapi.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final AuthenticationService authenticationService;


  public CustomerService(CustomerRepository customerRepository, AuthenticationService authenticationService) {
    this.customerRepository = customerRepository;
    this.authenticationService = authenticationService;
  }

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer findById(Integer id) {
    Optional<Customer> adminWrapper = customerRepository.findById(id);
    if (adminWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Customer customer = adminWrapper.get();
    customer.setRole(authenticationService.getRoleByUserId(customer.getId()));
    return customer;
  }

}
