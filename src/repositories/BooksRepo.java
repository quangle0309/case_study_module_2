package repositories;

import model.Book;

import java.io.*;
import java.util.HashMap;


public class BooksRepo {
    private static BooksRepo booksRepo;
    private final String SRC_FILE_BOOK = "src/data/books.dat";

    private BooksRepo() {
    }

    public static synchronized BooksRepo getBooksRepo() {
        if (booksRepo == null) {
            booksRepo = new BooksRepo();
        }
        return booksRepo;
    }

    public void add(Book book, int quantity) {
        HashMap<Book, Integer> bookMap = getAll();
        if (bookMap.containsKey(book)) {
            bookMap.put(book, bookMap.get(book) + quantity);
        } else {
            bookMap.put(book, quantity);
        }
        writeFile(bookMap);
    }

    private void writeFile(HashMap<Book, Integer> bookMap) {
        try (
                FileOutputStream fos = new FileOutputStream(SRC_FILE_BOOK);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(bookMap);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file!!!");
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<Book, Integer> getAll() {
        HashMap<Book, Integer> bookMap = new HashMap<>();
        try (
                FileInputStream fis = new FileInputStream(SRC_FILE_BOOK);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            bookMap = (HashMap<Book, Integer>) ois.readObject();
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi đọc file!!!");
        }
        return bookMap;
    }

    public boolean remove(Book book, int quantity) {
        HashMap<Book, Integer> bookMap = getAll();
        Integer value;
        for (Book key : bookMap.keySet()) {
            value = bookMap.get(key);
            if (key.equals(book)) {
                if (value > quantity) {
                    bookMap.put(key, value - quantity);
                    writeFile(bookMap);
                    return true;
                } else if (value == quantity) {
                    bookMap.remove(key);
                    writeFile(bookMap);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public HashMap<Book, Integer> findByName(String name) {
        HashMap<Book, Integer> bookMap = getAll();
        HashMap<Book, Integer> result = new HashMap<>();
        for (Book key : bookMap.keySet()) {
            if (key.getName().equals(name)) {
                result.put(key, bookMap.get(key));
            }
        }
        return result;
    }

    public HashMap<Book, Integer> findByAuthor(String author) {
        HashMap<Book, Integer> bookMap = getAll();
        HashMap<Book, Integer> result = new HashMap<>();
        for (Book key : bookMap.keySet()) {
            if (key.getAuthor().equals(author)) {
                result.put(key, bookMap.get(key));
            }
        }
        return result;
    }
}
