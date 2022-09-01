package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;
import com.aihc.scomrestapi.models.User;
import com.aihc.scomrestapi.repositories.UserRepository;
import com.aihc.scomrestapi.utils.builders.LoginBuilder;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final UserRepository userRepository;

  public AuthenticationService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LoginResponseDTO authenticateUser(LoginRequestDTO request) {

    Optional<User> wrapperUser =
        userRepository.findByUsernameOrEmail(
            request.getUsernameOrEmail(), request.getUsernameOrEmail());

    LoginResponseDTO response = LoginBuilder.buildBadResponse();

    User user = new User();
    if (wrapperUser.isPresent()) {
      user = wrapperUser.get();
    }
    if (user.getPassword().equals(request.getPassword())) {
      response.setError("");
      response.setData("token");
      response.setMessage("Ok");
      response.setSuccess(true);
    }
    return response;
  }
}
