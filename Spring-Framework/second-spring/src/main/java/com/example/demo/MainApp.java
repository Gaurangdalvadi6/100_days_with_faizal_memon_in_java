package com.example.demo;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        GreetingService greetingService = (GreetingService) context.getBean("myBean");
        GreetingService greetingService = context.getBean(GreetingService.class);
        greetingService.sayHello();

//        UserService userServiceEmail = (UserService) context.getBean("UserServiceEmail");
        UserService userServiceEmail = context.getBean(UserService.class);
        userServiceEmail.notifyUser("Hy How r u?");

//        UserService userServiceSms = (UserService) context.getBean("UserServiceSms");
//        userServiceSms.notifyUser("Spring");
    }
}
