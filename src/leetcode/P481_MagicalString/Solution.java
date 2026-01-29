package leetcode.P481_MagicalString;

public class Solution {

    /**
     * Problem 481: Magical String
     * Approach: Simulation using two pointers
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return 1; // "122" has 1 '1'

        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1; // Current number to append (1 or 2)
        int result = 1;

        while (tail < n) {
            // How many times to append?
            for (int i = 0; i < a[head]; i++) {
                if (tail < n && num == 1)
                    result++;
                if (tail < n)
                    a[tail++] = num;
            }
            num = 3 - num; // Alternate 1 and 2
            head++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 6 -> 3
        System.out.println("Result: " + sol.magicalString(6) + " (Expected: 3)");

        // 1 -> 1
        System.out.println("Result: " + sol.magicalString(1) + " (Expected: 1)");
    }
}
