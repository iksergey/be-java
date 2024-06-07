package org.demo.summary03_20240607.code.сalc.model;

public abstract class CalcModel implements Model {
    protected int x, y;

    @Override
    public void setX(int value) {
        this.x = value;
    }

    @Override
    public void setY(int value) {
        this.y = value;
    }
}
