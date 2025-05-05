package com.example.proxyexample.aop.manualproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class AopFlowExample {

    public static void main(String[] args) {

        // 1. 프록시 팩토리 생성 → 실제 객체를 넣는다
        ProxyFactory factory = new ProxyFactory(new RealService());

        // 2. 프록시에 부가기능(Advice) 추가 → 여기서는 MethodInterceptor로 구현
        factory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {

                // ▶ AOP - 메서드 실행 전 부가기능 (ex. @Before, @Around 전)
                System.out.println("[AOP] 메서드 실행 전");

                // ▶ 실제 비즈니스 메서드 실행
                Object result = invocation.proceed();

                // ▶ AOP - 메서드 실행 후 부가기능 (ex. @AfterReturning, @After, @Around 후)
                System.out.println("[AOP] 메서드 실행 후");

                return result;
            }
        });

        // 3. 프록시 객체 획득 → 원본이 아닌 프록시가 리턴된다.
        Service proxy = (Service) factory.getProxy();

        // 4. 프록시를 통해 메서드 호출 → 프록시가 호출을 가로채고 부가기능이 실행됨
        proxy.call();
    }
}
