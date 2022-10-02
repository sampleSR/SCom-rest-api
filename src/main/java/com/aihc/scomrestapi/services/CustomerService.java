package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Bill;
import com.aihc.scomrestapi.db.entities.Customer;
import com.aihc.scomrestapi.db.entities.Rating;
import com.aihc.scomrestapi.repositories.BillRepository;
import com.aihc.scomrestapi.repositories.CustomerRepository;
import com.aihc.scomrestapi.repositories.OrderRepository;
import com.aihc.scomrestapi.repositories.RatingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final AuthenticationService authenticationService;
  private final RatingRepository ratingRepository;
  private final OrderRepository orderRepository;
  private final BillRepository billRepository;
  private final UserService userService;

  public CustomerService(
      final CustomerRepository customerRepository,
      final AuthenticationService authenticationService,
      final RatingRepository ratingRepository,
      final OrderRepository orderRepository,
      final BillRepository billRepository,
      final UserService userService) {
    this.customerRepository = customerRepository;
    this.authenticationService = authenticationService;
    this.ratingRepository = ratingRepository;
    this.orderRepository = orderRepository;
    this.billRepository = billRepository;
    this.userService = userService;
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

  public Customer update(final Integer id, final Customer customer) {
    Optional<Customer> customerWrapper = customerRepository.findById(id);
    if (customerWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    customer.setId(id);
    customer.setPassword(customerWrapper.get().getPassword());
    customer.setRole(authenticationService.getRoleByUserId(id));
    return customerRepository.save(customer);
  }

  public Customer deleteById(final Integer id) {
    Optional<Customer> userWrapper = customerRepository.findById(id);
    if (userWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    List<Rating> ratingList = ratingRepository.findAllByCustomer_Id(id);
    ratingList.forEach(
        rating -> {
          rating.setCustomer(null);
          ratingRepository.save(rating);
        });
    // TODO: When customer is added to order, uncomment the code block below
    //    List<Order> orderList = orderRepository.findAllByCustomer_Id(id);
    //    orderList.forEach(
    //        order -> {
    //          order.setCustomer(null);
    //          orderRepository.save(order);
    //        });
    List<Bill> bills = billRepository.findAllByCustomer_Id(id);
    bills.forEach(
        bill -> {
          bill.setCustomer(null);
          billRepository.save(bill);
        });
    userService.deleteById(id);
    return userWrapper.get();
  }
}
