package ru.itmo.lessons.lesson22.observer;

public class Observer {

    public static void main(String[] args) {
        // Наблюдатель создаёт механизм подписки, позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
        // 1. у всех подписчиков должен быть общий тип данных (абстрактный класс или интерфейс) - Listener
        // 2. абстрактном классе или интерфейсе предполагается наличие абстрактного метода
        // (или нескольких абстрактных методов) - void execute(Connection connection);
        // 3. конкретные реализации (классы, описывающие наблюдателей) интерфейса или
        // наследники абстрактного класса должны реализовать абстрактные методы (действия - реакции на изменения в других объектах)
        // 4. экземпляры наблюдателей собираются в коллекцию объекта, за которым они наблюдают - ArrayList<Listener> listeners в классе Connection
        // 4.1 должна быть реализована возможность добавления наблюдателя в коллекцию и удаление из нее
        // 5. при изменении состояния наблюдаемого объекта неоходимо вызвать метод,
        // который обойдет коллекцию наблюдателей
        // и сообщит каждому о произошедших изменениях (вызов метода(ов), объявленных в интерфейсе) - changeStatus в классе Connection

        // объект за которым наблюдают
        Connection connection = new Connection();

        // наблюдатели
        Listener ping = c -> System.out.println("проверка ping");
        Listener emailSender = c -> System.out.println("отправка сообщений на почту");
        Listener logger = new AppLogger();
        Listener smsSender = new MessageSender();

        // механизм подписки
        connection.addListener(ping);
        connection.addListener(emailSender);
        connection.addListener(logger);
        connection.addListener(smsSender);

        // изменение состояния объекта, уведомление подписчиков
        connection.changeStatus(Connection.Status.ACTIVE);
        connection.changeStatus(Connection.Status.CLOSE);
    }
}
