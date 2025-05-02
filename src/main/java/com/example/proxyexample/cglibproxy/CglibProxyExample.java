package com.example.proxyexample.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample {

    public static void main(String[] args) {
        // CGLIB의 프록시 생성기 Enhancer 사용
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealService.class); // 프록시가 상속할 클래스 설정

        // 프록시가 가로챌 로직 설정
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

                // 부가기능: 호출 전
                System.out.println("프록시: 호출 전에 로그 남기기");

                // 진짜 객체 메서드 호출 (invokeSuper → 부모 메서드 호출)
                Object result = proxy.invokeSuper(obj, args);

                // 부가기능: 호출 후
                System.out.println("프록시: 호출 후에 로그 남기기");

                return result;
            }
        });

        // 프록시 객체 생성 (실제 RealService와 동일하게 동작)
        RealService proxy = (RealService) enhancer.create();

        // 프록시를 통해 메서드 호출 (→ 부가기능 + 비즈니스 로직 실행됨)
        proxy.call();
    }
}
