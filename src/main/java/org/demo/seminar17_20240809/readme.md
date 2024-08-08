# Принципы проектирования `SOLID`

Существует набор общепринятых принципов проектирования, которые позволяют определить соответствует ли программный код определению «хороший» или «плохой».
Этот набор состоит из 5 принципов. Термин `SOLID` является акронимом, образованным из первых букв названий отдельных принципов:
- `SRP` Single responsibility principle (принцип единственной ответственности).
- `OCP` Open-closed principle (принцип открытости / закрытости).
- `LSP` Liskov substitution principle (принцип подстановки Лисков).
- `ISP` Interface segregation principle (принцип разделения интерфейсов).
- `DIP` Dependency inversion principle (принцип инверсии зависимостей).

Следование каждому из этих принципов позволяет облегчить понимание и сопровождение кода. Кроме того, программный код, написанный согласно принципам `SOLID`, в большей мере соответствует и принципам объектно-ориентированного программирования.


# `SRP`
это один из пяти принципов SOLID, предложенных Робертом Мартином. Он гласит, что класс должен иметь только одну причину для изменения. Суть заключается в том, что каждый класс должен выполнять только одну конкретную ответственность, и изменения в этой ответственности должны приводить к изменению только этого класса.

### Пример

Плохой пример

```java
public class Employee {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void saveToDatabase() {
        // Сохранение сотрудника в базу данных
    }

    public void calculateTax() {
        // Расчет налогов
    }
}
```
Хороший пример

```JAVA
public class Employee {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeDatabase {
    public void saveToDatabase(Employee employee) {
        // Сохранение сотрудника в базу данных
    }
}

public class TaxCalculator {
    public void calculateTax(Employee employee) {
        // Расчет налогов
    }
}
```
В плохо соблюденном `SRP` примере класс `Employee` имеет две ответственности: сохранение в базу данных и расчет налогов. В хорошо соблюденном `SRP` примере каждый класс выполняет только одну конкретную задачу: `Employee` отвечает только за информацию о сотруднике, `EmployeeDatabase` занимается сохранением сотрудника в базе данных, а `TaxCalculator` - расчетом налогов. Это делает код более поддерживаемым и позволяет изменять каждую часть независимо от других.


# `OCP`
Принцип открытости / закрытости (Open-Closed Principle, OCP) - это один из принципов SOLID, который гласит, что классы должны быть открыты для расширения, но закрыты для модификации. Это означает, что изменения в поведении класса должны быть достигнуты через добавление нового кода, а не путем изменения существующего кода.

### Пример

Плохой пример

```java
public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
```
Хороший пример

```JAVA
public interface Shape {
    double area();
}

public class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle implements Shape {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
```
В плохо соблюденном `OCP` примере, чтобы добавить новую фигуру (например, треугольник), нам пришлось бы изменять существующий код, что нарушает принцип. В хорошо соблюденном `OCP` примере мы создали интерфейс `IShape`, который позволяет добавлять новые фигуры, не изменяя существующий код. Это делает код более гибким и поддерживаемым.

# `LSP`
Принцип подстановки Лисков гласит, что объекты подклассов должны быть способны заменить объекты базового класса без изменения желаемых свойств программы. Иными словами, если у вас есть базовый класс и унаследованный от него подкласс, то подкласс должен быть совместим с базовым классом и не должен нарушать ожидаемое поведение программы.

### Пример

Плохой пример

```JAVA
public class Bird {
    public void fly() {
        System.out.println("The bird is flying.");
    }
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("The ostrich cannot fly.");
    }
}
```
Хороший пример

```JAVA
public class Bird {
    public void fly() {
        System.out.println("The bird is flying.");
    }
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        System.out.println("The ostrich cannot fly.");
    }
}
```

В хорошей реализации метод `Fly` в классе `Ostrich` переопределяется так, чтобы он корректно представлял поведение страуса, который не летает, но бегает. Таким образом, код, ожидающий объект типа Bird, может использовать объекты `Ostrich`, и они будут совместимы без нарушения LSP.

# `ISP`

Принцип разделения интерфейсов гласит, что клиенты не должны зависеть от интерфейсов, которые они не используют. Интерфейсы должны быть разделены на более мелкие, специфические части, чтобы минимизировать зависимости.

Плохой пример

```JAVA
public interface Worker {
    void work();
    void eat();
    void sleep();
}

public class Manager implements Worker {
    @Override
    public void work() {
        // Реализация работы менеджера
    }

    @Override
    public void eat() {
        // Реализация приема пищи менеджера
    }

    @Override
    public void sleep() {
        // Реализация сна менеджера
    }
}

public class Robot implements Worker {
    @Override
    public void work() {
        // Реализация работы робота
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots cannot eat.");
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException("Robots cannot sleep.");
    }
}
```
В этой плохой реализации интерфейс `IWorker` имеет методы, которые не имеют смысла для всех его реализующих классов. Например, методы `Eat` и `Sleep` не имеют смысла для класса `Robot`, но им приходится реализовывать и выбрасывать исключения.

