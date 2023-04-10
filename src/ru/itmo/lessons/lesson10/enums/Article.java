package ru.itmo.lessons.lesson10.enums;

public class Article {
    private String name;
    private Country country; // null

    // ... остальные свойства

    public Article(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}