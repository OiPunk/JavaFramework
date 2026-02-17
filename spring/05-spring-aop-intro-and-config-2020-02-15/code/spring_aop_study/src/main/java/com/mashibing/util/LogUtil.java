package com.mashibing.util;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class LogUtil {
    /**
     * translatedText：
     *
     * @Before:translatedText，translatedText
     * @After：translatedText，translatedText
     * @AfterReturing：translatedText：translatedText
     * @AfterThrowing：translatedText：translatedText
     * @Around：translatedText
     *
     * translatedText，translatedText
     */

    @Before("execution( public Integer com.mashibing.service.MyCalculator.add(Integer,Integer))")
    public static void start(){
        System.out.println("translatedText：translatedText");
    }

    @AfterReturning("execution( public Integer com.mashibing.service.MyCalculator.add(Integer,Integer))")
    public static void stop(){
        System.out.println("translatedText，translatedText：");
    }

    @AfterThrowing("execution( public Integer com.mashibing.service.MyCalculator.add(Integer,Integer))")
    public static void logException(){
        System.out.println("translatedText：");
    }

    @After("execution( public Integer com.mashibing.service.MyCalculator.add(Integer,Integer))")
    public static void logFinally(){
        System.out.println("translatedText。。。。。over");

    }
}
