### Collectors
`Collectors` — это утилитарный класс в Java, который предоставляет различные реализации коллекционных операций, которые используются для обработки и преобразования данных, полученных из стримов. Он входит в пакет `java.util.stream` и часто используется вместе с методом `collect` из API Stream для преобразования элементов стрима в различные другие структуры данных, такие как списки, множества, карты и другие.

### Основные возможности `Collectors`

1. **Сбор элементов в список:**
   ```java
   List<String> list = stream.collect(Collectors.toList());
   ```

2. **Сбор элементов в множество:**
   ```java
   Set<String> set = stream.collect(Collectors.toSet());
   ```

3. **Сбор элементов в map'у:**
   ```java
   Map<Integer, String> map = stream.collect(Collectors.toMap(String::length, Function.identity()));
   ```

4. **Группировка элементов:**
   ```java
   Map<Integer, List<String>> groupedByLength = stream.collect(Collectors.groupingBy(String::length));
   ```

5. **Подсчет количества элементов:**
   ```java
   long count = stream.collect(Collectors.counting());
   ```

6. **Получение среднего значения:**
   ```java
   double average = stream.collect(Collectors.averagingInt(String::length));
   ```

7. **Объединение строк:**
   ```java
   String joined = stream.collect(Collectors.joining(", "));
   ```

### Примеры использования

#### Пример 1: Сбор в список

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
List<String> collectedNames = names.stream().collect(Collectors.toList());
System.out.println(collectedNames); // [Alice, Bob, Charlie]
```

#### Пример 2: Группировка

```java
List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
Map<Integer, List<String>> groupedByLength = names.stream()
    .collect(Collectors.groupingBy(String::length));

groupedByLength.forEach((length, list) -> {
    System.out.println("Length: " + length);
    list.forEach(name -> System.out.println("  " + name));
});
```

#### Пример 3: Подсчет количества элементов

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
long count = names.stream().collect(Collectors.counting());
System.out.println("Count: " + count); // Count: 3
```

#### Пример 4: Объединение строк

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
String joined = names.stream().collect(Collectors.joining(", "));
System.out.println(joined); // Alice, Bob, Charlie
```

### Основные методы `Collectors`

1. **`toList`**: Сбор в список.
2. **`toSet`**: Сбор в множество.
3. **`toMap`**: Сбор в карту.
4. **`groupingBy`**: Группировка элементов.
5. **`counting`**: Подсчет количества элементов.
6. **`averagingInt` / `averagingDouble` / `averagingLong`**: Вычисление среднего значения.
7. **`joining`**: Объединение элементов в строку.
8. **`partitioningBy`**: Разделение элементов на две группы по условию.

### flatMap
Метод `flatMap` используется в стримах для преобразования каждого элемента стрима в новый стрим и затем объединения всех этих стримов в один.

```java
public class Program {
    public static void main(String[] args) {
        List<List<String>> listOfLists = List.of(
                List.of("a", "b", "c"),
                List.of("d", "e", "f"),
                List.of("g", "h", "i"));

        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList); // [a, b, c, d, e, f, g, h, i]
    }
}
```

#### Пример 2
```java
List<List<List<List<Integer>>>> listOfLists = new ArrayList<>();

listOfLists.add(List.of(
        List.of(
                List.of(1, 2, 3),
                List.of(4, 5)),
        List.of(
                List.of(6, 7),
                List.of(8))));

listOfLists.add(List.of(
        List.of(
                List.of(9, 10),
                List.of(11)),
        List.of(
                List.of(12, 13, 14),
                List.of(15))));

List<Integer> flatList = listOfLists.stream()
        .flatMap(List::stream)
        .flatMap(List::stream)
        .flatMap(List::stream)
        .collect(Collectors.toList());

System.out.println(flatList); // [1, ..., 15]
```

1. Преобразовать список списков целых чисел в один список всех чисел.
2. Преобразовать список списков строк в один список всех строк.
3. Преобразовать список массивов строк в один список всех строк.
4. Преобразовать список списков объектов в один список всех объектов.
5. Преобразовать список строк, каждая из которых содержит пробелы, в один список всех слов.
6. Преобразовать список предложений в один список всех слов.
7. Преобразовать список пользователей, каждый из которых имеет список телефонов, в один список всех телефонов.
8. Преобразовать список студентов, каждый из которых имеет список оценок, в один список всех оценок.
```java
List<Student> students = List.of(
    new Student("Студент 1", List.of(3, 4, 3)),
    new Student("Студент 2", List.of(4, 3, 4)),
    new Student("Студент 3", List.of(5, 3, 3))
);

List<Integer> allGrades = students.stream()
    .flatMap(student -> student.getGrades().stream())
    .collect(Collectors.toList());
