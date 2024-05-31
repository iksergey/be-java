package org.demo.seminar03_20240529.code.cinema.models;

import org.demo.seminar03_20240529.code.cinema.enums.*;
import org.demo.seminar03_20240529.code.cinema.interfaces.*;

public class ViewerUser implements User {
    private String name;

    public ViewerUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UserRole getRole() {
        return UserRole.GUEST;
    }
}