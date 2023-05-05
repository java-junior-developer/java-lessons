package ru.itmo.lessons.lesson22.chain;

abstract public class Action {
    private Action nextAction;

    public void /* Action */ nextAction(Action nextAction) {
        this.nextAction = nextAction;
        /* return this; */
    }

    public void doAction(){
        execute();
        if (nextAction != null) nextAction.doAction(); // возможны варианты, когда метод следующего в цепочке обработчика,
        // вызывается только при определенных условиях, а не только при наличии ссылки
    }

    abstract void execute();
}


