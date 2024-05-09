package com.devmuromi.learnspringsecurity.resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final List<Todo> TODOS_LIST = List.of(
            new Todo("muromi", "Learn Spring Boot"),
            new Todo("muromi", "Learn Spring Security"),
            new Todo("muromi", "Learn to Dance")
    );

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }


    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('ADMIN') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'muromi'")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for user {}", todo, username);
        return TODOS_LIST.get(0);
    }
}

record Todo (String username, String description) {}