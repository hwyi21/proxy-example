package com.example.proxyexample.jdkdynamicproxy;

// 실제 비즈니스 로직 담당 클래스 (Real Object)
public class RealService implements Service {

    @Override
    public void call() {
        System.out.println("RealService 호출");
    }
}
