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
import org.worasit.ams.server.service.GreetingService;

@RestController
public class GreetingController {

  public static final String TAG = "Greeting";
  AtomicLong counter = new AtomicLong();
  private final GreetingService greetingService;

  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @Operation(summary = "Say greeting to a guest", tags = TAG)
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
  public Greeting greeting(@RequestParam(defaultValue = "World") String guestName) {
    return greetingService.sayGreeting(counter.incrementAndGet(), guestName);
  }
}
