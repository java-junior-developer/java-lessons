package ru.itmo.lessons.lesson15.task.task01;


import java.util.*;

public class UserStorage {
    // ключи - логины пользователей (String)
    // значения - пользователи (User)
    private HashMap<String, User> users;

    public UserStorage() {
        users = new HashMap<>();
    }

    public void addUser(User user){ // добавление пользователя в map
        // user не может быть null
        // если пользователь с логином, как у user уже содержится в map users,
        // то пользователь не добавляется (значение не перезаписывать)
    }

    public List<User> getUsersByAge(int maxAge) {
        // метод формирует и возвращает список пользователей,
        // возраст которых меньше maxAge
        return null;
    }

    public Map<Integer, List<User>> getUsersByAge(){
        // метод формирует и возвращает map, где
        // ключи - возраст пользователей,
        // значения - списки пользователей соответствующего возраста
        return null;
    }

    public EnumMap<User.Role, Integer> getNumberOfUsersByRole(){
        // метод формирует и возвращает map, где
        // ключи - роли пользователей,
        // значения - количество с соответствующей ролью
        return null;
    }

}
