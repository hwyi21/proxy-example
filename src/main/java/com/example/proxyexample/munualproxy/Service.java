package com.example.proxyexample.munualproxy;

// 서비스 인터페이스 (클라이언트, 프록시, 실제 서비스 모두 따름)
public interface Service {

    void call(); // 프록시와 실제 객체가 모두 동일한 메서드 제공 (프록시 패턴 핵심 포인트)
}

