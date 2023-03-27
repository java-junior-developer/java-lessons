package ru.itmo.lessons.lesson06.books;

// не импортирует Author, тк Book и Author находятся в одном пакете
public class Book { // ru.itmo.lessons.lesson06.books.Book
    // private - доступ только из текущего класса
    private String title;
    private Author author;

    public Book(){
        System.out.println("Создается книга");
    }

    public Book(String title, Author author){
        this(); // можно вызвать другой конструктор при необходимости
        setTitle(title);
        setAuthor(author);
    }

    public Book(String title){
        setTitle(title);
    }

    // методы
    // устанавливает значение свойства title
    public void setTitle(String bookTitle){
        // проверка входящих данных
        if (bookTitle == null || bookTitle.length() < 3) {
            throw new IllegalArgumentException("title не менее 3 символов");
        }
        title = bookTitle;

        /*if (bookTitle != null && bookTitle.length() >= 3) {
            title = bookTitle;
        }*/
    }

    // устанавливает значение свойства author
    public void setAuthor(Author author){
        if (author == null) {
            throw new IllegalArgumentException("author не м.б. null");
        }
        //  this - ссылка на текущий объект
        this.author = author;
    }
    // возвращает значение свойства title
    public String getTitle(){
        return title;
    }

    // возвращает значение свойства author
    public Author getAuthor(){
        return author;
    }

}
