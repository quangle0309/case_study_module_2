package views;

import common.ExceptionHandler;
import model.User;

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
            choice = ExceptionHandler.checkParseInteger();
            if (choice < 0 || choice > 2) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public int adminStatusView() {
        System.out.println("\n================CHẾ-ĐỘ-QUẢN-TRỊ-VIÊN================\n");
        System.out.println("1.\tTHÊM SÁCH               5.\tXÓA");
        System.out.println("2.\tSÁCH HIỆN TẠI           6.\tDANH SÁCH THÀNH VIÊN");
        System.out.println("3.\tSÁCH ĐANG CHO MƯỢN      7.\tTÌM KIẾM");
        System.out.println("4.\tCHỈNH SỬA               0.\tQUAY VỀ MENU CHÍNH");
        int choice;
        do {
            choice = ExceptionHandler.checkParseInteger();
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
        System.out.println("2.\tTHUÊ SÁCH");
        System.out.println("3.\tTRẢ SÁCH");
        System.out.println("4.\tTÌM KIẾM");
        System.out.println("0.\tĐĂNG XUẤT");
        int choice;
        do {
            choice = ExceptionHandler.checkParseInteger();
            if (choice < 0 || choice > 4) {
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
            choice = ExceptionHandler.checkParseInteger();
            if (choice < 0 || choice > 2) {
                System.err.println("Lựa chọn không khả dụng!!!\n");
            } else {
                return choice;
            }
        } while (true);
    }

    public String[] loginView() {
        System.out.println("\n=====================ĐĂNG-NHẬP=====================\n");
        System.out.print("Tên tài khoản: ");
        String username = sc.nextLine();
        System.out.print("\nMật khẩu: ");
        String password = sc.nextLine();
        return new String[]{username, password};
    }

    public User registerView() {
        do {
            System.out.println("\n=====================ĐĂNG-KÝ=====================\n");
            System.out.print("Tên đăng nhập: ");
            String username = sc.nextLine();
            System.out.print("\nMật khẩu: ");
            String password = sc.nextLine();
            System.out.print("\nNhập lại mật khẩu: ");
            String confirmPassword = sc.nextLine();
            System.out.print("\nHọ và tên: ");
            String name = sc.nextLine();
            long phoneNumber;
            while (true) {
                try {
                    System.out.print("\nSố điện thoại: ");
                    phoneNumber = Long.parseLong(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Số điện thoại là số");
                }
            }
            if (confirmPassword.equals(password)) {
                return new User(username, password, name, phoneNumber);
            }
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
}
