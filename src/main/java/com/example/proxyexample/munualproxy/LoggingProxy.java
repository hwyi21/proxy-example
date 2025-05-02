package com.example.proxyexample.munualproxy;

// 프록시 객체 (부가기능을 추가함)
public class LoggingProxy implements Service {

    private final Service target; // 진짜 객체(RealService)를 참조

    public LoggingProxy(Service target) {
        this.target = target;
    }

    @Override
    public void call() {
        // 왜 프록시인가?
        // => 클라이언트가 직접 RealService를 호출하는 대신, LoggingProxy가 대신 호출하기 때문
        // 프록시란 객체 생성 방식이 아니라 호출 흐름(대리 호출 + 부가기능 처리)이 본질이다.

        // 부가기능: 호출 전
        System.out.println("프록시: 호출 전에 로그 남기기");

        // 실제 비즈니스 로직 호출
        target.call();

        // 부가기능: 호출 후
        System.out.println("프록시: 호출 후에 로그 남기기");
    }
}
