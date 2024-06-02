### Техническое задание

#### Цель
Разработать класс `RubberArray`, который будет улучшенной версией обычного массива.

## Требования на первый спринт

1. **Хранилище данных**
   - Использовать массив для хранения элементов.

2. **Операции**

   - **Добавление элемента**
     - Метод `append`: добавляет элемент в конец массива.
   
   - **Добавление нескольких элементов**
     - Метод `appendRange`: добавляет несколько элементов в конец массива.
   
   - **Удаление элемента**
     - Метод `remove`: удаляет первый найденный элемент из массива.
  
   - **Удаление элемента по указанному индексу**
     - Метод `removeAt(int position)`: удаляет элемент из массива на указанной позиции.
   
   - **Чтение элемента по индексу**
     - Метод `get`: возвращает элемент по указанному индексу.
   
   - **Размер массива**
     - Метод `size`: возвращает текущий размер массива.
   
   - **Проверка наличия элемента**
     - Метод `contains`: проверяет, содержится ли элемент в массиве.

3. **Внутренние методы и структуры**
   - Внутренний массив должен автоматически увеличиваться при необходимости (увеличение вместимости).

#### Пример использования

```java
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        RubberArray array = new RubberArray();
        System.out.println("array = " + array); // array = []

        array.append(1);
        System.out.println("array = " + array); // array = [1]

        array.append(2);
        System.out.println("array = " + array); // array = [1 2]

        System.out.println("size = " + array.size()); // size = 2
        array.appendRange(new int[] { 3, 4, 5 });

        System.out.println("array.get(2): " + array.get(2)); // array.get(2): 3
        System.out.println("array = " + array); // array = [1 2 3 4 5]
        System.out.println("size = " + array.size()); // size = 5

        array.remove(3);
        System.out.println("array.contains(3): " + array.contains(3)); // array.contains(3): false
        System.out.println("array.contains(1): " + array.contains(1)); // array.contains(1): true
        System.out.println("array.contains(5): " + array.contains(5)); // array.contains(5): true
        System.out.println("array = " + array); // array = [1 2 4 5]

        Random random = new Random(2026);
        for (int i = 0; i < 100; i++) {
            array.append(random.nextInt(10, 20));
        }
        System.out.println("array = " + array); // array = [1 2 4 5 19 10 17 10 19 18 13 16 14 18 19 19 11 10 14 14 10
                                                // 12 13 17 11 16 18 13 13 10 15 14 10 15 16 10 14 14 11 10 18 17 15 12
                                                // 16 12 13 18 11 17 18 16 11 17 17 16 18 19 14 15 10 18 17 11 18 13 13
                                                // 11 15 11 12 14 13 10 17 16 14 14 19 19 15 14 10 11 15 10 19 14 12 11
                                                // 18 14 14 12 11 16 12 11 14 15 13 15 14 11]

    }
}

```

## Требования на второй спринт
- Добавить методы для вставки элемента в конкретную позицию.
- Добавить методы для очистки массива.
- Реализовать возможность работы с `foreach`.
- Поддержка изменения размера массива в меньшую сторону, если элементы удаляются.
- Ускорить работу функционала, если это возможно.