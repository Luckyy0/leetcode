package leetcode.P1805_NumberOfDifferentIntegersInAString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDifferentIntegers(String word) {
        String[] parts = word.replaceAll("[a-z]+", " ").split(" ");
        Set<String> set = new HashSet<>();

        for (String p : parts) {
            if (p.isEmpty())
                continue;
            // Remove leading zeros
            String clean = p.replaceFirst("^0+(?!$)", "");
            // Handle all zeros case "000" -> "0"
            // The regex ^0+(?!$) removes leading zeros unless string is just "0" or "00".
            // Actually simpler: iterate find first non-zero.

            // Manual clean
            int i = 0;
            while (i < p.length() - 1 && p.charAt(i) == '0') {
                i++;
            }
            set.add(p.substring(i));
        }

        return set.size();
    }
}
