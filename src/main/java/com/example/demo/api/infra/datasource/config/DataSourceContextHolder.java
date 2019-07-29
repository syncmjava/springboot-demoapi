package com.example.demo.api.infra.datasource.config;

public class DataSourceContextHolder {
  private static final ThreadLocal<String> contextHolder =
      new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
          return "dynamic_db0";
        }
      };

  public static void setDataSourceKey(String key) {
    contextHolder.set(key);
  }

  public static String getDataSourceKey() {
    return contextHolder.get();
  }

  public static void clearDataSourceKey() {
    contextHolder.remove();
  }
}
