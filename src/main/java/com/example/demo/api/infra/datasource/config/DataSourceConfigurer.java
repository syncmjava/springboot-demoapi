package com.example.demo.api.infra.datasource.config;

import com.example.demo.api.infra.datasource.prop.Db0Properties;
import com.example.demo.api.infra.datasource.prop.Db1Properties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfigurer {

  @NonNull private Db0Properties db0Properties;

  @NonNull private Db1Properties db1Properties;

  @Bean("db0")
  @Primary
  public DataSource dataSource0() {
    DataSource dataSource = null;
    try {
      dataSource = DruidDataSourceFactory.createDataSource(db0Properties.getProperties());
    } catch (Exception e) {
      LOGGER.error("Create DataSource Error : {}", e);
      throw new RuntimeException();
    }
    return dataSource;
  }
}
