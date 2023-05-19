package ru.itmo.lessons.lesson26.masks;

public class Masks {
    public static void main(String[] args) {
        User user = new User();
        // установить разрешения на работу с TEXT и PHOTO
        user.setPermissions(User.Permission.TEXT | User.Permission.PHOTO);
        // побитовое или | - сравнивает числа побитово, возвращает 1, если хотя бы один бит - 1
        // используется для объединения разрешений
        // 1000 - User.Permission.TEXT
        // 0001 - User.Permission.PHOTO
        // 1001 - разрешение на PHOTO (0001) и разрешение на TEXT (1000)

        // проверить наличие разрешения
        if ((user.getPermissions() & User.Permission.AUDIO) != User.Permission.AUDIO) {
            System.out.println("у Вас нет доступа к аудиоинформации");
        } else {
            System.out.println("доступ к аудиоинформации открыт");
        }
        // побитовое и & - сравнивает числа побитово, возвращает 1, если оба бита - 1
        // используется для проверки наличия разрешения
        // 1001 - user.getPermissions() - текущие разрешения
        // 0100 - User.Permission.AUDIO - хотим проверить возможность работать с AUDIO
        // 0000 - у пользователя нет разрешение на работу с AUDIO (0100)

        // проверить наличие разрешения
        if ((user.getPermissions() & User.Permission.PHOTO) != User.Permission.PHOTO) {
            System.out.println("у Вас нет доступа к фото");
        } else {
            System.out.println("доступ к фото открыт");
        }
        // 1001 - user.getPermissions() - текущие разрешения
        // 0001 - User.Permission.PHOTO - хотим проверить возможность работать с PHOTO
        // 0001 - у пользователя есть разрешение на работу с PHOTO (0001)

        // исключить разрешение
        user.setPermissions(user.getPermissions() & ~User.Permission.TEXT);
        // побитовые & ~ используется для исключения разрешения
        // ~ побитовая инверсия, заменяет бит на противоположный
        // 1000 - User.Permission.TEXT, 0111 - ~User.Permission.TEXT

        // 1001 - user.getPermissions() - текущие разрешения
        // 0111 - преобразованный оператором (~) User.Permission.TEXT
        // 0001 - у пользователя больше нет разрешения на работу с TEXT (1000)
    }
}
