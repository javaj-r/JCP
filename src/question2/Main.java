package question2;

import util.Screen;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author javid
 * Created on 2/6/2022
 */
public class Main {
    private static SortedSet<Character> set1 = new TreeSet<>();
    private static SortedSet<Character> set2 = new TreeSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {

            if (Screen.isExit(getInput()))
                break;

            set1.clear();
            set2.clear();
            addRandomChar(set1, 10);
            addRandomChar(set2, 10);
            System.out.printf("A%nTreeSet1: %s%nTreeSet2: %s%n", set1, set2);
            if (Screen.isExit(getInput()))
                break;

            System.out.printf("B%nUnionSet: %s%n", union(set1, set2));

            flag = !Screen.isExit(getInput());

            System.out.printf("C%nIntersectSet: %s%n", intersect(set1, set2));
        }
    }

    private static String getInput() {
        String input = scanner.nextLine();
        return input.trim();
    }

    private static void addRandomChar(SortedSet<Character> set, int count) {
        int i = 0;
        while (i < count && set.size() < ('z' - 'a')) {
            char c = (char) ThreadLocalRandom.current().nextInt('a', 'z');
            if (set.contains(c))
                continue;
            set.add(c);
            i++;
        }
    }

    private static <T> SortedSet<T> union(SortedSet<T> set1, SortedSet<T> set2) {
        SortedSet<T> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }

    private static <T> SortedSet<T> intersect(SortedSet<T> set1, SortedSet<T> set2) {
        SortedSet<T> set = new TreeSet<>(set1);
        set.retainAll(set2);
        return set;
    }

}
