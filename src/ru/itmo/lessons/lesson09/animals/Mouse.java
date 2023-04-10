package ru.itmo.lessons.lesson09.animals;

public class Mouse {
    /* private */ public final int speed /* = 20 */;
    // значения final свойств задаются через конструктор или при объявлении
    // их нельзя изменить. Наличие сеттера для final свойства недопустимо
    // public Mouse(){}
    private String color;
    private Mouse(int speed){
        if (speed < 10) throw new IllegalArgumentException("Exception: speed < 10");
        this.speed = speed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Mouse getMouse(){
        String[] colors = {"черный", "серый", "белый"};
        Mouse mouse = new Mouse((int)(Math.random() *40 ) + 10); // случайное значение от 10 до 50
        mouse.setColor(colors[(int) (Math.random() * colors.length)]);
        return mouse;
    }
}
