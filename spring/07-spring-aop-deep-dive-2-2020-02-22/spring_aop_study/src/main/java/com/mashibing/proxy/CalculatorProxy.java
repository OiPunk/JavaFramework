package com.mashibing.proxy;

import com.mashibing.service.Calculator;
import com.mashibing.util.LogUtil;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * translatedText，translatedText，translatedText，translatedTextjdktranslatedTextreflecttranslatedText
 * translatedText，translatedTextcglib
 *
 * cglibtranslatedText
 *
 * translatedTextspringtranslatedText，translatedTextjdktranslatedText（translatedText）translatedTextcglib
 */
public class CalculatorProxy {

    public static Calculator getProxy( final Calculator calculator){

        //translatedText
        ClassLoader loader = calculator.getClass().getClassLoader();
        //translatedText
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        //translatedText
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try{
//                     System.out.println(method.getName()+"translatedText，translatedText："+ Arrays.asList(args));
//                    LogUtil.start(method,args);
                    //translatedText
                    //start
                    result = method.invoke(calculator,args);
                    //end
//                    System.out.println(method.getName()+"translatedText，translatedText："+result);
//                    LogUtil.stop(method,result);
                }catch (Exception e){
//                    System.out.println(method.getName()+"translatedText："+e.getMessage());
//                    LogUtil.logException(method,e);
                }finally {
//                    System.out.println(method.getName()+"translatedText。。。。。over");
//                    LogUtil.logFinally(method);
                }
                return result;
            }
        };
        Object o = Proxy.newProxyInstance(loader, interfaces, handler);
        return (Calculator) o;
    }
}
