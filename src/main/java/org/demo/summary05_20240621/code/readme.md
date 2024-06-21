### Техническое задание

#### Описание проекта
Создание консольного приложения на языке Java для управления списком контактов. Контакты будут храниться в текстовом файле.

#### Функциональные требования
1. **Создание контакта**
   - Ввод данных контакта: имя, фамилия, телефон, e-mail.
   - Сохранение данных контакта в текстовый файл.
   - Общий, объём бд - не менее 1000 записей

2. **Чтение списка контактов**
   - Чтение всех контактов из текстового файла.
   - Отображение списка контактов в консоли.

3. **Редактирование контакта**
   - Возможность редактирования существующего контакта.
   - Обновление данных контакта в текстовом файле.

4. **Удаление контакта**
   - Удаление контакта из текстового файла.

#### Нефункциональные требования
1. Приложение должно быть написано на языке Java.
2. Данные контактов должны храниться в текстовом файле.
3. Приложение должно использовать OOP (Объектно-Ориентированное Программирование) принципы.
4. Приложение должно быть структурировано и разделено на логические модули.

#### Архитектура приложения
1. **Модель (Model)**
   - Класс `Contact` для хранения информации о контакте (имя, фамилия, телефон, e-mail).

2. **Работа с консолью (View)**
   - Класс `ConsoleView` для взаимодействия с пользователем:
     - Ввод данных контакта.
     - Отображение списка контактов.
     - Обновление и удаление контактов.

3. **Работа с файлом (Repository)**
   - Класс `FileRepository` для работы с текстовым файлом:
     - Чтение данных из файла.
     - Запись данных в файл.
     - Обновление и удаление данных в файле.

4. **Сервис (Service)**
   - Класс `ContactService` для обработки бизнес-логики:
     - Добавление, редактирование, удаление контактов.
     - Взаимодействие с репозиторием.

5. **Интерфейсы (Interfaces)**
   - Интерфейс `IRepository` для абстракции взаимодействия с хранилищем данных.
   - Интерфейс `IView` для абстракции взаимодействия с пользователем.

6. **Внедрение зависимостей (Dependency Injection)**
   - Использование внедрения зависимостей для взаимодействия между компонентами.


#### Структура проекта
1. **Model**
   - `Contact.java`

2. **View**
   - `ConsoleView.java`

3. **Repository**
   - `FileRepository.java`
   - `IRepository.java`

4. **Service**
   - `ContactService.java`

5. **Main**
   - `Main.java`

#### Примерные сигнатуры классов и методов

1. **Contact.java**
   ```java
   public class Contact {
       private String firstName;
       private String lastName;
       private String phone;
       private String email;
       
       // Конструкторы, геттеры и сеттеры
   }
   ```

2. **IRepository.java**
   ```java
   public interface IRepository {
       void addContact(Contact contact);
       List<Contact> getAllContacts();
       void updateContact(Contact contact);
       void deleteContact(String email);
   }
   ```

3. **FileRepository.java**
   ```java
   public class FileRepository implements IRepository {
       private String filePath;
       
       // Реализация методов интерфейса IRepository
   }
   ```

4. **IView.java**
   ```java
   public interface IView {
       void displayContacts(List<Contact> contacts);
       Contact getContactDetails();
       String getContactEmail();
   }
   ```

5. **ConsoleView.java**
   ```java
   public class ConsoleView implements IView {
       // Реализация методов интерфейса IView
   }
   ```

6. **ContactService.java**
   ```java
   public class ContactService {
       private IRepository repository;
       
       // Конструктор и методы для обработки логики контактов
   }
   ```

7. **Main.java**
   ```java
   public class Main {
       public static void main(String[] args) {
           // Инициализация и запуск приложения
       }
   }
   ```
