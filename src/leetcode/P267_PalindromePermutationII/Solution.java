package leetcode.P267_PalindromePermutationII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 267: Palindrome Permutation II
     * Approach: Permute Half String
     * 
     * Theoretical Basis:
     * - Generate half of the palindrome, then mirror it.
     * - Handle duplicates carefully during permutation.
     * 
     * Time Complexity: Factorial
     * Space Complexity: O(N)
     */
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> counts = new HashMap<>();

        // 1. Count frequencies
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // 2. Validate and build half string
        List<Character> half = new ArrayList<>();
        String mid = "";
        int oddCount = 0;

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (count % 2 == 1) {
                oddCount++;
                mid = String.valueOf(c);
            }

            for (int i = 0; i < count / 2; i++) {
                half.add(c);
            }
        }

        if (oddCount > 1) {
            return result; // Impossible
        }

        // 3. Permute half string
        boolean[] used = new boolean[half.size()];
        // Backtracking needs sorting for duplicate handling? Or use map backtracking?
        // Converting to array and sorting is easier for standard "permutations II"
        // logic.
        char[] halfArr = new char[half.size()];
        for (int i = 0; i < half.size(); i++)
            halfArr[i] = half.get(i);
        java.util.Arrays.sort(halfArr);

        backtrack(halfArr, used, new StringBuilder(), result, mid);

        return result;
    }

    private void backtrack(char[] halfArr, boolean[] used, StringBuilder cur, List<String> result, String mid) {
        if (cur.length() == halfArr.length) {
            // Combine: left + mid + right(reverse left)
            result.add(cur.toString() + mid + cur.reverse().toString());
            cur.reverse(); // Restore StringBuilder state for backtracking (important!)
            return;
        }

        for (int i = 0; i < halfArr.length; i++) {
            if (used[i])
                continue;
            // Skip duplicates: if same as prev and prev not used, skip
            if (i > 0 && halfArr[i] == halfArr[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            cur.append(halfArr[i]);
            backtrack(halfArr, used, cur, result, mid);
            cur.deleteCharAt(cur.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "aabb" -> ["abba", "baab"]
        runTest(solution, "aabb");

        // "abc" -> []
        runTest(solution, "abc");
    }

    private static void runTest(Solution s, String str) {
        List<String> result = s.generatePalindromes(str);
        System.out.println("Input: " + str + " -> " + result);
        System.out.println("-----------------");
    }
}
