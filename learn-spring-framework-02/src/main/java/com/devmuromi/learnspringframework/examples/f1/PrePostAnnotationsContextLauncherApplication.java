package com.devmuromi.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("모든 의존성이 준비되었습니다!");
    }
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }
    @PreDestroy
    public void cleanUp() {
        System.out.println("SomeClass의 cleanUp 메서드가 호출되었습니다.");

    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("SomeDependency에서 뭔가 로직 작동중...");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        try (
                var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)
        ) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
