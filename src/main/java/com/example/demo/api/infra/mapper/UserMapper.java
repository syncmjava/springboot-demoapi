package com.example.demo.api.infra.mapper;

import com.example.demo.api.domain.model.User;
import com.example.demo.api.infra.datasource.config.DataSourceName;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  @DataSourceName("db0")
  public User selectUser();
}