Хороший пример

```JAVA
public interface Worker {
    void work();
}

public interface Eater {
    void eat();
}

public interface Sleeper {
    void sleep();
}

public class Manager implements Worker, Eater, Sleeper {
    @Override
    public void work() {
        // Реализация работы менеджера
    }

    @Override
    public void eat() {
        // Реализация приема пищи менеджера
    }

    @Override
    public void sleep() {
        // Реализация сна менеджера
    }
}

public class Robot implements Worker {
    @Override
    public void work() {
        // Реализация работы робота
    }
}

```

В этой хорошей реализации интерфейсы разделены на более мелкие, специфические части, что позволяет классу `Robot` не реализовывать несмысленные методы `Eat` и `Sleep`, а классу `Manager` реализовать только те методы, которые ему действительно нужны.

# `DIP`
Принцип инверсии зависимостей гласит, что модули верхнего уровня не должны зависеть от модулей нижнего уровня. И оба уровня должны зависеть от абстракций. Также, абстракции не должны зависеть от деталей, но детали должны зависеть от абстракций.

Плохой пример

```JAVA
public class LightBulb {
    public void turnOn() {
        // Включить лампочку
    }

    public void turnOff() {
        // Выключить лампочку
    }
}

public class Switch {
    private LightBulb bulb;

    public Switch() {
        this.bulb = new LightBulb();
    }

    public void operate() {
        if (bulb.isOn()) {
            bulb.turnOff();
        } else {
            bulb.turnOn();
        }
    }
}
```
В этой плохой реализации класс `Switch` непосредственно зависит от конкретной реализации `LightBulb`, что делает его жестко связанным с ней.

Хороший пример

```JAVA
public interface Switchable {
    void turnOn();
    void turnOff();
}

public class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        // Включить лампочку
    }

    @Override
    public void turnOff() {
        // Выключить лампочку
    }
}

public class Fan implements Switchable {
    @Override
    public void turnOn() {
        // Включить вентилятор
    }

    @Override
    public void turnOff() {
        // Выключить вентилятор
    }
}

public class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        if (device.isOn()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }
}

```
В этой хорошей реализации `Switch` зависит от абстракции `ISwitchable`, а не от конкретных классов, что позволяет подключать разные устройства, такие как `LightBulb` и `Fan`, без изменения кода `Switch`. Это соблюдает принцип инверсии зависимостей.

### Внедрение зависимостей (Dependency Injection, DI)

Внедрение зависимостей (Dependency Injection, DI) - это паттерн проектирования, который позволяет передавать зависимости, необходимые для работы объекта, извне, вместо того чтобы объект сам их создавал. Это делает код более гибким, улучшает тестируемость и соблюдает принцип инверсии зависимостей (DIP) из принципов SOLID.

Существуют два основных способа внедрения зависимостей:

#### 1. Внедрение через конструктор (Constructor Injection)
В этом случае зависимости передаются через конструктор класса. Это является наиболее распространенным способом внедрения зависимостей.

**Пример:**

```java
public class SomeService {
    private IDependency dependency;

    public SomeService(IDependency dependency) {
        this.dependency = dependency;
    }

    // ...
}
```

#### 2. Внедрение через методы (Method Injection)
Зависимости передаются через методы экземпляра класса. Этот способ используется, когда зависимость требуется только на определенном этапе работы.

**Пример:**

```java
public class SomeService {
    public void setDependency(IDependency dependency) {
        // Установка зависимости
    }

    // ...
}
```

Преимущества внедрения зависимостей включают в себя уменьшение связанности классов, повышение переиспользуемости, упрощение тестирования и облегчение поддержки кода.

### IoC (Inversion of Control)

Это фреймворки или библиотеки, которые облегчают управление зависимостями в приложении. Они предоставляют механизмы для регистрации зависимостей и автоматического создания экземпляров этих зависимостей при их использовании. IoC контейнеры соблюдают принцип инверсии управления (IoC) и принцип внедрения зависимостей (DI), делая приложение более гибким и легко расширяемым.

Основные функции IoC контейнера включают:

- **Регистрация зависимостей:** Контейнер позволяет зарегистрировать типы и их реализации, указывая, какой интерфейс или абстрактный класс связан с каким конкретным классом.
- **Создание экземпляров:** Контейнер автоматически создает экземпляры зарегистрированных классов и управляет их жизненным циклом.
- **Разрешение зависимостей:** Когда код требует конкретную зависимость, контейнер создает и предоставляет экземпляр этой зависимости, учитывая зарегистрированные связи.
- **Управление жизненным циклом:** Некоторые контейнеры позволяют настраивать жизненные циклы зависимостей, такие как Singleton, Transient, Scoped и другие.
