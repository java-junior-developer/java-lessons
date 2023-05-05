package ru.itmo.lessons.lesson21.task03;

abstract public class Action {
    private Action nextAction;

    public void /* Action */ nextAction(Action nextAction) {
        this.nextAction = nextAction;
        /* return this; */
    }

    public void doAction(){
        execute();
        if (nextAction != null) nextAction.doAction();
    }

    abstract void execute();
}


