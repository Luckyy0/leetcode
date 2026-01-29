package leetcode.P1796_SecondLargestDigitInAString;

import java.util.Collections;
import java.util.TreeSet;

public class Solution {
    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(c - '0');
            }
        }

        if (set.size() < 2)
            return -1;
        set.pollLast(); // Remove largest
        return set.last(); // Second largest
    }
}
