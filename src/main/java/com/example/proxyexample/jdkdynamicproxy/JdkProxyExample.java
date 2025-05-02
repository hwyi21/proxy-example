package com.example.proxyexample.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample {

    public static void main(String[] args) {
        // 실제 서비스 객체 생성
        Service target = new RealService();

        // JDK Proxy를 사용하여 프록시 객체 생성
        // 여기서 프록시는 Service 인터페이스를 기반으로 생성됨
        Service proxy = (Service) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 클래스 로더
                new Class[]{Service.class},        // 프록시가 구현할 인터페이스 (인터페이스 기반 프록시)
                new InvocationHandler() {          // 프록시 호출 시 실행될 로직 (가로채기)
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 부가기능: 호출 전
                        System.out.println("프록시: 호출 전에 로그 남기기");

                        // 진짜 객체 호출 → 비즈니스 로직 실행
                        Object result = method.invoke(target, args);

                        // 부가기능: 호출 후
                        System.out.println("프록시: 호출 후에 로그 남기기");

                        return result;
                    }
                }
        );

        // 프록시를 통해 메서드 호출 (프록시 → 부가기능 → 진짜 객체 → 부가기능 → 반환)
        proxy.call();
    }
}
