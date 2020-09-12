package org.worasit.ams.server.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worasit.ams.server.model.Greeting;

@RestController
public class GreetingController {
  String template = "Hello, %s!";
  AtomicLong counter = new AtomicLong();

  @RequestMapping(method = RequestMethod.GET, path = "/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return Greeting.builder()
        .id(counter.incrementAndGet())
        .content(String.format(template, name))
        .build();
  }
}
