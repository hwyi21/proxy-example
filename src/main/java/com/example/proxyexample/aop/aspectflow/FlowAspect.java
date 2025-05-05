package com.example.proxyexample.aop.aspectflow;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FlowAspect {

    // Pointcut: 실행 흐름 테스트용 메서드만 지정
    @Pointcut("execution(* com.example.proxyexample.aop.aspectflow.TargetService.doSomething(..))")
    public void targetMethod() {}

    // @Around → 가장 바깥에서 메서드 실행 전후 전체 감쌈
    @Around("targetMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[@Around] 메서드 실행 전");

        // proceed()는 실제 비즈니스 메서드를 실행하는 트리거 역할이다.
        // 호출하지 않으면 메서드가 실행되지 않는다 → 실행 여부를 직접 제어 가능
        Object result = joinPoint.proceed();

        System.out.println("[@Around] 메서드 실행 후");
        return result;
    }

    // @Before → 메서드 실행 직전
    @Before("targetMethod()")
    public void before() {
        System.out.println("[@Before] 메서드 실행 직전");
    }

    // @AfterReturning → 메서드가 정상적으로 리턴했을 때
    @AfterReturning("targetMethod()")
    public void afterReturning() {
        System.out.println("[@AfterReturning] 메서드 정상 종료 후");
    }

    // @AfterThrowing → 예외가 발생했을 때
    @AfterThrowing("targetMethod()")
    public void afterThrowing() {
        System.out.println("[@AfterThrowing] 예외 발생 후");
    }

    // @After → 정상/예외 관계 없이 항상 마지막에 실행
    @After("targetMethod()")
    public void after() {
        System.out.println("[@After] 메서드 실행 후(정상/예외 상관없이)");
    }
}
