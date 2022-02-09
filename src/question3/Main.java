package question3;

import util.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author javid
 * Created on 2/7/2022
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        while (true) {
        List<Integer> integers = new ArrayList<>();
        removeImproperlyPairs(integers);
        System.out.println(integers);
        getNumbers(integers);
        removeImproperlyPairs(integers);
        System.out.println(integers);

//            scanner.nextLine();
//        }
    }

    private static void removeImproperlyPairs(List<Integer> integers) {
        int size = integers.size();
        if (size > 0 && size % 2 != 0)
            integers.remove(--size);

        if (size < 2)
            return;

        boolean flag;
        for (int i = 0; i < integers.size(); i += flag ? 0 : 2) {
            flag = integers.get(i) > integers.get(i + 1);
            if (flag) {
                integers.remove(i);
                integers.remove(i);
            }
        }
    }

    private static void getNumbers(List<Integer> integers) {
        while (true) {
            try {
                Screen.print("Enter numbers seperated by spase: ");
                String[] stringNumbers = scanner.nextLine().trim().split(" +");
                for (String n : stringNumbers) {
                    integers.add(Integer.parseInt(n));
                }
                break;
            } catch (NumberFormatException e) {
                Screen.println("Just enter numbers.\nTry again.");
            } catch (Exception e) {
                Screen.println(e.getMessage());
            }
        }
    }

}
