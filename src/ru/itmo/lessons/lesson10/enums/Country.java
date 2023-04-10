package ru.itmo.lessons.lesson10.enums;

// enum - набор логически связанных констант
// каждый элемент перечисления final и static
// во время выполнения программы в enum нельзя добавлять элементы,
// из enum нельзя удалять элементы,
// в enum нельзя заменять элементы
// элементы перечисления хранятся в массиве в порядке их объявления
// Country[] -> [UK, USA, FRANCE]
public enum Country {
    UK, USA, FRANCE // элементы перечисления, экземпляры типа Country
}



/*
public class Article{
    private Country country;

    public enum Country {
        UK, USA, FRANCE // элементы перечисления, экземпляры типа Country
    }
}

доступ к перечислению, если оно объявлено внутри класса
Article.Country.UK

*/
