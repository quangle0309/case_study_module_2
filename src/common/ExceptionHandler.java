package common;

import java.util.Scanner;

public class ExceptionHandler {
    static Scanner sc = new Scanner(System.in);

    public static int checkParseInteger() {
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
}
