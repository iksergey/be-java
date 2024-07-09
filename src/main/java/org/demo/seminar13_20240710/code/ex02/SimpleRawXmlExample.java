import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class SimpleRawXmlExample {
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person("Иван", 30);

        String xml = serializeToXml(person);
        System.out.println("Сериализованный XML:\n" + xml);

        Person deserializedPerson = deserializeFromXml(xml);
        System.out.println("\nДесериализованный объект:");
        System.out.println("Имя: " + deserializedPerson.name);
        System.out.println("Возраст: " + deserializedPerson.age);
    }

    private static String serializeToXml(Person person) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("person");
        doc.appendChild(rootElement);

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(person.name));
        rootElement.appendChild(nameElement);

        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(String.valueOf(person.age)));
        rootElement.appendChild(ageElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.getBuffer().toString();
    }

    private static Person deserializeFromXml(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));

        NodeList nameList = doc.getElementsByTagName("name");
        NodeList ageList = doc.getElementsByTagName("age");

        String name = nameList.item(0).getTextContent();
        int age = Integer.parseInt(ageList.item(0).getTextContent());

        return new Person(name, age);
    }
}
