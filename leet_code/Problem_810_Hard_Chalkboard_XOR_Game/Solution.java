package leet_code.Problem_810_Hard_Chalkboard_XOR_Game;

public class Solution {

    /**
     * Determines if Alice wins the XOR game.
     * Strategy: Alice wins if initial XOR is 0 OR if the number of elements is
     * even.
     * Time: O(N), Space: O(1).
     */
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        // Alice wins if:
        // 1. Initial XOR sum is already 0
        // 2. The number of elements is even (she can always find an element to pick
        // that won't make XOR 0)
        return xor == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = { 1, 1, 2 };
        System.out.println("Result 1: " + sol.xorGame(n1)); // false

        int[] n2 = { 0, 1 };
        System.out.println("Result 2: " + sol.xorGame(n2)); // true
    }
}
