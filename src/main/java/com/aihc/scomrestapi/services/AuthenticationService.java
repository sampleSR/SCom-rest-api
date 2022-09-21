package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.User;
import com.aihc.scomrestapi.dtos.InfoLoggedUser;
import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;
import com.aihc.scomrestapi.repositories.AdministratorRepository;
import com.aihc.scomrestapi.repositories.CashierRepository;
import com.aihc.scomrestapi.repositories.ChefRepository;
import com.aihc.scomrestapi.repositories.CustomerRepository;
import com.aihc.scomrestapi.repositories.UserRepository;
import com.aihc.scomrestapi.repositories.WaiterRepository;
import com.aihc.scomrestapi.utils.builders.LoginBuilder;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final UserRepository userRepository;
  private final AdministratorRepository administratorRepository;
  private final CashierRepository cashierRepository;
  private final ChefRepository chefRepository;
  private final CustomerRepository customerRepository;
  private final WaiterRepository waiterRepository;

  public AuthenticationService(
      UserRepository userRepository,
      AdministratorRepository administratorRepository,
      CashierRepository cashierRepository,
      ChefRepository chefRepository,
      CustomerRepository customerRepository,
      WaiterRepository waiterRepository) {
    this.userRepository = userRepository;
    this.administratorRepository = administratorRepository;
    this.cashierRepository = cashierRepository;
    this.chefRepository = chefRepository;
    this.customerRepository = customerRepository;
    this.waiterRepository = waiterRepository;
  }

  public LoginResponseDTO authenticateUser(LoginRequestDTO request) {

    Optional<User> wrapperUser =
        userRepository.findByUsernameOrEmail(
            request.getUsernameOrEmail(), request.getUsernameOrEmail());

    LoginResponseDTO response = LoginBuilder.buildBadResponse();

    User user = new User();
    if (wrapperUser.isPresent()) {
      user = wrapperUser.get();
      if (user.getPassword().equals(request.getPassword())) {
        response.setError("");
        InfoLoggedUser data =
            new InfoLoggedUser(user.getId(), getRoleByUserId(user.getId()), user.getUsername());
        response.setData(data);
        response.setMessage("Ok");
        response.setSuccess(true);
      }
    }
    return response;
  }

  private String getRoleByUserId(Integer id) {
    if (administratorRepository.findById(id).isPresent()) {
      return "administrator";
    }
    if (cashierRepository.findById(id).isPresent()) {
      return "cashier";
    }
    if (chefRepository.findById(id).isPresent()) {
      return "chef";
    }
    if (customerRepository.findById(id).isPresent()) {
      return "customer";
    }
    if (waiterRepository.findById(id).isPresent()) {
      return "waiter";
    }
    return "user";
  }
}
