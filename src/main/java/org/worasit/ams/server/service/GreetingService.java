package org.worasit.ams.server.service;

import org.springframework.stereotype.Service;
import org.worasit.ams.server.model.Greeting;

@Service
public class GreetingService {

  public static final String GREETING_TEMPLATE = "Hello, %s!";

  public Greeting sayGreeting(Long id, String guestName) {
    return Greeting.builder().id(id).content(String.format(GREETING_TEMPLATE, guestName)).build();
  }
}
