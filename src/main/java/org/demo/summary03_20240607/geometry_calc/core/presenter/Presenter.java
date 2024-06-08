package org.demo.summary03_20240607.geometry_calc.core.presenter;

import org.demo.summary03_20240607.geometry_calc.core.model.Model;
import org.demo.summary03_20240607.geometry_calc.core.view.View;
import org.demo.summary03_20240607.geometry_calc.math.shapes.Circle;
import org.demo.summary03_20240607.geometry_calc.math.shapes.Rectangle;
import org.demo.summary03_20240607.geometry_calc.math.shapes.Shape;
import org.demo.summary03_20240607.geometry_calc.core.infrastructure.Generator;

public class Presenter {
    Model model;
    View view;

    public Presenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    public void append() {
        view.set("1 - Circle, 2 - Rectangle");
        String response = view.get();
        Shape figure;

        switch (response) {
            case "1":
                figure = Circle.create(Generator.number(), "Circle_" + Generator.number());
                break;
            default:
                figure = Rectangle.create(
                        Generator.number(),
                        Generator.number(),
                        "Rectangle_" + Generator.number());
                break;
        }

        model.append(figure);
        view.set("ok");

    }

    public void show() {
        System.out.print("\033[H\033[2J");
        view.set(model.show());
    }

    public void showArea() {
        view.set(String.format("all Area %s", model.area()));
    }
}
