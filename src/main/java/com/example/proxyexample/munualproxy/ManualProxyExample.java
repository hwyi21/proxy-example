package com.example.proxyexample.munualproxy;


public class ManualProxyExample {
    public static void main(String[] args) {
        Service target = new RealService(); // 진짜 서비스
        Service proxy = new LoggingProxy(target); // 프록시 생성

        proxy.call(); // 프록시를 통해 호출 → 부가기능 + 비즈니스 로직 실행됨
    }
}