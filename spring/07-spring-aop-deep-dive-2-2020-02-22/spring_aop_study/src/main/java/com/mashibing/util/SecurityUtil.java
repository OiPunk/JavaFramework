package com.mashibing.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Aspect
//@Component
//@Order(100)
public class SecurityUtil {

    @Pointcut("execution(public Integer com.mashibing.service.MyCalculator.*(Integer,Integer))")
    public void myPointCut(){}



    @Before(value = "myPointCut()")
    private int start(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("Security---"+signature.getName()+"translatedText：translatedText"+Arrays.asList(args));
        return 100;
    }

    @AfterReturning(value = "myPointCut()",returning = "result")
    public static void stop(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("Security---"+signature.getName()+"translatedText，translatedText："+result);
    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("Security---"+signature.getName()+"translatedText："+e.getMessage());
    }

    @After("myPointCut()")
    public static void logFinally(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("Security---"+signature.getName()+"translatedText。。。。。over");

    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            System.out.println("Security---translatedTextstart："+signature.getName()+"translatedText，translatedText："+ Arrays.asList(args));
            //translatedText，translatedTextmethod.invoke(),translatedText
            result = pjp.proceed(args);
//            result=100;
            System.out.println("Security---translatedTextstop"+signature.getName()+"translatedText");
        } catch (Throwable throwable) {
            System.out.println("Security---translatedText："+signature.getName()+"translatedText");
            throw throwable;
        }finally {
            System.out.println("Security---translatedText："+signature.getName()+"translatedText："+result);
        }
        return result;
    }
}
