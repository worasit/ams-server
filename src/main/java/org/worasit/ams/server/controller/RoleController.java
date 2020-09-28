package org.worasit.ams.server.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  @ResponseStatus(value = HttpStatus.CREATED)
  public Role createNewRole(@RequestBody Role role) {
    return roleMapper.insertRole(role);
  }

  @DeleteMapping("/roles/{id}")
  public Integer deleteRole(@PathVariable("id") Integer id) {
    return roleMapper.deleteRoleById(id);
  }

  @DeleteMapping("/roles")
  public List<Role> deleteRole(@RequestParam(value = "code") String code) {
    return roleMapper.deleteRoleByCode(code);
  }
}
