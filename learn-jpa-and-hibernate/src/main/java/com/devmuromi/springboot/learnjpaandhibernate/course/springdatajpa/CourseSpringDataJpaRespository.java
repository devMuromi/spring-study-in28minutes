package com.devmuromi.springboot.learnjpaandhibernate.course.springdatajpa;

import com.devmuromi.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRespository extends JpaRepository<Course, Long>{
}
