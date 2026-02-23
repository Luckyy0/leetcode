package leet_code.Problem_771_Easy_Jewels_and_Stones;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Counts how many stones are jewels.
     * Strategy: Use a Set for O(1) lookups.
     * Time: O(J + S), Space: O(J).
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();

        // Populate the set with jewel types
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        // Check each stone
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println("Result 2: " + sol.numJewelsInStones("z", "ZZ")); // 0
    }
}
