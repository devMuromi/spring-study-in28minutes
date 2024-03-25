package com.devmuromi.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

    var str = context.getBean("name");
    System.out.println(str);
    System.out.println(context.getBean("age"));
    System.out.println(context.getBean("person"));
    System.out.println(context.getBean("address"));
    }
}
