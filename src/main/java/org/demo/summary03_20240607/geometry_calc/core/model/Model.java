package org.demo.summary03_20240607.geometry_calc.core.model;

import org.demo.summary03_20240607.geometry_calc.math.area.Calculate;
import org.demo.summary03_20240607.geometry_calc.math.shapes.Canvas;
import org.demo.summary03_20240607.geometry_calc.math.shapes.Shape;

public class Model {
    Shape panel;
    Calculate calc;

    public Model(Calculate c, String canvasName) {
        panel = new Canvas(canvasName);
        calc = c;
    }

    public void append(Shape shape) {
        panel.shapes.add(shape);
    }

    public double area() {
        return calc.visit(panel);
    }

    public String show() {
        return panel.toString();
    }
}
