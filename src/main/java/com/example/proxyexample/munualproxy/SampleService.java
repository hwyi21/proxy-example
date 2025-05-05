package com.example.proxyexample.munualproxy;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

// 스프링 빈으로 등록될 대상
@Component
public class SampleService {

    // 생성자 → 가장 먼저 호출됨
    public SampleService() {
        System.out.println("SampleService 생성자 실행");
    }

    // @PostConstruct → 의존성 주입 후 초기화 단계에서 호출됨
    @PostConstruct
    public void init() {
        System.out.println("SampleService @PostConstruct 실행");
    }

    public void call() {
        System.out.println("SampleService 비즈니스 로직 실행");
    }
}