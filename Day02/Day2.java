package aoc;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input2.txt"));
        int score = 0;
        int win = 6;
        int draw = 3;
        int lose = 0;

        HashMap<String, Integer> userscore = new HashMap<>();
        userscore.put("X", 1);
        userscore.put("Y", 2);
        userscore.put("Z", 3);

        HashMap<List<String>, Integer> outcome = new HashMap<>();
        outcome.put(List.of("A", "Y"), win);
        outcome.put(List.of("B", "Z"), win);
        outcome.put(List.of("C", "X"), win);
        outcome.put(List.of("A", "X"), draw);
        outcome.put(List.of("B", "Y"), draw);
        outcome.put(List.of("C", "Z"), draw);
        outcome.put(List.of("B", "X"), lose);
        outcome.put(List.of("C", "Y"), lose);
        outcome.put(List.of("A", "Z"), lose);

        ArrayList<List<String>> inputs = new ArrayList<>();
        List<String> half_inputs = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            char user = line.charAt(2);
            String half_input = Character.toString(user);
            half_inputs.add(half_input);
            String[] input = line.split(" ");
            inputs.add(List.of(input));
        }

        for (List<String> input : inputs) {
            score += outcome.get(input);
        }

        for (String halfInput : half_inputs) {
            score += userscore.get(halfInput);
        }

        System.out.println(score);
    }
}