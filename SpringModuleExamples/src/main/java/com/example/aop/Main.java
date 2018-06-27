package com.example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"classpath:application-context.xml"});

        CustomerService cust = (CustomerService) appContext.getBean("customerServiceProxy");

        System.out.println("_________________________");
        cust.printName();
        System.out.println("_________________________");
        cust.printURL();
        System.out.println("_________________________");
        try {
            cust.printThrowException();
        } catch (Exception e) {

        }

    }
}
