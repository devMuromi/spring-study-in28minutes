package com.devmuromi.springboot.learnjpaandhibernate.course.jdbc;

import com.devmuromi.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                INSERT INTO course(id, name, author)
                VALUES(?, ?, ?);
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update("DELETE FROM course WHERE id = ?", id);
    }

    public Course findById(long id) {
        // ResultSet -> Bean -> Row Mapper ->
        return springJdbcTemplate.queryForObject("SELECT * FROM course WHERE id = ?", new BeanPropertyRowMapper<>(Course.class), id);
    }
}
