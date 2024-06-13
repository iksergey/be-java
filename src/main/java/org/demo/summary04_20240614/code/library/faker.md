### Библиотека Java Faker

### Установка и использование: 

Для использования Lombok в проекте необходимо добавить зависимость в `pom.xml` (для Maven)

```xml
<!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```

Java Faker - это библиотека для генерации случайных данных, которая может быть полезна при тестировании, заполнении баз данных и создании фиктивных данных для разработки приложений. Вот основные аспекты использования библиотеки Java Faker:

#### Основные методы генерации данных:

1. **Имена и фамилии:**
   ```java
   String name = faker.name().fullName(); // Полное имя
   String firstName = faker.name().firstName(); // Имя
   String lastName = faker.name().lastName(); // Фамилия
   ```

2. **Адреса:**
   ```java
   String address = faker.address().fullAddress(); // Полный адрес
   String city = faker.address().city(); // Город
   String streetAddress = faker.address().streetAddress(); // Улица и номер дома
   ```

3. **Телефонные номера:**
   ```java
   String phoneNumber = faker.phoneNumber().phoneNumber(); // Телефонный номер
   ```

4. **Дата и время:**
   ```java
   Date date = faker.date().birthday(); // Дата рождения
   Date date = faker.date().birthday(20, 70); // Дата рождения от 20 до 70 лет
   ```

5. **Lorem Ipsum текст:**
   ```java
   String lorem = faker.lorem().paragraph(); // Параграф текста Lorem Ipsum
   ```

#### Изменение языка (локали):

Для изменения языка используется конструктор `Faker` с указанием нужной локали. Возможные локали включают, например:
   ```java
   // Установка английского (США)
   Faker faker = new Faker(Locale.of("en"));
   
   // Установка французского (Франция)
   Faker faker = new Faker(Locale.of("fr"));
   ```

#### Фиксирование данных:

Для воспроизводимости данных можно использовать фиксированное значение seed:
   ```java
   long seed = 12345L; // Фиксированное значение seed
   Random random = new Random(seed);
   Faker faker = new Faker(random);

   // или
   Faker faker = new Faker(Locale.of("fr"), new Random(seed));
   ```

#### Пример использования:

```java
import com.github.javafaker.Faker;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Установка фиксированного значения seed для воспроизводимости
        long seed = 12345L; 
        Random random = new Random(seed);
        Faker faker = new Faker(random);

        // Генерация данных с использованием faker
        String name = faker.name().fullName();
        String address = faker.address().fullAddress();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        Date birthDate = faker.date().birthday();

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Birth Date: " + birthDate);
    }
}
```
