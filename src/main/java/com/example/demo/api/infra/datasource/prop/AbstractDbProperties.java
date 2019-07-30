package com.example.demo.api.infra.datasource.prop;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Data
public abstract class AbstractDbProperties {

  protected abstract String getUrl();

  protected abstract String getUsername();

  protected abstract String getPassword();

  protected abstract String getDriverClassName();

  public Map<String, Object> getProperties() {
    Map<String, Object> map = new HashMap<>();
    map.put("driverClassName", this.getDriverClassName());
    map.put("url", this.getUrl());
    map.put("username", this.getUsername());
    map.put("password", this.getPassword());
    return map;
  }

  public Properties getProperties2() {

    Properties properties = new Properties();
    properties.setProperty("user", this.getUsername());
    properties.setProperty("password", this.getPassword());
    properties.setProperty("url", this.getUrl());

    return properties;
  }
}
