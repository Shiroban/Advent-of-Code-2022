package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3Pt2 {
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

        List<Character> set = new ArrayList<>();

        while (sc.hasNextLine()) {
            String elf1 = sc.nextLine();
            String elf2 = sc.nextLine();
            String elf3 = sc.nextLine();

            for (int i = 0; i < elf1.length(); i++) {
                for (int j = 0; j < elf2.length(); j++) {
                    if (elf1.charAt(i) == elf2.charAt(j)) {
                        for (int k = 0; k < elf3.length(); k++) {
                            if (!set.isEmpty() && set.get(set.size() - 1) == elf1.charAt(i)) {
                                break;
                            }
                            if (elf3.charAt(k) == elf2.charAt(j)) {
                                set.add(elf2.charAt(j));
                            }
                        }
                    }
                }
            }
            for (Character character : set) {
                count += map.get(character);
            }
            set.clear();
        }
        System.out.println(count);
    }
}