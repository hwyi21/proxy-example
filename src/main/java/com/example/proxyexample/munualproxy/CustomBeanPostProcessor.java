package com.example.proxyexample.munualproxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    // 빈 초기화 전 (의존성 주입 완료 후, 초기화 메서드 실행 전)
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor] Before Initialization: " + beanName);
        return bean;
    }

    // 빈 초기화 후 (@PostConstruct 실행 후)
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor] After Initialization: " + beanName);
        return bean;
    }
}
