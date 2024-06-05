package com.example.springdemo.framework.wait_strategy;

import com.example.springdemo.Configuration;
import java.time.Duration;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OptionalTimeoutAspect {
  @Autowired WaitHelper waitHelper;

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
    waitHelper.setTimeout(Duration.ofSeconds(timeout));
    try {
      return waitHelperMethod.proceed();
    } finally {
      waitHelper.setTimeout(Configuration.DEFAULT_TIMEOUT_DURATION);
    }
  }
}
