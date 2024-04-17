package com.devmuromi.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                INSERT INTO course(id, name, author)
                VALUES(1, 'Learn Spring', 'Muromi');
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
