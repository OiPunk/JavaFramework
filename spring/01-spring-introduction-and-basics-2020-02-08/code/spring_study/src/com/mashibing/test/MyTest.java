package com.mashibing.test;

import com.mashibing.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//translatedTextpersontranslatedText？
//translatedText
public class MyTest {
    public static void main(String[] args) {
        /*
        * applicationContext:translatedTextIOCtranslatedText，translatedText，translatedText
        *   translatedText
        *       ClassPathXmlApplicationContext:translatedTextclasspathtranslatedText
        *       FileSystemXmlApplicationContext:translatedText
        *
        *
        * * */
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        //translatedTextbeantranslatedText，translatedText
//        Person person = (Person) context.getBean("person");
        //translatedText
//        Person person = context.getBean("person", Person.class);
//        System.out.println(person);
    }
}
