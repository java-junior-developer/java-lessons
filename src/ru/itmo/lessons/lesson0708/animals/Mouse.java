package ru.itmo.lessons.lesson0708.animals;

public class Mouse {
    /* private */ public final int speed /* = 20 */;
    // значения final свойств задаются через конструктор или при объявлении
    // их нельзя изменить. Наличие сеттера для final свойства недопустимо
    // public Mouse(){}
    public Mouse(int speed){
        if (speed < 10) throw new IllegalArgumentException("Exception: speed < 10");
        this.speed = speed;
    }
}
