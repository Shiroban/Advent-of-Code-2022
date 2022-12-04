package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        int answer;
        int current = 0;
        Scanner InputScan = new Scanner(new File("input1.txt"));

        ArrayList<Integer> al = new ArrayList<>();

        while (InputScan.hasNextLine()) {
            String line = InputScan.nextLine();
            if (line.length() == 0) {
                al.add(current);
                current = 0;
            } else current += Integer.parseInt(line);
        }
        al.add(current);
        al.sort(Collections.reverseOrder());
        answer = al.get(0) + al.get(1) + al.get(2);
        System.out.println(answer);
    }
}