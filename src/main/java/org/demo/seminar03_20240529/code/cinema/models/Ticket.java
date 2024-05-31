package org.demo.seminar03_20240529.code.cinema.models;

import org.demo.seminar03_20240529.code.cinema.interfaces.*;

// Класс Ticket
public class Ticket {
    private User user;
    private Session session;
    private String seat;

    public Ticket(User user, Session session, String seat) {
        this.user = user;
        this.session = session;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Билет на " + user.getName() + " смотреть " + session.getFilm().getTitle() + " в " + session.getTime()
                + " место " + seat;
    }
}