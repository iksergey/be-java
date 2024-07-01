## Java Stream API

Java Stream API представляет собой мощный инструмент для работы с коллекциями данных, введенный в Java 8. Он предоставляет декларативный подход к обработке данных, позволяя выполнять операции над элементами коллекции с использованием функциональных стилей программирования.

Основные концепции Stream API:

1. **Поток данных (Stream)**: Это последовательность элементов, которую можно обрабатывать по одному элементу за раз. Поток не хранит элементы, а обрабатывает их по мере необходимости.

2. **Функциональные операции**: Stream API предоставляет множество операций для работы с данными:
   - Промежуточные операции (`intermediate operations`), такие как `filter`, `map`, `sorted`, которые позволяют фильтровать, преобразовывать или сортировать элементы.
   - Терминальные операции (`terminal operations`), например, `forEach`, `collect`, `reduce`, которые завершают обработку потока и вычисляют результат.

3. **Ленивые вычисления**: Многие операции Stream API являются ленивыми, то есть они выполняются только при необходимости и не требуют обработки всех элементов сразу.

Пример использования Stream API для фильтрации и суммирования списка чисел:

```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Примеры промежуточных операций
        int sum = numbers.stream()
                         .filter(n -> n % 2 == 0) // фильтрация четных чисел
                         .mapToInt(n -> n * 2)    // умножение каждого числа на 2
                         .sum();                  // суммирование

        System.out.println("Сумма удвоенных четных чисел: " + sum);
    }
}
```

## Начать с 

1. **filter**:
    `filter` используется для фильтрации элементов по заданному условию:

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   numbers.stream()
          .filter(n -> n % 2 == 0)
          .forEach(System.out::println);
   ```

2. **map**:
    `map` применяет функцию к каждому элементу итерируемого объекта:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   names.stream()
        .map(name -> name.toUpperCase())
        .forEach(System.out::println);
   ```
 


## Руководство по основным методам Java Stream API

### Java Stream API - Руководство по основным методам

### Создание потока

Чтобы начать работу с потоком данных, необходимо сначала преобразовать коллекцию в поток. Это можно сделать с помощью метода `stream()`:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Stream<String> stream = names.stream();
```

### Промежуточные операции

Промежуточные операции применяются к потоку данных и возвращают новый поток. Они выполняются по мере необходимости (ленивая загрузка) и могут быть комбинированы цепочкой.

#### Фильтрация (`filter`)

Фильтрует элементы потока согласно заданному условию:

```java
stream.filter(name -> name.startsWith("A"));
```

#### Преобразование (`map`)

Преобразует каждый элемент потока в другой объект:

```java
stream.map(name -> name.toUpperCase());
```
#### Проверка всех элементов(`allMatch`)

Проверяет, удовлетворяют ли все элементы потока определенному предикату

```java 
stream.allMatch(item -> item > 10)
```

#### Сортировка (`sorted`)

Сортирует элементы потока:

```java
stream.sorted();
```

#### Ограничение (`limit`)

Ограничивает количество элементов в потоке:

```java
stream.limit(10);
```

#### Пропуск (`skip`)

Пропускает указанное количество элементов в потоке:

```java
stream.skip(5);
```

### Терминальные операции

Терминальные операции завершают обработку потока и возвращают результат.

#### Сборка (`collect`)

Собирает элементы потока в коллекцию или другую структуру данных:

```java
List<String> collected = stream.collect(Collectors.toList());
```

#### Перебор (`forEach`)

Применяет заданное действие к каждому элементу потока:

```java
stream.forEach(System.out::println);
```

#### Свертка (`reduce`)

Сводит все элементы потока к одному значению:

```java
Optional<Integer> sum = stream.reduce((a, b) -> a + b);
```

#### Поиск (`findFirst`, `findAny`)

Находит первый или любой элемент в потоке:

```java
Optional<String> first = stream.findFirst();
Optional<String> any = stream.findAny();
```

## Некоторые примеры

Конечно! Вот примеры использования метода `reduce` из Java Stream API для выполнения различных операций:

### Пример 1: Вычисление суммы чисел

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Вычисляем сумму всех элементов в потоке
        Optional<Integer> sum = numbers.stream()
                                       .reduce((a, b) -> a + b);

        if (sum.isPresent()) {
            System.out.println("Сумма чисел: " + sum.get());
        } else {
            System.out.println("Поток пуст");
        }
    }
}
```

