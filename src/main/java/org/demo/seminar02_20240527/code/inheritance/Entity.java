package org.demo.seminar02_20240527.code.inheritance;

// Foo -> Entity
public class Entity extends Person {
    public Entity() {
        // super();
        super("nil ", 123);
    }

    public Entity(String s, int a) {
        super(s, a);
    }

    public Entity(int a1, String s1) {
        super(s1, a1);
    }

    public Entity(String s) {
        super(s, 0);
    }

    public Entity(int a) {
        super("nil", a);
    }

    // public void setNewAge(int age) {
    // if (age >= 0) {
    // super.setAge(age);
    // }
    // }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
}