```
9. Преобразовать список сотрудников, каждый из которых имеет список проектов, в один список всех проектов.
10. Преобразовать список стран, каждая из которых имеет список городов, в один список всех городов.
11. Преобразовать список компаний, каждая из которых имеет список отделов, в один список всех отделов.
12. Преобразовать список семей, каждая из которых имеет список членов семьи, в один список всех членов семьи.
13. Преобразовать список книг, каждая из которых имеет список авторов, в один список всех авторов.
14. Преобразовать список школ, каждая из которых имеет список учителей, в один список всех учителей.
15. Преобразовать список университетов, каждый из которых имеет список факультетов, в один список всех факультетов.
16. Преобразовать список категорий, каждая из которых имеет список продуктов, в один список всех продуктов.
17. Преобразовать список клиентов, каждый из которых имеет список заказов, в один список всех заказов.
18. Преобразовать список домов, каждый из которых имеет список комнат, в один список всех комнат.
```java
List<House> houses = List.of(
    new House("Дом 1", List.of(new Room("Комната 11"), new Room("Комната 12"), new Room("Комната 13"))),
    new House("Дом 2", List.of(new Room("Комната 11"), new Room("Комната 12"))),
    new House("Дом 3", List.of(new Room("Комната 11"), new Room("Комната 12"), new Room("Комната 13")))
);

List<Room> allRooms = houses.stream()
    .flatMap(house -> house.getRooms().stream())
    .collect(Collectors.toList());

```
19. Преобразовать список магазинов, каждый из которых имеет список товаров, в один список всех товаров.
20. Преобразовать список библиотек, каждая из которых имеет список книг, в один список всех книг.

### groupingBy
В Java метод groupingBy является частью Collectors и используется для группировки элементов стрима на основе некоторого ключа. Он работает с методом collect из API Stream. Основной смысл groupingBy заключается в сборе элементов в карту, где ключом является результат функции, а значением - список элементов, соответствующих этому ключу.

### Расширенные возможности

Метод `groupingBy` имеет несколько перегруженных версий:

1. **Простая группировка:** `Collectors.groupingBy(Function<? super T, ? extends K> classifier)` - группирует элементы по ключу, определенному функцией классификатором.

2. **Группировка с дополнительным коллектором:** `Collectors.groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)` - группирует элементы по ключу и применяет дополнительный коллектор к значениям.

3. **Группировка с заданной картой:** `Collectors.groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)` - группирует элементы по ключу и помещает результаты в указанную реализацию карты.

```java
class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}

public class GroupingByExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            students.add(new Student("Студент " + i, random.nextInt(3, 6)));
        }

        Map<Integer, List<Student>> studentsByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        studentsByGrade.forEach((grade, studentList) -> {
            System.out.println("Оценка: " + grade);
            studentList.forEach(student -> System.out.println("  " + student));
        });
    }
}
```
```text
Оценка: 3
  Студент 2: 3
  Студент 3: 3
  Студент 6: 3
Оценка: 4
  Студент 1: 4
  Студент 4: 4
  Студент 5: 4
  Студент 8: 4
  Студент 9: 4
Оценка: 5
  Студент 7: 5
```

```java
Map<Integer, Long> studentsByGradeCount = students.stream()
    .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));

studentsByGradeCount.forEach((grade, count) -> {
    System.out.println("Grade: " + grade + ", Count: " + count);
});
```

```text
Grade: 3, Count: 4
Grade: 4, Count: 3
Grade: 5, Count: 2
```

`Parallel Stream` в Java позволяет обрабатывать элементы стрима параллельно, что может значительно улучшить производительность на многоядерных процессорах. Параллельные стримы разбивают задачу на подзадачи, которые выполняются в разных потоках, а затем объединяют результаты. Это может ускорить выполнение задач, особенно если они требуют значительных вычислительных ресурсов.

### Как создать Parallel Stream

Вы можете создать параллельный стрим из коллекции, вызвав метод `parallelStream`:

```java
List<String> list = Arrays.asList("a", "b", "c", "d");
list.parallelStream()
    .forEach(System.out::println);
```

Или преобразовать обычный стрим в параллельный, вызвав метод `parallel`:

```java
List<String> list = Arrays.asList("a", "b", "c", "d");
list.stream()
    .parallel()
    .forEach(System.out::println);
```

### Пример использования

Предположим, у нас есть список чисел, и мы хотим найти их квадраты параллельно:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> squares = numbers.parallelStream()
    .map(n -> n * n)
    .collect(Collectors.toList());

System.out.println(squares);
```

### Преимущества и недостатки

#### Преимущества:
1. **Повышенная производительность:** Параллельные стримы могут значительно ускорить выполнение задач за счет использования всех доступных ядер процессора.
2. **Упрощение многопоточного программирования:** Нет необходимости вручную управлять потоками, синхронизацией и делением задач.

#### Недостатки:
1. **Затраты на управление потоками:** Создание и управление потоками добавляет накладные расходы, что может замедлить выполнение для мелких задач.
2. **Порядок выполнения:** Параллельные стримы не гарантируют порядок выполнения операций. Для сохранения порядка используйте `forEachOrdered` вместо `forEach`.
3. **Потенциальные проблемы с синхронизацией:** При работе с изменяемыми данными нужно быть осторожным, чтобы избежать состояния гонки и других проблем, связанных с синхронизацией.

### Пример с сохранением порядка

Если порядок выполнения важен, используйте `forEachOrdered`:

```java
List<String> list = Arrays.asList("a", "b", "c", "d");
list.parallelStream()
    .forEachOrdered(System.out::println);
```

### Использование `reduce` с Parallel Stream

Пример использования `reduce` для параллельного суммирования:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

int sum = numbers.parallelStream()
    .reduce(0, Integer::sum);

System.out.println("Sum: " + sum);
```
