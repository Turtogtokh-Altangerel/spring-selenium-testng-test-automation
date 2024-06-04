package com.example.springdemo.framework.wait_strategy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OptionalTimeoutAspect {
  @Pointcut("execution(* com.example.springdemo.framework.wait_strategy.WaitHelper.*(int, ..))")
  public void isWaitHelperMethodWithIntArg() {}

  @Pointcut("@annotation(com.example.springdemo.framework.wait_strategy.OptionalTimeout)")
  public void hasOptionalTimeoutAnnotation() {}

  @Around(
      "isWaitHelperMethodWithIntArg() && "
          + "hasOptionalTimeoutAnnotation() && "
          + "args(timeout, ..)")
  public Object applyCustomTimeout(ProceedingJoinPoint waitHelperMethod, int timeout)
      throws Throwable {
    System.out.println("Set custom timeout to " + timeout);
    try {
      return waitHelperMethod.proceed();
    } finally {
      System.out.println("Set default timeout");
    }
  }
}
