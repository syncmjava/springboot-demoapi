package com.example.demo.api.comm.transaction;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TransactionConfigurer {

  @Bean
  public PlatformTransactionManager transactionManager(
      @Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
    return new DataSourceTransactionManager(dynamicDataSource);
  }
}
