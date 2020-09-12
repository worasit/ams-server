package org.worasit.ams.server.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

  @Autowired MockMvc mockMvc;

  @Test
  @AutoConfigureMockMvc
  public void greeting_returnMessageFromService() throws Exception {
    // Given
    final String guestName = "Worasit";
    final MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/greeting").param("guestName", guestName);
    final String expectedContent = String.format("Hello, %s!", guestName);

    // When
    final ResultActions action = mockMvc.perform(requestBuilder);

    // Then
    action
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expectedContent)));
  }
}
