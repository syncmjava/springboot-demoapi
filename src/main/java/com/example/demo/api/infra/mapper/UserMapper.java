package com.example.demo.api.infra.mapper;

import com.example.demo.api.comm.annotation.DataSourceTarget;
import com.example.demo.api.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  @DataSourceTarget("dynamic_db0")
  public User selectUser();
}
