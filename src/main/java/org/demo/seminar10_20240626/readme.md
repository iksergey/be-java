В Java обобщения (generics) позволяют писать классы, интерфейсы и методы, которые работают с различными типами данных, обеспечивая безопасность типов и повторное использование кода. 

Обобщения помогают избежать использования явных приведений типов и классов, работающих с типами `Object`, тем самым уменьшая количество ошибок времени выполнения.

### Основные концепции обобщений в Java:

#### 1. Обобщенные классы и интерфейсы

Обобщенный класс или интерфейс объявляется с использованием одного или нескольких параметров типа. Например:

```java
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
```

Здесь `T` - параметр типа. Конкретный тип будет подставлен вместо `T` при создании экземпляра класса `Box`.

```java
Box<Integer> integerBox = new Box<>();
integerBox.setItem(123);
Integer value = integerBox.getItem();
```

#### 2. Обобщенные методы

Обобщенные методы могут быть объявлены внутри обобщенных классов или в обычных классах. Пример обобщенного метода:

```java
public class Utility {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
```

Вызов обобщенного метода:

```java
Integer[] intArray = {1, 2, 3, 4};
Utility.printArray(intArray);
```

#### 3. Ограниченные параметры типа

Можно ограничить параметры типа определенным классом или интерфейсом с помощью ключевого слова `extends`:

```java
public class NumberBox<T extends Number> {
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
```

Теперь `NumberBox` может принимать только те типы, которые являются подклассами `Number`.

#### 4. Множественные ограничения

Параметры типа могут иметь несколько ограничений, используя знак `&`:

```java
public <T extends Number & Comparable<T>> void compareNumbers(T num1, T num2) {
    int result = num1.compareTo(num2);
    System.out.println(result);
}
```

#### 5. Обобщенные типы с подстановочными знаками

Обобщенные типы могут использовать подстановочные знаки (`wildcards`) для обозначения неизвестных типов:

- `<?>` - подстановочный знак без ограничений.
- `<? extends T>` - подстановочный знак с верхней границей.
- `<? super T>` - подстановочный знак с нижней границей.

Пример использования подстановочных знаков:

```java
import java.util.ArrayList;
import java.util.List;

class Animal {
    @Override
    public String toString() {
        return "I am an Animal";
    }
}

class Bird extends Animal {
    @Override
    public String toString() {
        return "I am a Bird";
    }
}

class Kiwi extends Bird {
    @Override
    public String toString() {
        return "I am a Kiwi";
    }
}

public class GenericsExample {
    public static void main(String[] args) {
        // Создание списка с разными типами
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        animalList.add(new Bird());
        animalList.add(new Kiwi());

        List<Bird> birdList = new ArrayList<>();
        birdList.add(new Bird());
        birdList.add(new Kiwi());

        List<Kiwi> kiwiList = new ArrayList<>();
        kiwiList.add(new Kiwi());

        // Использование обобщенных методов с подстановочными знаками
        processList(animalList);
        processList(birdList);
        processList(kiwiList);

        // Подстановочный знак с верхней границей
        processBirds(birdList);
        processBirds(kiwiList);
        processBirds(kiwiList);

        // Подстановочный знак с нижней границей
        processAnimalsOrBirds(animalList);
        processAnimalsOrBirds(birdList);
    }

    // Подстановочный знак без ограничений
    public static void processList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    // Подстановочный знак с верхней границей
    public static void processBirds(List<? extends Bird> list) {
        for (Bird bird : list) {
            System.out.println(bird);
        }
    }

    // Подстановочный знак с нижней границей
    public static void processAnimalsOrBirds(List<? super Bird> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }
}

```

#### 6. Стирание типов

В Java обобщения реализованы с использованием механизма стирания типов (`type erasure`). Это означает, что информация о типах параметров удаляется на этапе компиляции, и обобщенные типы заменяются их границами или `Object`, если границы не указаны. Это делает обобщения совместимыми с кодом, написанным до их введения, но накладывает некоторые ограничения, такие как невозможность создания экземпляров обобщенных типов.

### Пример использования обобщений:

```java

import java.util.ArrayList;
import java.util.List;

class Animal {
    @Override
    public String toString() {
        return "I am an Animal";
    }
}

class Bird extends Animal {
    @Override
    public String toString() {
        return "I am a Bird";
    }
}

class Kiwi extends Bird {
    @Override
    public String toString() {
        return "I am a Kiwi";
    }
}

// Обобщенный класс
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// Обобщенный метод
class Utility {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

// Ограниченный обобщенный класс
class AnimalBox<T extends Animal> {
    private T animal;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }
}

public class GenericsExample {
    public static void main(String[] args) {
        // Обобщенный класс
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem());

        // Обобщенный метод
        Animal[] animalArray = { new Animal(), new Bird(), new Kiwi() };
        Utility.printArray(animalArray);

        // Использование ограничений
        AnimalBox<Bird> birdBox = new AnimalBox<>();
        birdBox.setAnimal(new Bird());
        System.out.println(birdBox.getAnimal());

        // Использование подстановочных знаков
        List<Bird> birdList = new ArrayList<>();
        birdList.add(new Bird());
        birdList.add(new Kiwi());
        processAnimals(birdList);
    }

    // Обобщенный метод с подстановочным знаком
    public static void processAnimals(List<? extends Animal> list) {
        for (Animal animal : list) {
            System.out.println(animal);
        }
    }
}

```
 