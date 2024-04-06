package org.me.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> magazineLetters = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            int currentCount = magazineLetters.getOrDefault(m, 0);
            magazineLetters.put(m, ++currentCount);
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            char r = ransomNote.charAt(j);
            int currentCount = magazineLetters.getOrDefault(r, 0);

            if (currentCount == 0) {
                return false;
            }

            magazineLetters.put(r, --currentCount);
        }
        return true;
    }

    public int numberOfSteps(int num) {
        int counter = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num--;
            }
            counter++;
        }
        return counter;
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        IntStream.range(1, n + 1).forEach(i -> {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                result.add("FizzBuzz");
            } else if ((i % 3 == 0) && (i % 5 != 0)) {
                result.add("Fizz");
            } else if ((i % 3 != 0) && (i % 5 == 0)) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        });
        return result;
    }
}
