# Структура данных Очередь и её реализации в Java

## Введение
Очередь (Queue) — это структура данных, которая работает по принципу FIFO (First In, First Out — первый пришел, первый ушел). Это означает, что элементы добавляются в конец очереди и удаляются из начала.

### Основные методы интерфейса Queue

1. **add(E e)** - Добавляет элемент в конец очереди. Бросает исключение, если операция не удалась.
2. **offer(E e)** - Добавляет элемент в конец очереди. Возвращает `false`, если операция не удалась.
3. **remove()** - Удаляет и возвращает элемент из начала очереди. Бросает исключение, если очередь пуста.
4. **poll()** - Удаляет и возвращает элемент из начала очереди. Возвращает `null`, если очередь пуста.
5. **element()** - Возвращает (но не удаляет) элемент из начала очереди. Бросает исключение, если очередь пуста.
6. **peek()** - Возвращает (но не удаляет) элемент из начала очереди. Возвращает `null`, если очередь пуста.

## Реализации интерфейса Queue

### LinkedList
`LinkedList` — это реализация интерфейсов `List` и `Deque`, которая может использоваться как очередь. Она поддерживает все основные операции очереди и имеет производительность O(1) для добавления и удаления элементов.

```java
Queue<Integer> linkedListQueue = new LinkedList<>();
linkedListQueue.offer(1);
linkedListQueue.offer(2);
int value = linkedListQueue.poll(); // value = 1
```

### PriorityQueue
`PriorityQueue` — это очередь с приоритетами, где элементы извлекаются в порядке их приоритета, а не в порядке добавления. По умолчанию элементы сортируются по натуральному порядку, но можно задать свой компаратор.

```java
Queue<Integer> priorityQueue = new PriorityQueue<>();
priorityQueue.offer(5);
priorityQueue.offer(1);
priorityQueue.offer(3);
int value = priorityQueue.poll(); // value = 1
```

### ArrayDeque
`ArrayDeque` — это реализация интерфейса `Deque`, которая может использоваться как очередь и стек. Она не имеет ограничений на размер и работает быстрее, чем `Stack` и `LinkedList` при использовании в качестве стека или очереди.

```java
Queue<Integer> arrayDeque = new ArrayDeque<>();
arrayDeque.offer(1);
arrayDeque.offer(2);
int value = arrayDeque.poll(); // value = 1
```

## Не однопоточкой единой

### ConcurrentLinkedQueue
`ConcurrentLinkedQueue` — это потокобезопасная реализация интерфейса `Queue`, основанная на неконкурирующих алгоритмах. Она обеспечивает безопасный доступ из нескольких потоков и используется в многопоточных приложениях.

```java
Queue<Integer> concurrentQueue = new ConcurrentLinkedQueue<>();
concurrentQueue.offer(1);
concurrentQueue.offer(2);
int value = concurrentQueue.poll(); // value = 1
```

### LinkedBlockingQueue
`LinkedBlockingQueue` — это потокобезопасная очередь с возможностью задания максимальной емкости. Она поддерживает операции блокировки при добавлении и удалении элементов, что полезно в условиях "конкуренции" потоков.

```java
BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
blockingQueue.offer(1);
blockingQueue.offer(2);
int value = blockingQueue.poll(); // value = 1
```

# Теория структуры данных Стек и его реализации в Java

## Введение
Стек (Stack) — это структура данных, работающая по принципу LIFO (Last In, First Out — последний пришел, первый ушел). Это означает, что элементы добавляются и удаляются с одного конца, называемого вершиной стека.

### Основные методы стека

1. **push(E item)** - Добавляет элемент на вершину стека.
2. **pop()** - Удаляет и возвращает элемент с вершины стека. Бросает исключение, если стек пуст.
3. **peek()** - Возвращает (но не удаляет) элемент с вершины стека. Бросает исключение, если стек пуст.
4. **isEmpty()** - Проверяет, пуст ли стек.
5. **size()** - Возвращает количество элементов в стеке.

## Реализации стека

### Stack
Класс `Stack` в Java является реализацией стека, основанной на коллекции `Vector`. Этот класс предоставляет стандартные методы для работы со стеком. 

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
int value = stack.pop(); // value = 2
```

### ArrayDeque
Класс `ArrayDeque` также может использоваться для реализации стека. Он предоставляет методы для добавления и удаления элементов с обоих концов, но в случае использования его как стека, мы будем использовать методы для работы с вершиной.

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.push(2);
int value = stack.pop(); // value = 2
```

### LinkedList
Класс `LinkedList` может использоваться для реализации стека, хотя обычно используется для очередей и двусторонних списков. Он также предоставляет методы для работы с вершиной.

```java
Deque<Integer> stack = new LinkedList<>();
stack.push(1);
stack.push(2);
int value = stack.pop(); // value = 2
```

## Примеры использования стека

### Проверка сбалансированности скобок
Стек часто используется для проверки корректности вложенности скобок в выражениях.

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
        } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
        } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
            stack.pop();
        } else {
            return false;
        }
    }
    return stack.isEmpty();
}
```

