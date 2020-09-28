package org.worasit.ams.server.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.worasit.ams.server.domain.User;
import org.worasit.ams.server.mapper.UserMapper;

@RestController
public class UserController {

  private final UserMapper userMapper;

  public UserController(@Qualifier("userMapper") UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userMapper.getAllUsers();
  }
}
