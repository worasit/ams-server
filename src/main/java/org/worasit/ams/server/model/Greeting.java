package org.worasit.ams.server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Greeting {
  long id;
  String content;
}
