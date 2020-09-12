package org.worasit.ams.server.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.worasit.ams.server.model.Greeting;

@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceTest {

  @InjectMocks private GreetingService greetingService;

  @Test
  public void sayGreeting_returnHelloWithName() {
    // Given
    final String guestName = "Worasit";
    final long guestId = 1L;

    // When
    final Greeting acutual = greetingService.sayGreeting(guestId, guestName);

    // Then
    Assert.assertEquals("Hello, Worasit!", acutual.getContent());
  }
}
