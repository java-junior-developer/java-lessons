package ru.itmo.lessons.lesson20.task01;

public class Task01 {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();

        notifier.addUser(new User(true));
        notifier.addUser(new User(false));
        notifier.addUser(new User(true));
        notifier.addUser(new User(true));
        notifier.addUser(new User(false));
        notifier.addUser(new User(true));
        notifier.addUser(new User(false));

        // way01, way02, way03 - ссылки на способы рассылки уведомлений (например, почта, смс и т.п.)

        notifier.notifyUsers(way01.add(way02).addIf(way03, user -> user.isAgreeWithAdditional()));
        // add принимает на вход способ рассылки уведомлений
        // addIf принимает на вход способ рассылки уведомлений и Predicate
    }
}
