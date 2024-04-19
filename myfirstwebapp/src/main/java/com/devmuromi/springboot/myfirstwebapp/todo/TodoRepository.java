package com.devmuromi.springboot.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username); // Todo bean에 username property가 있으니 JPA가 자동으로 검색한다
}
