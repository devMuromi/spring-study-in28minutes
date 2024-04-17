package com.devmuromi.springboot.learnjpaandhibernate.course;

import com.devmuromi.springboot.learnjpaandhibernate.course.Course;
import com.devmuromi.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1L, "Learn Spring yo", "Muromi"));
        repository.insert(new Course(2L, "Learn Spring yo2", "Muromi"));
        repository.insert(new Course(3L, "Learn Spring yo3", "Muromi"));
        repository.deleteById(2);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));
    }


}
