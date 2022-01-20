package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public Book() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {             // проверим есть ли поисковое слово в данных о названии
            return true;
        }
        if (getAuthor().contains(search)) {      // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;
    }

}
