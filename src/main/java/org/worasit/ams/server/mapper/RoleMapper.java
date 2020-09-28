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
              + "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR},#{updatedAt,jdbcType=TIMESTAMP}, #{createdAt,jdbcType=TIMESTAMP}) RETURNING *")
  @ResultMap("roleResultMap")
  Role insertRole(Role role);

  @Delete("delete from roles where role_id = #{roleId}")
  @ResultMap("roleResultMap")
  Integer deleteRoleById(Integer roleId);

  @Select("delete from roles where code = #{code} " + "RETURNING *")
  @ResultMap("roleResultMap")
  List<Role> deleteRoleByCode(String code);
}
