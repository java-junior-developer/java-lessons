package ru.itmo.lessons.lesson22.strategy;

// использует определенное действие и
// может заменить его другим во время выполнения программы
public class Unit {
    private IAction<Unit> currentAction;

    public Unit(IAction<Unit> currentAction) {
        this.currentAction = currentAction;
    }

    public void changeAction(IAction<Unit> currentAction) {
        this.currentAction = currentAction;
    }

    public void move(){
       currentAction.execute(this);
    }

    // вместо метода void move()
    // можно использовать метод move(IAction<Unit> currentAction)
    // и не хранить ссылку на IAction
    public void move(IAction<Unit> currentAction) {
        currentAction.execute(this);
    }

    static IAction<Unit> getUnitAction(Type type){ // фабричный метод, создающий действия юнитов
        return switch (type) {
            case RUN -> new Run();
            case STOP -> new Stop();
            case WALK -> new Walk();
            default -> throw new IllegalArgumentException("Передан неверный тип механики юнита");
        };
    }

    public enum Type {
        RUN, STOP, WALK
    }
}
