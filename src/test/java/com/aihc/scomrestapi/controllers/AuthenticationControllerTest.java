package com.aihc.scomrestapi.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.aihc.scomrestapi.services.AuthenticationService;
import com.aihc.scomrestapi.utils.builders.JsonSerializerHelper;
import com.aihc.scomrestapi.utils.builders.LoginBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private AuthenticationService authService;

  @Test
  void logIn() throws Exception {
    System.out.println("hola");
    when(authService.authenticateUser(LoginBuilder.buildValidRequest()))
        .thenReturn(LoginBuilder.buildBadResponse());

    MvcResult result =
        mockMvc
            .perform(
                post("/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JsonSerializerHelper.toString(LoginBuilder.buildValidRequest())))
            .andDo(print())
            .andReturn();

    Assertions.assertEquals(
        JsonSerializerHelper.toString(LoginBuilder.buildBadResponse()),
        result.getResponse().getContentAsString());
    Assertions.assertTrue(
        result
            .getResponse()
            .getContentAsString()
            .contains("\"error\":\"Username or email wrong\""));
  }
}
