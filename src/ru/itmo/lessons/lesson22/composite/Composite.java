package ru.itmo.lessons.lesson22.composite;

public class Composite {

    public static void main(String[] args) {
        // Компоновщик позволяет сгруппировать множество объектов в древовидную структуру,
        // а затем работать с ней так, как с единым объектом.
        // 1. Объекты, собираемые в древовидную структуру (простые листья - AppImage и составные контейнеры - Gallery)
        // должны реализовывать общий интерфейс или наследоваться от одного родителя, реализуя их абстрактные методы - Drawable
        // 2. Класс - компоновщик (Render) содержит ссылку на общий для сложных и составных объектов тип - Drawable drawable в классе Render
        // и может работать с ним без определения конкретного типа объекта через методы общего типа - метод void show() в классе Render

        AppImage image01 = new AppImage("images/house", "House");
        AppImage image02 = new AppImage("images/tree", "Tree");
        AppImage image03 = new AppImage("images/sun", "Sun");


        AppImage image04 = new AppImage("images/fox", "Fox");
        AppImage image05 = new AppImage("images/Wolf", "Wolf");

        Gallery gallery01 = new Gallery("Wild Animals");
        gallery01.add(image04);
        gallery01.add(image05);

        AppImage image06 = new AppImage("images/cat", "Cat");
        AppImage image07 = new AppImage("images/dog", "Dog");

        Gallery gallery02 = new Gallery("Pets");
        gallery02.add(image06);
        gallery02.add(image07);


        Gallery gallery03 = new Gallery("Village");
        gallery03.add(gallery01);
        gallery03.add(gallery02);
        gallery03.add(image01);
        gallery03.add(image02);
        gallery03.add(image03);


        Render render = new Render(gallery03);
        render.show();
    }
}
