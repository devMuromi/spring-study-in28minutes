package com.devmuromi.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}

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
        var person = new Person("Rikka", 20, new Address("Pacific Ocean", "Virgo Cluster"));
        return person;
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Milky way", "Virgo Cluster");
    }

    @Bean
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Milky way3", "Virgo Super Cluster");
    }
}
