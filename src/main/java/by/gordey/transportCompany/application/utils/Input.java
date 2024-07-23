package by.gordey.transportCompany.application.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static String getString() {
        return SCANNER.nextLine();
    }
    public static String getString(String message) {
        System.out.println(message);
        return getString();
    }

    public static int getInt(){
        if (SCANNER.hasNextInt()) {
            int result = SCANNER.nextInt();
            SCANNER.nextLine(); // для затирания буфера обмена
            return result;
        }
        System.out.println("Введены некорректные данные, введи целое число");
        return getInt();
    }
    public static int getInt (String message) {
        System.out.println(message);
        return getInt();
    }

}
