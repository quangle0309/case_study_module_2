package repositories;

import model.BookOnLoan;

import java.io.*;
import java.util.HashMap;

public class BookOnLoanRepo {
    private static BookOnLoanRepo bookOnLoanRepo;
    private final String SRC_FILE_BOOK_ON_LOAN = "src/data/bookOnLoan.dat";

    private BookOnLoanRepo() {
    }

    public static synchronized BookOnLoanRepo getBookOnLoanRepo() {
        if (bookOnLoanRepo == null) {
            bookOnLoanRepo = new BookOnLoanRepo();
        }
        return bookOnLoanRepo;
    }

    private void writeFile(HashMap<BookOnLoan, Integer> bookOnLoans) {
        try (
                FileOutputStream fos = new FileOutputStream(SRC_FILE_BOOK_ON_LOAN);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(bookOnLoans);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file!!!");
        }
    }

    public void add(BookOnLoan bookOnLoan, int quantity) {
        HashMap<BookOnLoan, Integer> bookOnLoanMap = getAll();
        if (bookOnLoanMap.containsKey(bookOnLoan)) {
            bookOnLoanMap.put(bookOnLoan, bookOnLoanMap.get(bookOnLoan) + quantity);
        } else {
            bookOnLoanMap.put(bookOnLoan, quantity);
        }
        writeFile(bookOnLoanMap);
    }

    @SuppressWarnings("unchecked")
    public HashMap<BookOnLoan, Integer> getAll() {
        HashMap<BookOnLoan, Integer> bookOnLoanMap = new HashMap<>();
        try (
                FileInputStream fis = new FileInputStream(SRC_FILE_BOOK_ON_LOAN);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            bookOnLoanMap = (HashMap<BookOnLoan, Integer>) ois.readObject();
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi đọc file!!!");
        }
        return bookOnLoanMap;
    }

    public boolean remove(BookOnLoan bookOnLoan, int quantity) {
        HashMap<BookOnLoan, Integer> bookOnLoanMap = getAll();
        Integer value;
        for (BookOnLoan key : bookOnLoanMap.keySet()) {
            value = bookOnLoanMap.get(key);
            if (key.equals(bookOnLoan)) {
                if (value > quantity) {
                    bookOnLoanMap.put(key, value - quantity);
                    writeFile(bookOnLoanMap);
                    return true;
                } else if (value == quantity) {
                    bookOnLoanMap.remove(key);
                    writeFile(bookOnLoanMap);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public HashMap<BookOnLoan, Integer> findByUserName(String username) {
        HashMap<BookOnLoan, Integer> bookOnLoanMap = getAll();
        HashMap<BookOnLoan, Integer> result = new HashMap<>();
        for (BookOnLoan key : bookOnLoanMap.keySet()) {
            if (key.getUsernameBorrow().equals(username)) {
                result.put(key, bookOnLoanMap.get(key));
            }
        }
        return result;
    }
}
