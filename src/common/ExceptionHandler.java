package common;

import java.util.Scanner;

public class ExceptionHandler {
    static Scanner sc = new Scanner(System.in);

    public static int checkChoice() {
        int value;
        while (true) {
            try {
                System.out.println("Nhập vào lựa chọn: ");
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng!!!\n");
            }
        }
        return value;
    }

    public static int checkQuantity() {
        int value;
        while (true) {
            try {
                System.out.print("Nhập vào số lượng: ");
                value = Integer.parseInt(sc.nextLine());
                if (value > 0 && value <= 100) {
                    break;
                } else {
                    System.err.println("Số lượng phải lớn hơn 0 và tối đa là 100!!!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng!!!\n");
            }
        }
        return value;
    }
}
