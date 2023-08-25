package com.musanli.practice.spring.register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRegisterBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AutoConfiguredMapperScannerRegistrar.class);
        applicationContext.refresh();
        applicationContext.getBean(AutoConfiguredMapperScannerRegistrar.class);
        Object abcd = applicationContext.getBean("abcd");
    }
}
