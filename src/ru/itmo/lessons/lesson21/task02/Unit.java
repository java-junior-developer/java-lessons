package ru.itmo.lessons.lesson21.task02;

// если объект совершает разные действия, которые меняются во время выполнения программы,
// принято описывать каждое действие в отдельном классе
// все действия должны иметь общий тип: интерфейс или абстрактный класс
// в интерфейсе или абстрактном классе дб минимум один абстрактный метод
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
}
