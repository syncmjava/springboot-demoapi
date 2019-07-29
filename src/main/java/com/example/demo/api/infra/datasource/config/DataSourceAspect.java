package com.example.demo.api.infra.datasource.config;

import com.example.demo.api.comm.annotation.DataSourceTarget;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Slf4j
@Aspect
public class DataSourceAspect {

  @Pointcut("@annotation(com.example.demo.api.comm.annotation.DataSourceTarget)")
  public void mapperAspect() {}

  @Around("mapperAspect()")
  public Object proceedAround(ProceedingJoinPoint pjp) throws Throwable {

    MethodSignature signature = (MethodSignature) pjp.getSignature();
      Method method = signature.getMethod();
      DataSourceTarget dsTarget = method.getAnnotation(DataSourceTarget.class);
      if (dsTarget==null){
          DataSourceContextHolder.setDataSourceKey("dynamic_db0");
      }else{
          DataSourceContextHolder.setDataSourceKey(dsTarget.value());
      }

    try {
      return pjp.proceed();
    } finally {
      DataSourceContextHolder.clearDataSourceKey();
      log.info("clearDataSourceKey ");
    }
  }
}
