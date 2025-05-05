package com.example.proxyexample.aop;

public class RealService implements Service {

    @Override
    public void call() {
        System.out.println("RealService 호출");
    }
}