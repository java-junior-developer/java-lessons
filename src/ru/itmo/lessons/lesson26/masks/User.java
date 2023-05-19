package ru.itmo.lessons.lesson26.masks;

public class User {
    private int permissions;

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public static class Permission {
        // битовая маска - договоренность, что каждый бит означает
        // наличие или отсутствие чего-либо (например, разрешения на работу с разными типами файлов)
        // наличие - 1 / отсутствие - 0;

        // в программе есть следующие типы файлов:
        // PHOTO / VIDEO / AUDIO / TEXT

        // наличие разрешений на работу со всеми типами - число, при переводе в двоичную систему - 1111
        // отсутствие разрешений - число, при переводе в двоичную систему - 0000

        // каждый бит отвечает за определенный тип
        public static final int PHOTO = 1; // в двоичной системе 0001, есть разрешение на работу с PHOTO
        public static final int VIDEO = 2; // в двоичной системе 0010, есть разрешение на работу с VIDEO
        public static final int AUDIO = 4; // в двоичной системе 0100, есть разрешение на работу с AUDIO
        public static final int TEXT = 8;  // в двоичной системе 1000, есть разрешение на работу с TEXT
    }
}
