package ru.itmo.lessons.lesson13.bounded;

abstract public class Vehicle implements Repairable{
    protected int wearLevel;
    protected String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public int getWearLevel() {
        return wearLevel;
    }

    public void changeNumber(String newNumber) {
        number = newNumber;
    }

    public void upWearLevel(int count){
        wearLevel += count;
    }

    @Override
    public void repair() {
        if (wearLevel > 0) {
            wearLevel--;
            System.out.println("Транспорт №" + number + " отремонтировано");
        }
    }
}
