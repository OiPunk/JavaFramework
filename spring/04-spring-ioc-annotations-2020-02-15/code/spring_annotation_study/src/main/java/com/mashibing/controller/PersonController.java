package com.mashibing.controller;

import com.mashibing.dao.PersonDao;
import com.mashibing.service.PersonService;
import com.mashibing.service.PersonService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
//@Scope(value = "prototype")
public class PersonController {

    /**
     * translatedText@AutoWiredtranslatedText
     * translatedText？
     * translatedTextByTypetranslatedText,translatedText，translatedText
     * translatedTextbeantranslatedText，translatedTextidtranslatedText，translatedTextidtranslatedText
     * translatedText，translatedText
     * <p>
     * translatedText，translatedText，translatedText@Qualifier
     * <p>
     * translatedText@AutoWiredtranslatedText，translatedText，translatedText
     *
     * @QualifiertranslatedText,translatedTextidtranslatedText translatedText@ResourcetranslatedText@AutoWiredtranslatedText，translatedText
     * 1、@ResourcetranslatedTextjdktranslatedText，@AutoWiredtranslatedTextspringtranslatedText
     * 2、@ResourcetranslatedText，translatedText@AutoWiredtranslatedTextspringtranslatedText
     *      translatedText：@ResourcetranslatedText，translatedText@AutoWiredtranslatedText
     * 3、@ResourcetranslatedText，translatedText，translatedText
     *          translatedText@AutoWiredtranslatedText，translatedText
     */
    @Resource
//    @Autowired
//    @Qualifier("personService")
    private PersonService personService;

    public void save() {
        personService.save();
    }

//    @Autowired
//    public void test(@Qualifier("personDao") PersonDao personDao123) {
//        System.out.println("test");
//        personDao123.update();
//    }
}
