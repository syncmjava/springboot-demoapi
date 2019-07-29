package com.example.demo.api.infra.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
  @Override
  protected Object determineCurrentLookupKey() {
    log.info("Current DataSource is [{}]", DataSourceContextHolder.getDataSourceKey());
    return DataSourceContextHolder.getDataSourceKey();
  }
}
