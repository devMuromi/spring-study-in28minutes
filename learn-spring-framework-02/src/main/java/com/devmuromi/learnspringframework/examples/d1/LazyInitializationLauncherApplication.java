package com.devmuromi.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        // Logic
        System.out.println("ClassB init 중");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try (
                var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)
        ) {
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("Initialization of context is completed");

            context.getBean(ClassB.class).doSomething();
        }
    }
}
