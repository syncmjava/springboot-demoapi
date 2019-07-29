package com.example.demo.api.infra.datasource.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.db0")
public class Db0Properties {
  private String driverClassName;

  private String url;

  private String username;

  private String password;

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
