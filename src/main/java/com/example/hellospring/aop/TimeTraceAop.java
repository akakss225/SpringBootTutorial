package com.example.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP 로 쓰겠다 선언
@Component
public class TimeTraceAop {
//    controller에서 Service를 호출할 때, AOP를 사용하면 프록시라는 가짜 Service를 만들어낸다.
//    이후 이 프록시가 끝나면 실제 Service를 호출해준다. >> joinPoint.proceed() 가 프록시 종료선언.

    @Around("execution(* com.example.hellospring..*(..))")
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try{
            // 라인을 합치게 줄여주는 단축키 : option + cmd + N
            return joinPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");

        }


    }
}
