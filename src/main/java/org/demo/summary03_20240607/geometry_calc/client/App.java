package org.demo.summary03_20240607.geometry_calc.client;

import org.demo.summary03_20240607.geometry_calc.core.model.Model;
import org.demo.summary03_20240607.geometry_calc.core.presenter.Presenter;
import org.demo.summary03_20240607.geometry_calc.core.view.ConsoleView;
import org.demo.summary03_20240607.geometry_calc.core.view.View;
import org.demo.summary03_20240607.geometry_calc.math.area.CalculateArea;

public class App {
    Presenter p;
    View ui;
    Model model;

    public App() {
        ui = new ConsoleView();
        model = new Model(CalculateArea.getInstance(), "canvas.png");
        p = new Presenter(ui, model);
    }

    public void start() {
        StringBuilder sb = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - append shape\n")
                .append("2 - show shape\n")
                .append("3 - show all area\n")
                .append("0 - exit\n");

        while (true) {
            ui.set(sb.toString());
            switch (ui.get()) {
                case "1":
                    p.append();
                case "2":
                    p.show();
                    break;
                case "3":
                    p.showArea();
                    break;
                case "0":
                    return;
            }
        }
    }
}
