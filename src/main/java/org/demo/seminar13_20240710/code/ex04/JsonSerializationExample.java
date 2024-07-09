package org.demo.seminar13_20240710.code.ex04;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonSerializationExample {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person("Иван", 30);

        try {
            // Сериализация в JSON и сохранение в файл
            mapper.writeValue(new File("person.json"), person);
            System.out.println("Объект сериализован и сохранен в файл person.json");

            // Чтение из файла и десериализация
            Person deserializedPerson = mapper.readValue(new File("person.json"), Person.class);
            System.out.println("Объект десериализован из файла: " + deserializedPerson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    public String name;
    public int age;

    // Обязателен для Jackson
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
