package com.mashibing.controller;

import com.mashibing.entity.Person;
import com.mashibing.filter.MyHttpSessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("msg","hello,Springboot");
        return "hello";
    }

//    @RequestMapping("online")
//    public String online(){
//        return "translatedText："+MyHttpSessionListener.online +"translatedText";
//    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(ModelMap map,HttpSession session){
        session.setAttribute("name","zhangsan");
        map.put("thText","th:texttranslatedText <b>translatedText</b>");
        map.put("thUText","th:utext translatedText <b>translatedText</b>");
        map.put("thValue","thValue translatedTextvaluetranslatedText");
        map.put("thEach","Arrays.asList(\"th:each\", \"translatedText\")");
        map.put("thIf","msg is not null");
        map.put("thObject",new Person("zhangsan",12,"translatedText"));
        return "thymeleaf";
    }
}
