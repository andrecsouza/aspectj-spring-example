package com.javacodegeeks.aspectjspring.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class GreetingAspect {

    private String message;


    public void setMessage(String message) {
        this.message = message;
    }


    @Around("execution(* com.javacodegeeks.aspectjspring.services.GreetingService.*(..))")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        String serviceGreeting = (String) pjp.proceed();
        return message + " <and> " + serviceGreeting;
    }

}