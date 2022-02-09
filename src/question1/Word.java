package question1;

import exception.InvalidInputException;

import java.util.*;

/**
 * @author javid
 * Created on 2/6/2022
 */
public class Word {

    private final Map<String, Set<String>> wordMap = new HashMap<>();

    boolean checkWords(String input) {
        validateToMultiWord(input);
        List<String> list = new ArrayList<>(Arrays.asList(input.split(" +")));
        String key = list.remove(0);
        Set<String> set = new HashSet<>(list);
        for (String value : set) {
            if (!checkWords(key, value))
                return false;
        }
        return true;
    }


    private boolean checkWords(String key, String value) {
        if (wordMap.containsKey(key)) {
            return wordMap.get(key).contains(value);
        }
        generate(key);
        return checkWords(key, value);
    }

    void printWords(String input) {
        if (wordMap.containsKey(input)) {
            printWords(wordMap.get(input));
            return;
        }
        generate(input);
        printWords(input);
    }

    private void printWords(Set<String> set) {
        for (String value : set) {
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    private void generate(String input) {
        validateToOneWord(input);
        Set<String> set = new HashSet<>();
        generate(input, set);
        for (String key : set) {
            wordMap.put(key, set);
        }
    }

    private void generate(String input, Set<String> set) {
        generate(input.toCharArray(), 0, input.length(), set);
    }

    private void generate(char[] input, int index, int length, Set<String> set) {
        if (index == length) {
            set.add(new String(input));
        } else {
            for (int i = index; i < length; i++) {
                swap(input, i, index);
                set.add(new String(input));
                generate(input, index + 1, length, set);
                if (index % 2 != 0) {
                    char[] input1 = Arrays.copyOf(input, length);
                    swap(input1, 0, index);
                    set.add(new String(input1));
                    generate(input, index + 1, length, set);
                }
            }
        }
    }

    private void swap(char[] input, int index1, int index2) {
        char c = input[index1];
        input[index1] = input[index2];
        input[index2] = c;
    }

    private void validateToOneWord(String word) {
        if (word.isBlank()) {
            throw new InvalidInputException("Input is empty or only contains white space!");
        }
        if (word.trim().contains(" ")) {
            throw new InvalidInputException("Mor than one word is unacceptable!");
        }
    }

    private void validateToMultiWord(String input) {
        if (input.split(" +").length < 2){
            throw new InvalidInputException("Input contains less than 2 words for checking same letters!");
        }
    }
}
