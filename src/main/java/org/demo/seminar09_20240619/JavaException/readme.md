Исключения – это механизм обработки ошибок, который помогает разработчикам обрабатывать различные типы ошибок, возникающие во время выполнения программы. Исключения делятся на два основных типа: проверяемые (checked) исключения и непроверяемые (unchecked) исключения.

![](./img/Exception-Handling-768.png)

### Проверяемые исключения (Checked Exceptions)

Проверяемые исключения наследуются от класса `Exception`, но не от класса `RuntimeException`. Эти исключения должны быть либо обработаны с помощью блока `try-catch`, либо объявлены в сигнатуре метода с использованием ключевого слова `throws`. Они используются для обозначения предсказуемых ошибок, которые могут произойти в нормальном ходе выполнения программы, например, проблемы с вводом-выводом (I/O), проблемы с доступом к базе данных и т. д.


### Непроверяемые исключения (Unchecked Exceptions)

Непроверяемые исключения включают в себя ошибки (`Error`) и исключения времени выполнения (`RuntimeException`). Эти исключения возникают во время выполнения программы и указывают на ошибки, которые обычно вызваны логическими ошибками в коде (например, деление на ноль, обращение к нулевому указателю).

### Основные моменты

1. **Иерархия исключений**: Все исключения в Java наследуются от класса `Throwable`. `Exception` и `Error` являются подклассами `Throwable`. `RuntimeException` является подклассом `Exception`.
   
2. **Обработка исключений**: Используйте блоки `try-catch` для обработки исключений. Блок `finally` может быть добавлен для выполнения кода, который должен выполниться независимо от того, произошло исключение или нет.

```java
try {
    // код, который может вызвать исключение
} catch (ExceptionType1 e1) {
    // обработка исключения типа ExceptionType1
} catch (ExceptionType2 e2) {
    // обработка исключения типа ExceptionType2
} finally {
    // код, который будет выполнен в любом случае
}
```

3. **Создание пользовательских исключений**: Вы можете создавать свои собственные исключения, наследуя от класса `Exception` или `RuntimeException`.

```java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

4. **Propagating exceptions**: Исключения могут быть переданы на более высокий уровень с помощью ключевого слова `throws` в сигнатуре метода.



```java
public void myMethod() throws IOException {
    // код, который может вызвать IOException
}
```

5. **Multi-catch block**: В Java 7 и выше вы можете использовать один блок `catch` для обработки нескольких типов исключений.

```java
try {
    // код, который может вызвать исключение
} catch (IOException | SQLException ex) {
    ex.printStackTrace();
}
```

В Java `Error` — это тип исключения, который указывает на серьезные проблемы, возникающие в ходе выполнения программы и обычно не подлежащие восстановлению. Ошибки (`Error`) являются подклассами класса `Throwable` и наследуются напрямую от него.


### Характеристики ошибок (Error)

1. **Серьезность**: Ошибки обычно указывают на критические проблемы, которые невозможно или крайне сложно исправить. Эти проблемы могут быть вызваны недостатком ресурсов (например, памяти), нарушениями в работе JVM (Java Virtual Machine) или другими фатальными ошибками.

2. **Непроверяемые исключения**: Ошибки являются непроверяемыми исключениями, то есть они не требуют обязательной обработки в коде с помощью блоков `try-catch` и не требуют объявления в сигнатуре метода с использованием ключевого слова `throws`.

3. **Использование**: Ошибки не предназначены для обработки в приложении. Они сигнализируют о таких проблемах, которые обычно требуют вмешательства на уровне системы или JVM.

### Примеры ошибок

- `OutOfMemoryError`: Возникает, когда JVM не может выделить больше памяти для работы приложения.
  
  ```java
  public class Main {
      public static void main(String[] args) {
          // Пример, который может вызвать OutOfMemoryError
          int[] array = new int[Integer.MAX_VALUE];
      }
  }
  ```

- `StackOverflowError`: Возникает при переполнении стека вызовов, например, из-за бесконечной рекурсии.

  ```java
  public class Main {
      public static void main(String[] args) {
          recursiveMethod();
      }

      public static void recursiveMethod() {
          recursiveMethod(); // Бесконечная рекурсия
      }
  }
  ```

- `VirtualMachineError`: Общий класс для ошибок, связанных с JVM, таких как `InternalError`, `UnknownError`.

### Иерархия ошибок (Error)

Ошибки наследуются от класса `Error`, который, в свою очередь, является подклассом класса `Throwable`. Ниже приведены некоторые из распространенных ошибок и их иерархия.

1. **VirtualMachineError**
   - InternalError
   - OutOfMemoryError – возникает, когда JVM не может выделить больше памяти для работы приложения.
   - StackOverflowError – возникает при переполнении стека вызовов, например, из-за бесконечной рекурсии.
   - UnknownError

2. **LinkageError**: Возникает, когда ошибка происходит в процессе связывания класса.
   - ClassCircularityError
   - ClassFormatError
   - ExceptionInInitializerError
   - IncompatibleClassChangeError
   - NoClassDefFoundError
   - UnsatisfiedLinkError
   - VerifyError
 
 
Пример иерархии ошибок:

- Error
  - AssertionError
  - LinkageError
    - ClassCircularityError
    - ClassFormatError
    - ExceptionInInitializerError
    - IncompatibleClassChangeError
    - NoClassDefFoundError
    - UnsatisfiedLinkError
    - VerifyError
  - VirtualMachineError
    - InternalError
    - OutOfMemoryError
    - StackOverflowError
    - UnknownError
  - ThreadDeath
и т. д.

