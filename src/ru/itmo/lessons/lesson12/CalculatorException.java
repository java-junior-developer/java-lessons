package ru.itmo.lessons.lesson12;

public class CalculatorException extends Exception{

    // можно объявлять любые методы и свойства
    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Будьте внимательны";
    }
}
