import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Главный класс приложения.
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /**
     * Первая задача: создание экземпляра Printer с помощью лямбда-выражения.
     */
    public static void task1() {
        // Создание экземпляра Printer с помощью лямбда-выражения
        Printer printer = message -> {
            System.out.println(message);
            System.out.println("Длина сообщения – " + message.length());
        };

        // Использование созданного экземпляра для вызова метода print
        printer.print("Привет, мир!");
    }

    /**
     * Вторая задача: сортировка списка имен.
     */
    public static void task2() {
        // Создание списка имен
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Вывод исходного списка
        System.out.println("Исходный список: " + names);

        // Создание экземпляра NameSorter
        NameSorter nameSorter = new NameSorter();

        // Сортировка списка в обратном порядке с использованием анонимного класса
        nameSorter.sortWithAnonymousClass(names);
        System.out.println("Список после сортировки с использованием анонимного класса: " + names);

        // Сортировка списка в обратном порядке с использованием лямбда-выражения
        nameSorter.sortWithLambda(names);
        System.out.println("Список после сортировки с использованием лямбда-выражения: " + names);
    }
    public static void task3() {
        // Создание списка задач
        Task task1 = new Task(1, 3, "Task 1");
        Task task2 = new Task(2, 1, "Task 2");
        Task task3 = new Task(3, 2, "Task 3");
        Task task4 = new Task(4, 2, "Task 4");

        // Создание очереди с сортировкой по приоритету (по убыванию)
        PriorityQueue<Task> priorityQueueByPriority = new PriorityQueue<>((t1, t2) -> t2.getPriority() - t1.getPriority());
        priorityQueueByPriority.add(task1);
        priorityQueueByPriority.add(task2);
        priorityQueueByPriority.add(task3);
        priorityQueueByPriority.add(task4);

        System.out.println("Очередь задач, отсортированная по приоритету (по убыванию):");
        while (!priorityQueueByPriority.isEmpty()) {
            System.out.println(priorityQueueByPriority.poll());
        }

        // Создание очереди с сортировкой по приоритету (по возрастанию) и идентификатору (по возрастанию)
        PriorityQueue<Task> priorityQueueByPriorityAndId = new PriorityQueue<>(
                (t1, t2) -> {
                    int priorityComparison = t1.getPriority() - t2.getPriority();
                    if (priorityComparison != 0) {
                        return priorityComparison;
                    } else {
                        return t1.getId() - t2.getId();
                    }
                }
        );
        priorityQueueByPriorityAndId.add(task1);
        priorityQueueByPriorityAndId.add(task2);
        priorityQueueByPriorityAndId.add(task3);
        priorityQueueByPriorityAndId.add(task4);

        System.out.println("\nОчередь задач, отсортированная по приоритету (по возрастанию) и идентификатору (по возрастанию):");
        while (!priorityQueueByPriorityAndId.isEmpty()) {
            System.out.println(priorityQueueByPriorityAndId.poll());
        }
    }
    public static void task4() {
        List<String> words = Arrays.asList("apple", "banana", "fig", "date", "kiwi", "grape");

        // Создание экземпляра WordProcessor
        WordProcessor wordProcessor = new WordProcessor();

        // Обработка списка строк
        List<String> result = wordProcessor.processWords(words);

        // Вывод результата в консоль
        System.out.println(result);
    }
}
