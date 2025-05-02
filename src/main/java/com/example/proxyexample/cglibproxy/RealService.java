package com.example.proxyexample.cglibproxy;


// 실제 비즈니스 로직 (인터페이스 없이 클래스만 존재)
// CGLIB은 클래스 상속 기반 프록시이기 때문에 인터페이스가 없어도 프록시 생성 가능
// 즉, 이 클래스는 프록시를 만들기 위해 별도의 인터페이스를 구현하지 않아도 된다.
public class RealService {

    public void call() {
        System.out.println("RealService 호출");
    }
}