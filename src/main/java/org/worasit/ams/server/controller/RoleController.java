package org.worasit.ams.server.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.worasit.ams.server.domain.Role;
import org.worasit.ams.server.mapper.RoleMapper;

@RestController
public class RoleController {

  private final RoleMapper roleMapper;

  public RoleController(RoleMapper roleMapper) {
    this.roleMapper = roleMapper;
  }

  @GetMapping("/roles")
  public List<Role> getAllRoles() {
    return roleMapper.getAllRoles();
  }

  @GetMapping("/roles/{id}")
  public Role getAllRoles(@PathVariable("id") Integer id) {
    return roleMapper.getRoleById(id);
  }

  @PostMapping(value = "/roles")
  public Integer createNewRole(@RequestBody Role role) {
    return roleMapper.insertRole(role);
  }
}
