package com.example.proxyexample.aop.aspectflow;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.proxyexample")
public class AopFlowApplication implements CommandLineRunner {

    private final TargetService targetService;

    public AopFlowApplication(TargetService targetService) {
        this.targetService = targetService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopFlowApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("===== 정상 실행 =====");
        targetService.doSomething(false);

        System.out.println("\n===== 예외 발생 실행 =====");
        try {
            targetService.doSomething(true);
        } catch (Exception e) {
            System.out.println("[메인] 예외 캐치: " + e.getMessage());
        }
    }
}
