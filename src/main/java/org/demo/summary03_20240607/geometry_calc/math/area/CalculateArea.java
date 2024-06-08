package org.demo.summary03_20240607.geometry_calc.math.area;

import org.demo.summary03_20240607.geometry_calc.math.shapes.Shape;

public class CalculateArea implements Calculate {

    private static CalculateArea instance;

    public static CalculateArea getInstance() {
        if (instance == null)
            instance = new CalculateArea();
        return instance;
    }

    private CalculateArea() {
    }

    private class RefInt {
        public double value;

        public RefInt(double ident) {
            value = ident;
        }
    }

    private void calculate(Shape shape, RefInt ref) {
        ref.value += shape.getArea();

        for (Shape item : shape.shapes) {
            calculate(item, ref);
        }

    }

    public double visit(Shape shape) {
        RefInt area = new RefInt(0);

        calculate(shape, area);

        return area.value;
    }
}
