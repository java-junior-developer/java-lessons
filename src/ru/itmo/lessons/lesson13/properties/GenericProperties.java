package ru.itmo.lessons.lesson13.properties;

public class GenericProperties {
    public static void main(String[] args) {
        User<String> stringUser = new User<>();
        stringUser.setId("fwfq34");
        stringUser.setLogin("qwerty");
        System.out.println(stringUser.getId().toUpperCase());

        User rawUser = new User(); // необработанный / сырой тип -
        // - для обратной совместимости
        rawUser.setId("fwfq34");
        rawUser.setLogin("qwerty");
        System.out.println(rawUser.getId());
    }
}
