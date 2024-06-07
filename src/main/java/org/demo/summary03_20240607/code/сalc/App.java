package org.demo.summary03_20240607.code.сalc;

import org.demo.summary03_20240607.code.сalc.model.SumModel;
import org.demo.summary03_20240607.code.сalc.presenter.Presenter;
import org.demo.summary03_20240607.code.сalc.view.ConsoleView;

public class App {
    public static void run() {
        Presenter p = new Presenter(new SumModel(), new ConsoleView());
        p.buttonClick();
        p.buttonClick();
        p.buttonClick();
        p.buttonClick();
    }
}
