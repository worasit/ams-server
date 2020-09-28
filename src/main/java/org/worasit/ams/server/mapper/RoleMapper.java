package org.worasit.ams.server.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.worasit.ams.server.domain.Role;

@Mapper
public interface RoleMapper {

  @Results(
      id = "roleResultMap",
      value = {
        @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.INTEGER, id = true),
        @Result(property = "isActive", column = "is_active", jdbcType = JdbcType.BOOLEAN),
        @Result(property = "createdAt", column = "created_at", jdbcType = JdbcType.DATETIMEOFFSET),
        @Result(property = "updatedAt", column = "updated_at", jdbcType = JdbcType.DATETIMEOFFSET)
      })
  @Select("select * from roles")
  List<Role> getAllRoles();

  @Select("select * from roles where role_id = #{roleId}")
  @ResultMap("roleResultMap")
  Role getRoleById(Integer roleId);

  @Select(
      value =
          "insert into roles (code, name, description, updated_at, created_at) "
              + "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, current_timestamp, current_timestamp) RETURNING *")
  @ResultMap("roleResultMap")
  Role insertRole(Role role);

  @Select({
    "update roles",
    "set code = #{code,jdbcType=VARCHAR},",
    "name = #{name,jdbcType=VARCHAR},",
    "description = #{description,jdbcType=VARCHAR},",
    "updated_at = current_timestamp",
    "where role_id = #{roleId,jdbcType=INTEGER}",
    "RETURNING *;"
  })
  @ResultMap("roleResultMap")
  Role updateRole(Role role);

  @Delete("delete from roles where role_id = #{roleId}")
  @ResultMap("roleResultMap")
  Integer deleteRoleById(Integer roleId);

  @Select("delete from roles where code = #{code} " + "RETURNING *")
  @ResultMap("roleResultMap")
  List<Role> deleteRoleByCode(String code);
}
