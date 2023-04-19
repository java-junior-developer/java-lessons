package ru.itmo.lessons.lesson16.memorymodel;


import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class Lesson16 {
    public final static String CLASS_NAME = "Lesson 16";

    static { // static блок

        // инструкции выполняются один раз, когда класс загружается в память
        // можно вызывать static методы, устанавливать значения static свойств

        System.out.println("Класс " + Lesson16.CLASS_NAME + " загружен в память. " +
                "Загрузчик " + Lesson16.class.getClassLoader().getName());
    }

    public static void main(String[] args) {
        DevelopingClass defaultObj = DevelopingClass.getDefault();
        defaultObj.minusValue(8);
        defaultObj.plusValue(33);
        System.out.println(defaultObj.getValue());
        System.out.println(defaultObj);

        DevelopingClass obj = new DevelopingClass(100);
        obj.minusValue(70);
        obj.plusValue(33);
        System.out.println(obj.getValue());
        System.out.println(obj);

        // сильные ссылки (объекты не могут быть удалены сборщиком, если есть сильные ссылки)
        DevelopingClass strongKey01 = new DevelopingClass(11);
        DevelopingClass strongKey02 = new DevelopingClass(22);

        // слабые ссылки (объекты могут быть удалены сборщиком, если есть только слабые ссылки)
        WeakReference<DevelopingClass> weak01 = new WeakReference<>(strongKey01);
        WeakReference<DevelopingClass> weak02 = new WeakReference<>(strongKey02);

        HashMap<DevelopingClass, String> hashMap = new HashMap<>();
        hashMap.put(strongKey01, "strong01");

        // ключи будут удалены сборщиком, если на них не осталось сильных ссылок
        // пары будут удалены из weakHashMap
        WeakHashMap<DevelopingClass, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(strongKey02, "strong02");

        strongKey01 = null;
        strongKey02 = null;

        System.gc();

        System.out.println(hashMap.size());
        System.out.println(weakHashMap.size());
    }
}
