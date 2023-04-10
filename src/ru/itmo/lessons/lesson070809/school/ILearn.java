package ru.itmo.lessons.lesson070809.school;

public interface ILearn {
    // могут содержать константы
    // могут содержать static методы c реализацией
    // могут содержать методы с реализацией, если они отмечены, как default
    default public void defaultLearning(){
        System.out.println("Обучение...");
    }
    // могут содержать методы без реализации (абстрактные)
    // должны быть реализованы в расширяющем не abstract классе
    public void learn(int level);

    // нельзя создать экземпляр интерфейса
    // интерфес может наследоваться от другого интерфейса
    // разрешено множественное наследовние интерфейсов
    // interface A extends B, C, X {}
}
