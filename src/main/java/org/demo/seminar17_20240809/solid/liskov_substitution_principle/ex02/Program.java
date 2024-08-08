package org.demo.seminar17_20240809.solid.liskov_substitution_principle.ex02;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Bird bird = new Bird();
        CalculatingDistance dist = new CalculatingDistance(10);
        dist.calculate(bird);

        Kiwi kiwi = new Kiwi();
        dist = new CalculatingDistance(10);
        dist.calculate(kiwi);
    }
}

class Bird {
    public Coordinates position;
    protected int speed, spacing;
    protected String m;

    public Bird() {
        position = new Coordinates(10, 10);
        this.m = "B";
    }

    protected void mark(int x, int y) {
        System.out.printf("(%d, %d) %s%n", x, y, m);
    }

    private void fly() {
        mark(position.latitude, position.longitude);

        speed = 1;
        switch (new Random().nextInt(2)) {
            case 0:
                position.latitude += speed;
                break;
            default:
                position.longitude += speed;
                break;
        }
        spacing++;
        mark(position.latitude, position.longitude);
    }

    public void move() {
        this.fly();
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpacing() {
        return spacing;
    }
}

class CalculatingDistance {
    int time;

    public CalculatingDistance(int time) {
        this.time = time;
    }

    public void calculate(Bird bird) {
        for (int i = 0; i < time; i++) {
            bird.move();
        }

        System.out.printf("%n%n%nРасстояние:  %d %s%n", bird.getSpacing(), bird.position);
    }
}

class Coordinates {
    public int latitude;
    public int longitude;

    public Coordinates(int x, int y) {
        latitude = x;
        longitude = y;
    }

    @Override
    public String toString() {
        return String.format("Широта: %d  Долгота: %d", latitude, longitude);
    }
}

class Kiwi extends Bird {
    public Kiwi() {
        position = new Coordinates(30, 10);
        this.m = "K";
    }

    private void run() {
        mark(position.latitude, position.longitude);
        speed = 1;
        switch (new Random().nextInt(4)) {
            case 0:
                position.latitude += speed;
                break;
            case 1:
                position.latitude -= speed;
                break;
            case 2:
                position.longitude += speed;
                break;
            default:
                position.longitude -= speed;
                break;
        }
        spacing++;
        mark(position.latitude, position.longitude);
    }

    @Override
    public void move() {
        this.run();
    }
}
