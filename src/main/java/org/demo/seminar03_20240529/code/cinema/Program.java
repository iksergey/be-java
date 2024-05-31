package org.demo.seminar03_20240529.code.cinema;

import org.demo.seminar03_20240529.code.cinema.interfaces.*;
import org.demo.seminar03_20240529.code.cinema.models.*;

// Пример использования
public class Program {
    public static void main(String[] args) {
        Film actionFilm = new ActionFilm("ActionFilm 1");
        Film comedyFilm = new ComedyFilm("ActionFilm 2");

        // User admin = new AdminUser("Админ");
        User viewer = new ViewerUser("Юзер");

        Session session1 = new Session(actionFilm, "8-45", 50);
        Session session2 = new Session(comedyFilm, "20-45", 30);

        Ticket ticket1 = new Ticket(viewer, session1, "234");
        Ticket ticket2 = new Ticket(viewer, session2, "123");

        System.out.println(ticket1);
        System.out.println(ticket2);

        session1.bookTicket();
        System.out.println("Доступные билеты на сеанс 1: " + session1.getAvailableTickets());
    }
}
