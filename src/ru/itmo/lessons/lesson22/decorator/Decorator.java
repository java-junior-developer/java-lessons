package ru.itmo.lessons.lesson22.decorator;

public class Decorator {
    public static void main(String[] args) {
        // Декоратор позволяет добавлять объектам новую функциональность.
        // 1. Основной функционал определен в классах AppFileWriter и ConsoleWriter, они могут работать самостоятельно или
        // к ним может быть добавлен дополнительный функционал
        // 2. Дополнительный функционал определен в классах Delimiter и Upper.
        // 3. Классы определяющие основной и дополнительный функционал должны иметь общий тип данных (обычно интерфейс) - AppLogger
        // 4. Классы обеспечивающие дополнительный функционал обязаны иметь ссылку на экземпляр типа из п.3,
        // конструктор обязательно должен принимать и устанавливать значение данного свойства - класс BaseDecorator (родитель декораторов)
        // 4.1 Конструктор и общий тип позволяет вкладывать декораторы друг в друга и заканчивать вложение основным функционалом.
        // 5. Реализация абстрактного метода интерфейса декораторов заключается в следующем: выполнить требующееся от них действия и
        // вызвать аналогичный метод у объекта из п.4 (другого декоратора или объекта с основным функционалом)

        AppLogger logger01 = new Delimiter(new Upper(new ConsoleWriter()));
        logger01.log("сообщение");

        AppLogger logger02 = new Upper(new Delimiter(new AppFileWriter("src/ru/itmo/lessons/lesson22/decorator/file.txt")));
        logger02.log("сообщение");

        ConsoleWriter console = new ConsoleWriter();
        console.log("данные"); // данные будут выведены в консоль

        AppFileWriter file = new AppFileWriter("src/ru/itmo/lessons/lesson22/decorator/file.txt");
        file.log("данные"); // данные будут записаны в файл
    }
}
