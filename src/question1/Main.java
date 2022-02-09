package question1;


import exception.InvalidInputException;

import java.util.*;

/**
 * @author javid
 * Created on 2/6/2022
 */
public class Main {



    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        Word word = new Word();
        printHelp();
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                if (input.equalsIgnoreCase("exit"))
                    break;
                else if (input.equalsIgnoreCase("help"))
                    printHelp();
                else if (input.split(" +").length == 1)
                    word.printWords(input);
                else
                    System.out.println(word.checkWords(input) ? "Pass" : "Fail");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.print("""
                Commands:
                        exit to stop
                        help to print commands
                        One word to generate words
                        Tow words to check if contain same letters
                """);
    }
}
