package model;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private int id;
    public Book() {};

    public Book(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Name: " + name + ", author: " + author + ", publisher: " + publisher;
    }
}
