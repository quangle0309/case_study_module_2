package services.impl;

import model.Book;
import model.BookOnLoan;
import repositories.impl.BookOnLoanRepo;
import views.LibraryView;

import java.util.HashMap;

public class BookOnLoanService {
    private static BookOnLoanService bookOnLoanService;

    private BookOnLoanService() {
    }

    public static synchronized BookOnLoanService getBookOnLoanService() {
        if (bookOnLoanService == null) {
            bookOnLoanService = new BookOnLoanService();
        }
        return bookOnLoanService;
    }

    LibraryView view = LibraryView.getLibraryView();
    BookOnLoanRepo bookOnLoanRepo = BookOnLoanRepo.getBookOnLoanRepo();

    public void add(BookOnLoan bookOnLoan, Integer quantity) {
        bookOnLoanRepo.add(bookOnLoan, quantity);
    }

    public HashMap<BookOnLoan, Integer> getAll() {
        return bookOnLoanRepo.getAll();
    }

    public boolean remove(BookOnLoan bookOnLoan, Integer quantity) {
        return bookOnLoanRepo.remove(bookOnLoan, quantity);
    }

    public BookOnLoan getBookOnLoanByName(HashMap<BookOnLoan, Integer> bookOnLoanMap, String name) {
        for (BookOnLoan key: bookOnLoanMap.keySet()) {
            if (key.getNameBookBorrow().equals(name)) {
                return key;
            }
        }
        return null;
    }

    public void findByUserName(String name) {
        HashMap<BookOnLoan, Integer> bookOnLoanMap = bookOnLoanRepo.findByUserName(name);
        if (!bookOnLoanMap.isEmpty()) {
            view.viewListBookOnLoan(bookOnLoanMap);
        } else {
            System.err.println("Không tìm thấy sách cần tìm!\n");
        }
    }
}
