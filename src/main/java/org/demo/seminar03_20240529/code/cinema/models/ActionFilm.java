package org.demo.seminar03_20240529.code.cinema.models;

import org.demo.seminar03_20240529.code.cinema.enums.*;
import org.demo.seminar03_20240529.code.cinema.interfaces.*;

// Классы для разных жанров фильмов
public class ActionFilm implements Film {
    private String title;

    public ActionFilm(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public FilmGenre getGenre() {
        return FilmGenre.ACTION;
    }
}