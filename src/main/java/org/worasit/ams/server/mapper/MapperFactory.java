package org.worasit.ams.server.mapper;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperFactory {

  private final DataSource dataSource;

  public MapperFactory(@Qualifier("dataSource") DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    return factoryBean.getObject();
  }

  @Bean
  public MapperFactoryBean<RoleMapper> userMapper() throws Exception {
    MapperFactoryBean<RoleMapper> factoryBean = new MapperFactoryBean<>(RoleMapper.class);
    factoryBean.setSqlSessionFactory(sqlSessionFactory());
    return factoryBean;
  }
}