### Пример 2: Нахождение максимального значения

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Находим максимальное число в потоке
        Optional<Integer> max = numbers.stream()
                                       .reduce(Integer::max);

        if (max.isPresent()) {
            System.out.println("Максимальное число: " + max.get());
        } else {
            System.out.println("Поток пуст");
        }
    }
}
```

### Пример 3: Соединение строк через разделитель

```java
import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "Stream", "API");

        // Соединяем строки через пробел
        String result = strings.stream()
                               .reduce((a, b) -> a + " " + b)
                               .orElse("");

        System.out.println("Результат: " + result);
    }
}
```

### Пример 4: Проверка наличия хотя бы одного отрицательного числа

```java
import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, -4, 5);

        // Проверяем, есть ли хотя бы одно отрицательное число
        boolean hasNegative = numbers.stream()
                                     .anyMatch(n -> n < 0);

        if (hasNegative) {
            System.out.println("В потоке есть отрицательные числа");
        } else {
            System.out.println("В потоке нет отрицательных чисел");
        }
    }
}
```

## Функциональные интерфейсы Java

1. **Supplier<T>** - поставщик (supplier) значения типа T без входных параметров:
   
   ```java
   Supplier<String> supplier = () -> "Привет, мир!";
   System.out.println(supplier.get()); // Выведет: Привет, мир!
   ```

2. **Consumer<T>** - потребитель (consumer) значения типа T с одним входным параметром:
   
   ```java
   Consumer<String> consumer = (str) -> System.out.println("Получено сообщение: " + str);
   consumer.accept("Привет, мир!");
   // Выведет: Получено сообщение: Привет, мир!
   ```

3. **Predicate<T>** - предикат (predicate) проверяет условие на объекте типа T и возвращает boolean:
   
   ```java
   Predicate<Integer> predicate = (num) -> num > 10;
   System.out.println(predicate.test(15)); // Выведет: true
   ```

4. **Function<T, R>** - функция (function) принимает объект типа T и возвращает объект типа R:
   
   ```java
   Function<Integer, String> converter = (num) -> String.valueOf(num * 2);
   System.out.println(converter.apply(5)); // Выведет: 10
   ```

5. **UnaryOperator<T>** - унарный оператор (unary operator) принимает и возвращает объект типа T:
   
   ```java
   UnaryOperator<Integer> square = (num) -> num * num;
   System.out.println(square.apply(4)); // Выведет: 16
   ```

6. **BinaryOperator<T>** - бинарный оператор (binary operator) принимает два объекта типа T и возвращает объект типа T:
   
   ```java
   BinaryOperator<Integer> sum = (a, b) -> a + b;
   System.out.println(sum.apply(3, 4)); // Выведет: 7
   ```

## Задачи для разгона

Конечно, вот список задач на использование `map` и `filter` в Python, начиная от простых до более сложных:

### Часть 1
1. Преобразовать список чисел в список строк.
2. Отфильтровать список чисел так, чтобы остались только четные числа.
3. Преобразовать список строк в список их длин.
4. Отфильтровать список строк так, чтобы остались только строки, начинающиеся с определенной буквы.
5. Преобразовать список дат в список строк в формате "год-месяц".

### Часть 2
1. Преобразовать список слов в список их анаграмм.
2. Отфильтровать список строк так, чтобы остались только строки, содержащие цифры.
3. Преобразовать список кортежей (имя, возраст) в список строк с описанием (имя is в возраст год(а/лет)).
4. Отфильтровать список чисел так, чтобы остались только числа, делящиеся на все свои цифры без остатка.

### Часть 3
1. Преобразовать список словарей в список строк JSON, содержащих определенные ключи.
2. Отфильтровать список строк так, чтобы остались только строки, которые являются палиндромами.
3. Преобразовать список предложений в список кортежей (число слов, предложение).
4. Отфильтровать список сложных структур данных (например, деревьев) так, чтобы остались только те, у которых определенное свойство имеет определенное значение.

## Ещё задачи. Всё вместе

1. Найти среднее значение списка чисел.
2. Отфильтровать список строк по заданному условию.
3. Посчитать количество элементов в списке.

```java
List<String> strings = List.of("apple", "banana", "cherry", "date", "elderberry");
long count = strings.stream().count();
System.out.println("Количество элементов в списке: " + count);
```
4. Преобразовать список строк в верхний регистр.
5. Найти максимальный элемент в числовом списке.
6. Убрать дубликаты из списка.
7. Выбрать первые N элементов списка.
8. Проверить, все ли элементы списка удовлетворяют определенному условию.
9. Объединить несколько списков в один.
10. Отсортировать список строк.
11. Преобразовать список строк в мапу, где ключом будет строка, а значением - длина строки.

```java
List<String> strings = List.of("apple", "banana", "cherry", "date", "elderberry");

Map<String, Integer> stringLengthMap = strings.stream()
        .collect(Collectors.toMap(
                e -> e,
                e -> e.length()));

stringLengthMap.forEach((key, value) -> System.out.println(key + ": " + value));

```

12. Найти минимальный элемент в числовом списке.
13. Посчитать сумму всех элементов в числовом списке.
14. Разделить список на части заданного размера.
15. Проверить, есть ли хотя бы один элемент, удовлетворяющий заданному условию.
16. Пропустить первые N элементов списка.
17. Посчитать сумму длин строк в списке.
18. Проверить, есть ли дубликаты в списке.
19. Преобразовать список чисел в список квадратов этих чисел.
20. Найти самую длинную строку в списке.
21. Объединить элементы списка в одну строку с разделителем.
22. Проверить, все ли строки в списке начинаются с определенной буквы.

```java

List<String> strings = List.of("apple", "banana", "cherry", "date", "elderberry");

char startingChar = 'a';

boolean allStartWithA = strings.stream()
        .allMatch(str -> str.toLowerCase().startsWith(String.valueOf(startingChar)));

if (allStartWithA) {
    System.out.println("Все строки начинаются с буквы '" + startingChar + "'");
} else {
    System.out.println("Не все строки начинаются с буквы '" + startingChar + "'");
}

```
23. Удалить элементы списка, не удовлетворяющие заданному условию.
24. Посчитать количество элементов с определенным значением.
25. Объединить значения всех элементов списка, начинающихся с определенной буквы.
26. Проверить, все ли строки в списке состоят из цифр.
27. Оставить только уникальные элементы из нескольких списков.
28. Преобразовать список объектов в список их идентификаторов.
29. Посчитать количество строк с определенной длиной.
30. Проверить, все ли элементы списка являются положительными числами.
