package org.demo.seminar03_20240529.code.cinema.interfaces;

import org.demo.seminar03_20240529.code.cinema.enums.FilmGenre;

// Интерфейс Film
public interface Film {
    String getTitle();

    FilmGenre getGenre();
}