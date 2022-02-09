package util;

import java.util.Scanner;

/**
 * @author javid
 * Created on 2/7/2022
 */
public class Screen {

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    private Screen() {
        throw new IllegalStateException("Utility class");
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static String getString(String message) {
        System.out.print(message);
        return SCANNER.nextLine().trim();
    }

    public static boolean isExit(String input) {
        if (input == null)
            return false;
        return "exit".equalsIgnoreCase(input.trim());
    }
}
