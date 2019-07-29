package com.example.demo.api.infra.datasource.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.demo.api.infra.datasource.prop.Db0Properties;
import com.example.demo.api.infra.datasource.prop.Db1Properties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
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
      log.error("Create DataSource Error : {}", e);
      throw new RuntimeException();
    }
    return dataSource;
  }

  @Bean("db1")
  public DataSource dataSource1() {
    DataSource dataSource = null;
    try {
      dataSource = DruidDataSourceFactory.createDataSource(db1Properties.getProperties());
    } catch (Exception e) {
      log.error("Create DataSource Error : {}", e);
      throw new RuntimeException();
    }
    return dataSource;
  }

  @Bean("dynamicDataSource")
  public DataSource dynamicDataSource() {
    DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
    Map<Object, Object> dataSourceMap = new HashMap<>();
    dataSourceMap.put("dynamic_db0", dataSource0());
    dataSourceMap.put("dynamic_db1", dataSource1());
    dynamicRoutingDataSource.setDefaultTargetDataSource(dataSource0());
    dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);

    return dynamicRoutingDataSource;
  }

  @Bean
  @ConfigurationProperties(prefix = "mybatis")
  public SqlSessionFactory sqlSessionFactory(
      @Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dynamicDataSource);
    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager(
      @Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
    return new DataSourceTransactionManager(dynamicDataSource);
  }
}
