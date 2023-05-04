package questions.questions06;

public class Questions {
    public static void main(String[] args) {
        Building building = new Building(Building.Color.ORANGE, 15);
        building.open();

        // 1. Где будут доступны элементы перечисления Color, объявленного в классе Building?
        // 2. Где будут доступны классы RoomsCreator, FindSecretRooms и Room, объявленные в классе Building?
        // 3. Правильно ли выбраны модификаторы доступа классов RoomsCreator, FindSecretRooms и Room?
        // 4. Перечисления являются static вложенными или non-static внутренними классами?
        // 5. В каких из объявленных в Building классах можно обратиться к его экземпляру, как это сделать?
        // 6. Метод close класса Room переопределяет или затеняет метод close класса Building?
        // 7. C какими модификаторами доступа может быть объявлен класс RoomsCreator?
        // 8. В конструкторе класса RoomsCreator используется свойство MAX_ROOMS_COUNT.
        // Чему равно его значение: 50 или 20? И почему?
        // 9. Значения каких свойств класса Building можно изменить из классов RoomsCreator, FindSecretRooms, Room?
        // 10. Можно ли из класса RoomsCreator изменить значение аргумента color, переданного в конструктор Building? Почему?
        // 11. Может ли класс Building наследоваться от класса RoomsCreator, класса FindSecretRooms или класса Room? Почему?
        // 12. Могут ли классы RoomsCreator, FindSecretRooms, Room, Color наследоваться от Building? Почему?
        // 13. Можно ли класс FindSecretRooms сделать static классом? Что для этого нужно сделать?

        // 1. В каких случаях имеет смысл создать именованный класс, реализующий java.lang.Runnable интерфейс?
        // 2. В каких случаях имеет смысл создать анонимный класс, реализующий java.lang.Runnable интерфейс?
        // 3. В каких случаях имеет смысл создать анонимный класс, реализующий java.lang.Runnable интерфейс через лямбда выражение?
        // 4. Чем локальные классы отличаются от анонимных? Что у них общего?
        // 5. Что такое effective final переменные?
        // 6. Чем отличаются static вложенные от non-static внутренних классов?
    }
}
