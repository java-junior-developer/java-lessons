package ru.itmo.lessons.lesson19.tasks.task01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> map = students.stream().collect(
                Collectors.groupingBy(student -> student.getGender(),
                        Collectors.toCollection(ArrayList::new))
        );
        //  2. Найти средний возраст учеников
        // получить поток(Stream) из элементов списка students
        // вызвать метод collect, передать в метод Collectors.averagingInt(ToIntFunction)
        // в метод averagingInt передать реализацию интерфейса ToIntFunction,
        // его абстрактный метод int applyAsInt(T value):
        // метод принимает на вход элемент потока,
        // возвращаемое значение будет использоваться в Collectors.averagingInt для подсчета среднего

        //  3. Найти самого младшего ученика - Stream -> min(Comparator<Student>): int compare(T o1, T o2);
        Student student = students.stream().min((s1, s2) -> s2.getBirth().compareTo(s1.getBirth())).get();
        //  4. Найти самого старшего ученика - Stream -> max(Comparator<Student>): int compare(T o1, T o2);

        //  5. Собрать учеников в группы по году рождения, результат - Map<ГодРождения, List<Student>>
        // получить поток(Stream) из элементов списка students
        // вызвать метод collect, передать в метод Collectors.groupingBy(Function)
        // в метод groupingBy передать реализацию интерфейса Function,
        // его абстрактный метод R apply(T value):
        // метод принимает на вход элемент потока,
        // возвращаемое значение будет использоваться в Collectors.groupingBy для определения ключей мапы

        // чтобы получить год из даты (LocalDate) нужно вызвать метод getYear

        //  6. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (ArrayList)
        // 1 вариант - students.sort(Comparator)
        // 2 вариант:
        // получить поток(Stream) из элементов списка students
        // вызвать метод sorted(Comparator)
        // вызвать метод .collect(Collectors.toCollection(ArrayList::new)) для создания списка

        //  7. Вывести в консоль всех учеников в возрасте от N до M лет
        //  получить поток(Stream) из элементов списка students
        //  1 вариант
        //  вызвать метод filter(Predicate), чтобы оставить элементы, удовлетворяющие условию задачи
        //  вызвать метод foreach(Consumer) для вывода оставшихся в консоль
        //  2 вариант
        //  вызвать метод foreach(Consumer) для вывода в консоль элементов, удовлетворяющие условию задачи
        //  8. Собрать в список всех учеников с именем=someName
        //  получить поток(Stream) из элементов списка students
        //  вызвать метод filter(Predicate), чтобы оставить элементы, удовлетворяющие условию задачи
        //  вызвать метод .toList() для создания списка
        //  9. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола
        //     см. метод Collectors.summingInt


    }
}
