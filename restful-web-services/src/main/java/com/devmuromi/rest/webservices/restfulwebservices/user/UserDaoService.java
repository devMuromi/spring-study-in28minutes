package com.devmuromi.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Muromi", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Lucy", LocalDate.now().minusYears(20)));
        users.add(new User(3, "Sasha", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }
}
