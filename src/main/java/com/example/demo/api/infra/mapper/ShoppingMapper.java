package com.example.demo.api.infra.mapper;

import com.example.demo.api.comm.annotation.DataSourceTarget;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingMapper {
  @DataSourceTarget("dynamic_db2")
  public int updateShopping();
}
