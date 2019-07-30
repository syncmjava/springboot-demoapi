package com.example.demo.api.infra.datasource.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.db0")
public class Db0Properties extends AbstractDbProperties {
  private String driverClassName;

  private String url;

  private String username;

  private String password;
}
