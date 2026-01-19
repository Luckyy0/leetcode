package leetcode.P299_BullsAndCows;

public class Solution {

    /**
     * Problem 299: Bulls and Cows
     * Approach: One pass frequency count
     * 
     * Theoretical Basis:
     * - Bulls check index match.
     * - Cows check count overlap.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls++;
            } else {
                // Determine Cows relation

                // If counts[s] < 0, it means 'guess' previously saw 's' and decremented it.
                // So now 'secret' provides 's', fulfilling the need. Cow found.
                if (numbers[s] < 0)
                    cows++;

                // If counts[g] > 0, it means 'secret' previously provided 'g' and incremented
                // it.
                // So now 'guess' needs 'g', fulfilling the provided. Cow found.
                if (numbers[g] > 0)
                    cows++;

                numbers[s]++;
                numbers[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "1807", "7810" -> "1A3B"
        runTest(solution, "1807", "7810", "1A3B");

        // "1123", "0111" -> "1A1B"
        // 1(bull)
        // Secret others: 1, 2, 3. Guess others: 0, 1, 1.
        // Overlap: 1. (Guess has two 1s, Secret has one 1. one cow).
        runTest(solution, "1123", "0111", "1A1B");
    }

    private static void runTest(Solution s, String sec, String gue, String expected) {
        String result = s.getHint(sec, gue);
        System.out.println("S: " + sec + ", G: " + gue + " -> " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
