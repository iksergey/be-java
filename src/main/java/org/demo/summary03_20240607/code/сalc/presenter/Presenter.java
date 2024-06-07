package org.demo.summary03_20240607.code.сalc.presenter;

import org.demo.summary03_20240607.code.сalc.model.Model;
import org.demo.summary03_20240607.code.сalc.view.*;

public class Presenter {
    View view;
    Model model;

    public Presenter(Model m, View view) {
        model = m;
        this.view = view;
    }

    public void buttonClick() {
        int a = view.getValue("a: ");
        int b = view.getValue("b: ");
        model.setX(a);
        model.setY(b);
        int result = model.result();
        view.print(result, "Sum: ");
    }
}
