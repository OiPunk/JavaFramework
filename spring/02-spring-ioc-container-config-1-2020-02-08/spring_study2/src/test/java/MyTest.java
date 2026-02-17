import com.mashibing.bean.Address;
import com.mashibing.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        /*translatedTextbeantranslatedTextidtranslatedText*/
//        Person person = context.getBean("person", Person.class);
//        Person person2 = context.getBean("person",Person.class);
//        System.out.println(person == person2);

        /*translatedTextbeantranslatedText
        * translatedText：translatedText，translatedText，translatedText
        * */
//        Person bean = context.getBean(Person.class);
//        System.out.println(bean);

        /**
         * translatedText，translatedText，translatedText
         *
         *  Class clazz = Person.class;
         *  Object obj = clazz.newInstance();translatedText，translatedText
         *  Object obj = class.getDeclaredConstructor().newInstance()
         *
         */

//        Person person2 = context.getBean("person", Person.class);
//        System.out.println(person2);
//
//        Person person5 = context.getBean("person5", Person.class);
//        System.out.println(person5);

//        Person person6 = context.getBean("person6", Person.class);
//        System.out.println(person6);
//        Address address2 = context.getBean("address2", Address.class);
//        System.out.println(address2);

//        Person son = context.getBean("son", Person.class);
//        System.out.println(son);
//        Person parent = context.getBean("parent", Person.class);
//        System.out.println(parent);
    }
}
