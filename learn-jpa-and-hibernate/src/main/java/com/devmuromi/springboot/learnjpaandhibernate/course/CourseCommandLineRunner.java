package com.devmuromi.springboot.learnjpaandhibernate.course;

import com.devmuromi.springboot.learnjpaandhibernate.course.Course;
import com.devmuromi.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.devmuromi.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRespository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1L, "Learn Spring yo", "Muromi"));
        repository.save(new Course(2L, "Learn Spring yo2", "Muromi"));
        repository.save(new Course(3L, "Learn Spring yo3", "Muromi"));
        repository.deleteById(2L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Muromi"));

        System.out.println(repository.findByName("Learn Spring yo2"));
        System.out.println(repository.findByName("Learn Spring yo3"));
    }


}
