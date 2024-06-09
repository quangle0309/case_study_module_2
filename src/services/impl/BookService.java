package services.impl;

import model.Book;
import repositories.impl.BooksRepo;
import views.LibraryView;

import java.util.HashMap;

public class BookService {
    BooksRepo booksRepo = BooksRepo.getBooksRepo();
    LibraryView view = LibraryView.getLibraryView();

    private static BookService bookService;

    private BookService() {
    }

    public static synchronized BookService getBookService() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public void add(Book book, Integer quantity) {
        booksRepo.add(book, quantity);
    }

    public HashMap<Book, Integer> getAll() {
        return booksRepo.getAll();
    }

    public boolean remove(Book book, Integer quantity) {
        return booksRepo.remove(book, quantity);
    }

    public void findByName(String name) {
        HashMap<Book, Integer> books = booksRepo.findByName(name);
        if (!books.isEmpty()) {
            view.viewListBook(books);
        } else {
            System.err.println("Không tìm thấy sách cần tìm!\n");
        }
    }

    public void findByAuthor(String author) {
        HashMap<Book, Integer> books = booksRepo.findByAuthor(author);
        if (!books.isEmpty()) {
            view.viewListBook(books);
        } else {
            System.err.println("Không tìm thấy sách cần tìm!\n");
        }
    }

    public Book getBookByName(HashMap<Book, Integer> bookMap, String name) {
        for (Book key: bookMap.keySet()) {
            if (key.getName().equals(name)) {
                return key;
            }
        }
        return null;
    }
}
