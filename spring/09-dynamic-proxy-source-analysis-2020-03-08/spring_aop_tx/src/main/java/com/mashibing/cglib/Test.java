package com.mashibing.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        //translatedTextclasstranslatedText
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"d:\\code");
        //translatedTextcglibtranslatedText
        Enhancer enhancer = new Enhancer();
        //translatedTextenhancertranslatedText
        enhancer.setSuperclass(MyCalculator.class);
        //translatedTextenhancertranslatedText
        enhancer.setCallback(new MyCglib());
        //translatedText
        MyCalculator myCalculator = (MyCalculator) enhancer.create();
        myCalculator.add(1,1);
        System.out.println(myCalculator.getClass());
    }
}
