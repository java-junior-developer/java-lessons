package ru.itmo.lessons.lesson10.enums;

// enum может создаваться со свойствами, конструкторами, методами

// Priority extends Enum, поэтому наследование перечислений запрещено
public enum Priority /* можно имплементировать интерфейс */ {
    HIGH(10), MEDIUM(5), LOW(1); // экземпляры типа Priority

    // свойства
    private int code; // 0

    // конструктор
    Priority(int code){ // модификатор доступа конструктора всегда private
        // любые инструкции
        this.code = code;
    }


    // методы доступны всех элементам (экземплярам) перечисления
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
