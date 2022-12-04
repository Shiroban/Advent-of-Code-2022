package aoc;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input3.txt"));
        int count = 0;
        int value = 0;
        int valueCapital = 26;
        int line_index = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            value++;
            map.put(ch, value);
        }
        for (char chr = 'A'; chr <= 'Z'; chr++) {
            valueCapital++;
            map.put(chr, valueCapital);
        }

        HashSet<Character> set = new HashSet<>();
        List<Character> set2 = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            final int mid = line.length() / 2;
            String fHalf = line.substring(0, mid);
            String sHalf = line.substring(mid);
            for (int i = 0; i < fHalf.length(); i++) {
                for (int j = 0; j < sHalf.length(); j++) {
                    if (!set2.isEmpty() && set2.get(set2.size() - 1) == fHalf.charAt(i)) {
                        break;
                    }
                    if (fHalf.charAt(i) == sHalf.charAt(j)) {
                        set2.add(sHalf.charAt(j));
                    }
                }
            }
            for (Character character : set2) {
                count += map.get(character);
            }
            set2.clear();
        }
        System.out.println(count);
    }
}