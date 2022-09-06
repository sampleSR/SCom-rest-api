package com.aihc.scomrestapi.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.aihc.scomrestapi.dtos.LoginResponseDTO;
import com.aihc.scomrestapi.repositories.UserRepository;
import com.aihc.scomrestapi.utils.builders.LoginBuilder;
import com.aihc.scomrestapi.utils.builders.UserBuilder;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

  @Mock private UserRepository userRepository;

  @InjectMocks AuthenticationService authenticationService;

  @Test
  public void should_getSuccessResponse_when_requestIsCorrect() {
    when(userRepository.findByUsernameOrEmail(any(String.class), any(String.class)))
        .thenReturn(Optional.of(UserBuilder.buildAcceptedUser()));

    LoginResponseDTO response =
        authenticationService.authenticateUser(LoginBuilder.buildValidRequest());

    assertTrue(response.getSuccess());
  }
}
