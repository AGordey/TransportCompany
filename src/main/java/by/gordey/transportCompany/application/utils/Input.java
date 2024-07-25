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

    public static double getDouble() {
        if (SCANNER.hasNextDouble()) {
            double result = SCANNER.nextDouble();
            SCANNER.nextLine(); // для затирания буфера обмена
            return result;
        }
        System.out.println("Введены некорректные данные, введи число типа double");
        return getDouble();
    }

    public static double getDouble (String message) {
        System.out.println(message);
        return getDouble();
    }

    public static boolean getBoolean() {
        if (SCANNER.hasNextBoolean()) {
            boolean result = SCANNER.nextBoolean();
            SCANNER.nextLine(); // для затирания буфера обмена
            return result;
        }
        System.out.println("Введены некорректные данные, введи true или false");
        return getBoolean();
    }

    public static boolean getBoolean (String message) {
        System.out.println(message);
        return getBoolean();
    }
}
