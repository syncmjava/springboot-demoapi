package com.example.demo.api.comm.transaction;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;

@Aspect
@Configuration
@RequiredArgsConstructor
@Order(20)
public class TxAdviceInterceptor {

  private static final String TX_METHOD_NAME = "*";
  private static final int TX_METHOD_TIMEOUT = 3;
  private static final String AOP_POINTCUT_EXPRESSION =
      "execution(* com.example.demo.api.domain.service..*.*(..))";

  @NonNull private PlatformTransactionManager transactionManager;

  @Bean
  public TransactionInterceptor txAdvice() {
    MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
    RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
    transactionAttribute.setName(TX_METHOD_NAME);
    transactionAttribute.setRollbackRules(
        Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
    transactionAttribute.setTimeout(TX_METHOD_TIMEOUT);
    source.setTransactionAttribute(transactionAttribute);
    TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);

    return txAdvice;
  }

  @Bean
  public Advisor txAdviceAdvisor() {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
    return new DefaultPointcutAdvisor(pointcut, txAdvice());
  }
}
