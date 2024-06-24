package org.demo.summary05_20240621.code.client;

import java.util.Scanner;

import org.demo.summary05_20240621.code.core.mvp.View;
import org.demo.summary05_20240621.code.seed.Data;
import org.demo.summary05_20240621.code.Environment;
import org.demo.summary05_20240621.code.core.mvp.Presenter;
import org.demo.summary05_20240621.code.ui.ConsoleView;

// Класс app
public class App {
    public static void ButtonClick() {
        Data.seed(Environment.path);

        System.out.print("\033[H\033[J"); // https://ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Environment.path);
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println(" 1 - prev  2 - next");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;

                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
}
