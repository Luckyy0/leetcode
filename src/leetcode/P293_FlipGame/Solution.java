package leetcode.P293_FlipGame;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 293: Flip Game
     * Approach: Loop and substring
     * 
     * Theoretical Basis:
     * - Find "++", replace with "--".
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N) (output)
     */
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();
        char[] chars = currentState.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                // Flip
                chars[i] = '-';
                chars[i + 1] = '-';
                result.add(new String(chars));
                // Restore
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "++++" -> ["--++", "+--+", "++--"]
        runTest(solution, "++++");

        // "+" -> []
        runTest(solution, "+");
    }

    private static void runTest(Solution s, String str) {
        List<String> result = s.generatePossibleNextMoves(str);
        System.out.println("Input: " + str + " -> " + result);
        System.out.println("-----------------");
    }
}
