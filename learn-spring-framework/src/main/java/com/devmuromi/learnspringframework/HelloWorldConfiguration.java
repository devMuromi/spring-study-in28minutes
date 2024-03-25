package com.devmuromi.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {}

record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Muromi";
    }

    @Bean
    public int age() {
        return 600;
    }

    @Bean
    public Person person() {
        var person = new Person("Rikka", 20);
        return person;
    }

    @Bean
    public Address address() {
        return new Address("Milky way", "Virgo Cluster");
    }
}
