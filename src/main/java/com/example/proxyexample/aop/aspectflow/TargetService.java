package com.example.proxyexample.aop.aspectflow;

import org.springframework.stereotype.Service;

@Service
public class TargetService {

    public void doSomething(boolean throwError) {

        System.out.println(">>> 실제 비즈니스 로직 실행");

        if (throwError) {
            throw new RuntimeException("예외 발생!");
        }

        System.out.println(">>> 비즈니스 로직 정상 종료");
    }
}
