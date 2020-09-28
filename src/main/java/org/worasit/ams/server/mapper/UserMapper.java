package org.worasit.ams.server.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.worasit.ams.server.domain.User;

@Mapper
public interface UserMapper {
  @Results(
      id = "userResultMap",
      value = {
        @Result(column = "user_id", jdbcType = JdbcType.INTEGER, property = "userId", id = true),
        @Result(column = "role_id", jdbcType = JdbcType.INTEGER, property = "roleId"),
        @Result(column = "user_code", jdbcType = JdbcType.VARCHAR, property = "userCode"),
        @Result(column = "first_name", jdbcType = JdbcType.VARCHAR, property = "firstName"),
        @Result(column = "last_name", jdbcType = JdbcType.VARCHAR, property = "lastName"),
        @Result(column = "display_name", jdbcType = JdbcType.VARCHAR, property = "displayName"),
        @Result(column = "phone_number", jdbcType = JdbcType.VARCHAR, property = "phoneNumber"),
        @Result(column = "email", jdbcType = JdbcType.VARCHAR, property = "email"),
        @Result(column = "address", jdbcType = JdbcType.VARCHAR, property = "address"),
        @Result(property = "isActive", column = "is_active", jdbcType = JdbcType.BOOLEAN),
        @Result(property = "createdAt", column = "created_at", jdbcType = JdbcType.DATETIMEOFFSET),
        @Result(property = "updatedAt", column = "updated_at", jdbcType = JdbcType.DATETIMEOFFSET)
      })
  @Select("select * from users")
  List<User> getAllUsers();
}
