package com.example.demo.api.infra.mapper;

import com.example.demo.api.infra.datasource.config.DataSourceName;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingMapper {
  @DataSourceName("db2")
  public int updateShopping();
}
