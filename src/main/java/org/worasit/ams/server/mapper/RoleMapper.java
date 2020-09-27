package org.worasit.ams.server.mapper;

import java.util.List;
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

  @ResultMap("roleResultMap")
  @Select("select * from roles where role_id = #{roleId}")
  Role getRoleById(Integer roleId);
}
