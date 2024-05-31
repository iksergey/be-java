package org.demo.seminar02_20240527.code.inheritance;

public class Program {
    public static void main(String[] args) {
        Person person = new Person("Имя 1", 20);
        Teacher teacher = new Teacher("Имя 2", 33, "Математика");
        Student student = new Student("Имя 3", 20, "Школа 123");
        Worker worker = new Worker("Имя 4", 20, 1110);

        Entity entity1 = new Entity("nil", -1);
        Entity entity2 = new Entity(-1, "nil");
        Entity entity3 = new Entity("nil");
        Entity entity4 = new Entity(-1);
        Entity entity5 = new Entity();

        String s = entity1.getFistName();
        student.setFistName(s);

        System.out.println("end");
    }
}
