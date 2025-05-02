package com.example.proxyexample.munualproxy;

// 실제 비즈니스 로직을 담당하는 진짜 객체 (Real Object)
public class RealService implements Service {

    @Override
    public void call() {
        System.out.println("RealService 호출");
    }
}