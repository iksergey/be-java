package org.demo.seminar10_20240626.code.ex04.v4;

public abstract class Content {
    public String name;

    public Content(String name) {
        this.name = name;
    }

    public Content() {
        this("-");
    }

    @Override
    public String toString() {
        return name;
    }
}
