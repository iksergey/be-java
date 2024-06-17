### Техническое задание

#### Описание задачи
Есть карта города, представленная в виде двумерного массива, где курьеру необходимо найти путь (желательно кратчайший) от стартовой точки до конечной точки. Карта содержит препятствия, через которые курьер не может пройти. Необходимо разработать программу, которая позволит курьеру определить маршрут (? кратчайший).

#### Требования к функционалу

1. **Генерация карты:**
   - Карта представлена в виде двумерного массива, где:
     - `-1` - препятствие, через которое нельзя пройти.
     - `0` - свободное место, по которому можно передвигаться.
   - В массиве могут быть другие специальные значения, такие как начальная и конечная точки.

2. **Представление точки на карте:**
   - Точка на карте должна быть представлена как объект с координатами `x` и `y`.

3. **Вывод карты:**
   - Реализовать функцию для вывода карты, где каждое значение массива будет представлено соответствующим символом или числом.

4. **Поиск пути:**
   - Реализовать алгоритм, который сможет найти путь(? кратчайший) от заданной стартовой точки до конечной точки, обходя препятствия.
   - Маршрут должен быть найден с использованием подхода, который гарантирует нахождение пути (? кратчайшего).
   - Алгоритм должен работать корректно для различных размеров карты и конфигураций препятствий.

5. **Печать карты с маршрутом:**
   - После нахождения пути необходимо вывести карту, на которой будет отображен найденный маршрут.

#### Требования к реализации

1. **Язык программирования:**
   - Реализация должна быть выполнена на языке Java.

2. **Классы и методы:**
   - `Point2D` - класс для представления точки с координатами `x` и `y`.
   - `MapGenerator` - класс для генерации и хранения карты. Должен содержать методы для установки начальной и конечной точек.
   - `MapPrinter` - класс для вывода карты в текстовом виде.
   - `PathFinder` - класс для поиска кратчайшего пути. Должен содержать метод для запуска алгоритма поиска пути и метод для получения найденного маршрута.

3. **Пример использования:**
   - Создание карты с помощью `MapGenerator`.
   - Установка начальной и конечной точек.
   - Поиск пути с помощью `PathFinder`.
   - Вывод исходной карты и карты с найденным маршрутом с помощью `MapPrinter`.

#### Пример карты

```

 0  0  0 -1  0  0  0  0  0  0  0  0  0
 0  0  0  0  0  0 -1  0  0  0  0  0  0
 0  0  0 -1  0  0 -1  0  0  0  0  0  0
 0  0  0 -1  0 -1 -1 -1 -1  0  0  0  0
 0  0  0 -1  0 -1  0  0 -1  0  0  0  0
-1 -1  0 -1  0 -1  0  0 -1  0  0  0  0
 0  0  0 -1  0 -1  0  0 -1 -1 -1  0  0
 0  0  0 -1  0  0  0  0 -1  0  0  0  0
 0  0  0 -1  0  0  0  0 -1  0  0  0  0
 0  0  0 -1 -1 -1 -1 -1 -1  0  0  0  0
 0  0  0  0  0  0  0  0  0  0  0  0  0
 0  0  0 -1 -1 -1 -1 -1 -1 -1  0  0  0
 0  0  0  0  0  0  0  0  0  0  0  0  0

```