package org.demo.summary03_20240607.geometry_calc.math.shapes;

public class Circle extends Shape {

    public static Circle create(double radius, String name) {
        if (radius < 0)
            return null;

        var instance = new Circle();
        instance.name = name;
        instance.radius = radius;
        return instance;
    }

    public double radius;

    private Circle() {
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("Name: %s radius: %s", name, radius);
    }

}
