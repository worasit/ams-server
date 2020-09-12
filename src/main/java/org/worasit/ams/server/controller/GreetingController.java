package org.worasit.ams.server.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worasit.ams.server.model.Greeting;

@RestController
public class GreetingController {
  String template = "Hello, %s!";
  AtomicLong counter = new AtomicLong();

  @Operation(summary = "Say greeting to a guest")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Say greeting to specific guest",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Greeting.class))
            })
      })
  @GetMapping(path = "/greeting")
  public Greeting greeting(
      @RequestParam(defaultValue = "World", name = "Guest's name") String guestName) {
    return Greeting.builder()
        .id(counter.incrementAndGet())
        .content(String.format(template, guestName))
        .build();
  }
}
