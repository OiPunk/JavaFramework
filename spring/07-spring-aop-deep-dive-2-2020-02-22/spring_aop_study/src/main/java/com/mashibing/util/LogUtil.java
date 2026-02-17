package com.mashibing.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

//@Aspect
//@Component
//@Order(200)
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
     *
     * translatedText：
     *  translatedText：
     *      public Integer com.mashibing.service.MyCalculator.add(Integer,Integer)
     *  translatedText，translatedText
     *      *：
     *          1、translatedText
     *          execution( public Integer com.mashibing.service.MyCalculator.*(Integer,Integer)
     *          2、translatedText，translatedText
     *          execution( public Integer com.mashibing.service.M*Calculator.*(Integer,*))
     *          3、*translatedText，translatedText
     *          4、*translatedText，translatedText，translatedText
     *          execution( Integer com.mashibing.service.MyCalculator.*(Integer,*))
     *          5、translatedText*translatedText
     *      ..:
     *          1、translatedText，translatedText
     *          execution(* com.mashibing.service.MyCalculator.*(..))
     *          2、translatedText
     *          execution(* com.mashibing..MyCalculator*.*(..))
     *     translatedText：
     *          execution(* *(..))
     *          execution(* com..*(..))
     *      translatedText*translatedText，translatedText
     *
     *      translatedText
     *      &&:translatedText
     *          execution(public Integer com.mashibing.service.MyCalculator.*(..)) && execution(* *(..))
     *      ||：translatedText
     *          execution(public Integer com.mashibing.service.MyCalculator.*(..)) || execution(* *(..))
     *      !：translatedText,translatedText
     *          !execution(public Integer com.mashibing.service.MyCalculator.add(Integer,Integer))
     *
     *      translatedText，translatedText，
     *      translatedText
     *
     *      translatedText：
     *      translatedText：@Before--》@After----》@AfterReturning
     *      translatedText：@Before--》@After----》@AfterThrowing
     *
     *
     *      translatedText，translatedTextJoinPointtranslatedText，translatedText
     *      getSignature()
     *      getArgs()
     *      translatedText，translatedText Returing="result" ,translatedTextresulttranslatedText
     *      translatedText，translatedTextThrowing="e" translatedTextetranslatedText
     *      translatedText，translatedTextargs(translatedText)，ArgNames(translatedText)
     *          @Before(value = "execution(public Integer com.mashibing.service.MyCalculator.*(Integer,Integer)) && args(joinPoint,k)",argNames = "joinPoint,k")
     *
     *
     *      translatedText？
     *          translatedText、translatedText，
     *          translatedText，translatedText
     *
     *      translatedText，translatedText？
     *          translatedText，translatedText@PointCuttranslatedText，translatedText
     *          translatedText，translatedText
     *
     *
     *      translatedText：
     *          translatedText
     *          translatedText，translatedText：
     *              translatedText--》@Before--》translatedText--》translatedText--》@After--》@AfterReturning
     *          translatedText，translatedText：
     *              translatedText--》@Before--》translatedText--》translatedText--》@After--》@AfterReturing
     *              translatedText，translatedText，translatedText，translatedText throw throwable
     *              translatedText：
     *              translatedText--》@Before--》translatedText--》translatedText--》@After--》@AfterThrowing
     *
     *      translatedText，translatedText？
     *          translatedText，translatedText
     *          translatedText，translatedText@OrdertranslatedText
     *          translatedText，translatedText
     */

    @Pointcut("execution(public Integer com.mashibing.service.MyCalculator.*(Integer,Integer))")
    public void myPointCut(){}

    @Pointcut("execution(* *(..))")
    public void myPointCut1(){}

    @Before(value = "myPointCut()")
    private int start(JoinPoint joinPoint){
        //translatedText
        Signature signature = joinPoint.getSignature();
        //translatedText
        Object[] args = joinPoint.getArgs();
        System.out.println("log---"+signature.getName()+"translatedText：translatedText"+Arrays.asList(args));
        return 100;
    }

    @AfterReturning(value = "myPointCut()",returning = "result")
    public static void stop(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("log---"+signature.getName()+"translatedText，translatedText："+result);
    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("log---"+signature.getName()+"translatedText："+e.getMessage());
    }

    @After("myPointCut()")
    public static void logFinally(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("log---"+signature.getName()+"translatedText。。。。。over");

    }

     @Around("myPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            System.out.println("log---translatedTextstart："+signature.getName()+"translatedText，translatedText："+Arrays.asList(args));
            //translatedText，translatedTextmethod.invoke(),translatedText
            result = pjp.proceed(args);
//            result=100;
            System.out.println("log---translatedTextstop"+signature.getName()+"translatedText");
        } catch (Throwable throwable) {
            System.out.println("log---translatedText："+signature.getName()+"translatedText");
            throw throwable;
        }finally {
            System.out.println("log---translatedText："+signature.getName()+"translatedText："+result);
        }
        return result;
    }
}
