Принцип PECS (Producer Extends Consumer Super) помогает правильно использовать wildcard-типы в дженериках Java для обеспечения типобезопасности и гибкости кода. Этот принцип был введен Джошуа Блохом в книге "Effective Java". Основная идея заключается в следующем:

- **Producer Extends**: Если метод или класс **производит** объекты (т.е. возвращает их), используйте `<? extends T>`. Это позволяет работать с любым типом, который является подтипом `T`. Например, если у вас есть коллекция `List<? extends Fruit>`, вы можете быть уверены, что все элементы в этой коллекции являются фруктами или их подтипами.
- **Consumer Super**: Если метод или класс **потребляет** объекты (т.е. принимает их в качестве параметров), используйте `<? super T>`. Это позволяет работать с любым типом, который является суперклассом `T`. Например, если у вас есть коллекция `List<? super Apple>`, вы можете добавлять в неё объекты типа `Apple` или любого его подтипа.

Принцип PECS можно запомнить следующим образом:
- **Producer Extends**: Используйте `extends` для производителей.
- **Consumer Super**: Используйте `super` для потребителей.