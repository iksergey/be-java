package org.demo.seminar03_20240529.code.cinema.models;

import org.demo.seminar03_20240529.code.cinema.enums.*;
import org.demo.seminar03_20240529.code.cinema.interfaces.*;

public class ComedyFilm implements Film {
    private String title;

    public ComedyFilm(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public FilmGenre getGenre() {
        return FilmGenre.COMEDY;
    }
}