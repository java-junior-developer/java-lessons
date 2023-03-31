package ru.itmo.lessons.lesson0708.school;

public class Lesson07 {
    public static void main(String[] args) {
        Student student01 = new Student("Марк", "химия");
        student01.setAge(12);
        Teacher teacher01 = new Teacher("биология", 10, "Елена Олеговна");
        teacher01.setAge(30);

        // Person person = new Person(); - ошибка, тк Person - абстрактный
        Person student02 = new Student("Иван", "астрономия");
        Person teacher02 = new Teacher("астрономия", 14, "Григорий Петрович");
        // для вызова доступны только методы и свойства,
        // объявленные в классе Person
        // если методы были переопределны в дочерних классах,
        // то при вызове будет использоваться их реализация
        student02.setAge(8);
        teacher02.setAge(46);

        student02.rest();
        teacher02.rest();

        // общий тип данных используется для хранения объектов
        // в массивах, коллекциях и т.д.
        Person[] people = {student01, student02, teacher01, teacher02};
        for (Person person : people) {
            person.rest();
        }
        // общий тип данных используется для передачи объектов в методы



    }
}
