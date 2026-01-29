package leetcode.P1585_CheckIfStringIsTransformableWithSubstringSortOperations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean isTransformable(String s, String t) {
        List<Deque<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            indices.add(new ArrayDeque<>());
        }

        // Store indices of each digit in s
        for (int i = 0; i < s.length(); i++) {
            indices.get(s.charAt(i) - '0').add(i);
        }

        for (int i = 0; i < t.length(); i++) {
            int digit = t.charAt(i) - '0';

            // If no such digit available in s
            if (indices.get(digit).isEmpty()) {
                return false;
            }

            int currentPos = indices.get(digit).peek();

            // Check if any smaller digit is blocking this digit
            // A smaller digit blocks if it appears before the current digit
            for (int small = 0; small < digit; small++) {
                if (!indices.get(small).isEmpty() && indices.get(small).peek() < currentPos) {
                    return false;
                }
            }

            // Use this digit
            indices.get(digit).poll();
        }

        return true;
    }
}
