package org.demo.seminar03_20240529.code.cinema.models;

import org.demo.seminar03_20240529.code.cinema.enums.*;
import org.demo.seminar03_20240529.code.cinema.interfaces.*;

// Классы для разных типов пользователей
public class AdminUser implements User {
    private String name;

    public AdminUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UserRole getRole() {
        return UserRole.ADMIN;
    }
}