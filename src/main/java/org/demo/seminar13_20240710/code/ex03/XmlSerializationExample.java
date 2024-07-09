package org.demo.seminar13_20240710.code.ex03;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.Data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonRootName;

public class XmlSerializationExample {

    public static void main(String[] args) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        String path = "person.xml";
        File file = new File(path);
        // Сериализация
        Person obj = new Person();
        obj.setName("Иван");
        obj.setAge(30);

        String xml = xmlMapper.writeValueAsString(obj);
        System.out.println("Сериализованный XML:");
        System.out.println(xml);
        xmlMapper.writeValue(file, obj); // в файл

        // Десериализация

        Person deserializedPerson = xmlMapper.readValue(xml, Person.class);
        System.out.println("\nДесериализованный объект:");
        System.out.println("Имя: " + deserializedPerson.getName());
        System.out.println("Возраст: " + deserializedPerson.getAge());
        Person readPerson = xmlMapper.readValue(file, Person.class);
        System.out.println(readPerson);
    }
}

@Data
// @JsonRootName("person")
class Person {
    private String name;
    private int age;
}
