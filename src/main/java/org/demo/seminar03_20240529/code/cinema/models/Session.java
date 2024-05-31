package org.demo.seminar03_20240529.code.cinema.models;

import org.demo.seminar03_20240529.code.cinema.interfaces.*;

// Класс Session
public class Session {
    private Film film;
    private String time;
    private int availableTickets;

    public Session(Film film, String time, int availableTickets) {
        this.film = film;
        this.time = time;
        this.availableTickets = availableTickets;
    }

    public Film getFilm() {
        return film;
    }

    public String getTime() {
        return time;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void bookTicket() {
        if (availableTickets > 0) {
            availableTickets--;
        } else {
            System.out.println("Билеты не продаются");
        }
    }
}