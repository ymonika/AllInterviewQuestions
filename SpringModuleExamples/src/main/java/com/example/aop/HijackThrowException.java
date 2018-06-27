package com.example.aop;

import org.springframework.aop.ThrowsAdvice;

public class HijackThrowException implements ThrowsAdvice {

    public void afterThrowing(Exception e) throws Throwable {
        System.out.println(this.getClass() + " Throw exception: " + e.getMessage());
    }
}
