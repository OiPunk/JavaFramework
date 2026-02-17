package com.mashibing.factory;

import com.mashibing.bean.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * translatedTextspringtranslatedTextbeantranslatedText，translatedText，
 * translatedTextspring IOCtranslatedText，translatedText，translatedText
 * translatedText，translatedText
 */
public class MyFactoryBean implements FactoryBean<Person> {
    /*
    * translatedTextbean
    * */
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setId(3);
        person.setName("translatedText");
        return person;
    }

    //translatedTextbeantranslatedText
    public Class<?> getObjectType() {
        return Person.class;
    }

    //translatedTextbeantranslatedText
    public boolean isSingleton() {
        return true;
    }
}
