package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day2Pt2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input2.txt"));
        int score = 0;
        int win = 6;
        int draw = 3;
        int lose = 0;

        HashMap<List<String>, Integer> outcomes = new HashMap<>();
        outcomes.put(List.of("A", "X"), lose + 3);
        outcomes.put(List.of("B", "X"), lose + 1);
        outcomes.put(List.of("C", "X"), lose + 2);
        outcomes.put(List.of("A", "Y"), draw + 1);
        outcomes.put(List.of("B", "Y"), draw + 2);
        outcomes.put(List.of("C", "Y"), draw + 3);
        outcomes.put(List.of("A", "Z"), win + 2);
        outcomes.put(List.of("B", "Z"), win + 3);
        outcomes.put(List.of("C", "Z"), win + 1);

        ArrayList<List<String>> inputs = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            inputs.add(List.of(input));
        }

        for (List<String> input : inputs) {
            score += outcomes.get(input);
        }

        System.out.println(score);
    }

}