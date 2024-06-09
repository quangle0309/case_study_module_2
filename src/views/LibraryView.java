package views;

import common.ExceptionHandler;
import common.RegexHandler;
import model.Book;
import model.BookOnLoan;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryView {
    Scanner sc = new Scanner(System.in);

    private static LibraryView view;

    private LibraryView() {
    }

    public static synchronized LibraryView getLibraryView() {
        if (view == null) {
            view = new LibraryView();
        }
        return view;
    }

    public int mainStatusView() {
        System.out.println("\n=================WELCOME-TO-LIBRARY=================\n");
        System.out.println("Bạn là: ");
        System.out.println("1.\tQUẢN TRỊ VIÊN");
        System.out.println("2.\tNGƯỜI DÙNG");
        System.out.println("0.\tTHOÁT");
        int choice;
        do {
            choice = ExceptionHandler.checkChoice();
            if (choice < 0 || choice > 2) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public int adminStatusView() {
        System.out.println("\n================CHẾ-ĐỘ-QUẢN-TRỊ-VIÊN================\n");
        System.out.println("1.\tTHÊM SÁCH               5.\tXÓA SÁCH");
        System.out.println("2.\tSÁCH HIỆN TẠI           6.\tXÓA THÀNH VIÊN");
        System.out.println("3.\tSÁCH ĐANG CHO MƯỢN      7.\tTÌM SÁCH");
        System.out.println("4.\tDANH SÁCH THÀNH VIÊN    0.\tĐĂNG XUẤT");
        int choice;
        do {
            choice = ExceptionHandler.checkChoice();
            if (choice < 0 || choice > 7) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public int userStatusView() {
        System.out.println("\n==================CHẾ-ĐỘ-NGƯỜI-DÙNG==================\n");
        System.out.println("1.\tSÁCH HIỆN TẠI");
        System.out.println("2.\tMƯỢN SÁCH");
        System.out.println("3.\tTRẢ SÁCH");
        System.out.println("4.\tTÌM SÁCH");
        System.out.println("5.\tSÁCH ĐANG MƯỢN");
        System.out.println("0.\tĐĂNG XUẤT");
        int choice;
        do {
            choice = ExceptionHandler.checkChoice();
            if (choice < 0 || choice > 5) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public int userLoginView() {
        System.out.println("\n======================TÙY-CHỌN======================\n");
        System.out.println("1.\tĐĂNG NHẬP");
        System.out.println("2.\tĐĂNG KÝ");
        System.out.println("0.\tTRỞ LẠI");
        int choice;
        do {
            choice = ExceptionHandler.checkChoice();
            if (choice < 0 || choice > 2) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public String[] loginView() {
        System.out.println("\n---------------------ĐĂNG-NHẬP----------------------\n");
        System.out.print("Tên tài khoản: ");
        String username = sc.nextLine().toUpperCase();
        System.out.print("Mật khẩu: ");
        String password = sc.nextLine();
        return new String[]{username, password};
    }

    public User registerView() {
        do {
            System.out.println("\n-----------------------ĐĂNG-KÝ-----------------------\n");
            System.out.print("Tên đang nhập: ");
            String username = sc.nextLine().toUpperCase();
            if (!RegexHandler.isValidUsername(username)) {
                System.err.println("Tên đăng nhập phải là chữ cái hoặc số! (từ 6-16 ký tự!!!)\n");
                continue;
            }
            System.out.print("Mật khẩu: ");
            String password = sc.nextLine();
            if (!RegexHandler.isValidPassword(password)) {
                System.err.println("Mật khẩu phải là chữ cái và số hoặc ký tự '@'! (từ 6-16 ký tự!!!)\n");
                continue;
            }
            System.out.print("Nhập lại mật khẩu: ");
            String confirmPassword = sc.nextLine();
            if (!confirmPassword.equals(password)){
                System.err.println("Mật khẩu không khớp!!!");
                continue;
            }
            System.out.print("Họ và tên: ");
            String name = sc.nextLine().toUpperCase();
            if(!RegexHandler.isValidName(name)){
                System.err.println("Tên phải là các chữ cái!!!\n");
                continue;
            }
            System.out.print("Số điện thoại: ");
            String phoneNumber = sc.nextLine();
            if(!RegexHandler.isValidPhoneNumber(phoneNumber)){
                System.err.println("Số điện thoại không hợp lệ!!!\n");
                continue;
            }
            return new User(username, password, name, phoneNumber);

        } while (true);
    }

    public void viewLoginMessage(boolean result) {
        if (result) {
            System.out.println("\nĐăng nhập thành công!\n");
        } else {
            System.err.println("\nĐăng nhập thất bại!!!\n");
        }
    }

    public void viewRegisterMessage(boolean result) {
        if (result) {
            System.out.println("\nĐăng ký thành công!\n");
        } else {
            System.err.println("\nĐăng ký thất bại!!!\n");
        }
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("\nThao tác thành công!\n");
        } else {
            System.err.println("\nThao tác thất bại!!!\n");
        }
    }

    public Book viewAddBook() {
        do {
            System.out.println("\n------------------------THÊM-SÁCH------------------------\n");
            System.out.print("Tên sách: ");
            String name = sc.nextLine().toUpperCase();
            if (!RegexHandler.isValidString(name)) {
                System.err.println("Tên không hợp lệ!!!");
                continue;
            }
            System.out.print("Tác giả: ");
            String author = sc.nextLine().toUpperCase();
            if (!RegexHandler.isValidString(author)) {
                System.err.println("Tên không hợp lệ!!!");
                continue;
            }
            return new Book(name, author);
        } while (true);
    }

    public Book viewRemoveBook() {
        System.out.println("\n------------------------XÓA-SÁCH------------------------\n");
        System.out.print("Tên sách: ");
        String name = sc.nextLine().toUpperCase();
        System.out.print("Tác giả: ");
        String author = sc.nextLine().toUpperCase();
        return new Book(name, author);
    }

    public String viewRemoveUser() {
        System.out.println("\n---------------------XÓA-THÀNH-VIÊN---------------------\n");
        System.out.print("Nhập tên tài khoản cần xóa: ");
        return sc.nextLine().toUpperCase();
    }

    public int viewQuantityBook() {
        return ExceptionHandler.checkQuantity();
    }

    public void viewListUser(List<User> users) {
        String leftAlignFormat = "| %-15s | %-15s | %-25s | %-15s |%n";
        System.out.println("-------------------------------DANH-SÁCH-THÀNH-VIÊN-------------------------------\n");
        System.out.format("+-----------------+-----------------+---------------------------+-----------------+%n");
        System.out.format("| Tên Đăng Nhập   | Mật Khẩu        | Họ Tên                    | Số Điện Thoại   |%n");
        System.out.format("+-----------------+-----------------+---------------------------+-----------------+%n");

        for (User user : users) {
            System.out.format(leftAlignFormat, user.getUsername(), user.getPassword(), user.getName(), user.getPhoneNumber());
        }

        System.out.format("+-----------------+-----------------+---------------------------+-----------------+%n");
    }

    public void viewListBook(HashMap<Book, Integer> bookMap) {
        String leftAlignFormat = "| %-40s | %-25s | %-10s |%n";
        System.out.println("------------------------------------SÁCH-HIỆN-TẠI-----------------------------------\n");
        System.out.format("+------------------------------------------+---------------------------+------------+%n");
        System.out.format("| Tên Sách                                 | Tên Tác Giả               | Số Lượng   |%n");
        System.out.format("+------------------------------------------+---------------------------+------------+%n");

        for (Book key: bookMap.keySet()) {
            Integer value = bookMap.get(key);
            System.out.format(leftAlignFormat, key.getName(), key.getAuthor(), value);
        }

        System.out.format("+------------------------------------------+---------------------------+------------+%n");
    }

    public int viewFindBook() {
        System.out.println("\n======================TÌM-SÁCH======================\n");
        System.out.println("1.\tTÌM THEO TÊN");
        System.out.println("2.\tTÌM THEO TÁC GIẢ");
        System.out.println("0.\tTRỞ LẠI");
        int choice;
        do {
            choice = ExceptionHandler.checkChoice();
            if (choice < 0 || choice > 2) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public String viewFindByName() {
        System.out.print("\nNhập tên sách cần tìm: ");
        return sc.nextLine().toUpperCase();
    }

    public String viewFindByAuthor() {
        System.out.print("\nNhập tên tác giả cần tìm: ");
        return sc.nextLine().toUpperCase();
    }

    public boolean viewConfirmRemove() {
        do {
            System.out.println("Bạn có chắc muốn xóa? (nhấn Y để đồng ý xóa, nhấn N để hủy thao tác xóa!)");
            String confirm = sc.nextLine();
            confirm = confirm.toUpperCase();
            if (confirm.equals("Y")) {
                return true;
            } else if (confirm.equals("N")) {
                return false;
            } else {
                System.err.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    public void viewMessageCancel() {
        System.out.println("Đã hủy thao tác!");
    }

    public String viewBorrowBook() {
        System.out.println("\n------------------------MƯỢN-SÁCH------------------------\n");
        System.out.print("Nhập tên sách cần mượn: ");
        return sc.nextLine().toUpperCase();
    }

    public String viewReturnBook() {
        System.out.println("\n------------------------TRẢ-SÁCH-------------------------\n");
        System.out.print("Nhập tên sách cần trả: ");
        return sc.nextLine().toUpperCase();
    }

    public void viewListBookOnLoan(HashMap<BookOnLoan, Integer> bookMap) {
        String leftAlignFormat = "| %-20s | %-35s | %-20s | %-10s |%n";
        System.out.println("----------------------------------------SÁCH-ĐANG-CHO-MƯỢN---------------------------------------\n");
        System.out.format("+----------------------+-------------------------------------+----------------------+------------+%n");
        System.out.format("| Tên Người Mượn       | Tên Sách                            | Tên Tác Giả          |Số Lượng    |%n");
        System.out.format("+----------------------+-------------------------------------+----------------------+------------+%n");

        for (BookOnLoan key: bookMap.keySet()) {
            Integer value = bookMap.get(key);
            System.out.format(leftAlignFormat, key.getUsernameBorrow(), key.getNameBookBorrow(),key.getAuthorBookBorrow(), value);
        }

        System.out.format("+----------------------+-------------------------------------+----------------------+------------+%n");
    }

}
