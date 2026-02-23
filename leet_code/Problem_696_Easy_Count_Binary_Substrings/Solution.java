package leet_code.Problem_696_Easy_Count_Binary_Substrings;

public class Solution {

    /**
     * Counts binary substrings with equal number of grouped 0s and 1s.
     * Strategy: Single pass tracking current and previous group lengths.
     * Time: O(N), Space: O(1).
     */
    public int countBinarySubstrings(String s) {
        int counts = 0;
        int prev = 0; // Length of previous consecutive group
        int curr = 1; // Length of current consecutive group

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // Same character, increase current group size
                curr++;
            } else {
                // Character change: add the overlap and reset
                counts += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        // Final addition for the last pair of groups
        counts += Math.min(prev, curr);

        return counts;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (00110011): " + sol.countBinarySubstrings("00110011")); // 6
        System.out.println("Result (10101): " + sol.countBinarySubstrings("10101")); // 4
    }
}
