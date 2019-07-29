package com.example.demo.api.infra.mapper;

import com.example.demo.api.comm.annotation.DataSourceTarget;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BudgetMapper {
  @DataSourceTarget("dynamic_db1")
  public int updateBudget();
}
