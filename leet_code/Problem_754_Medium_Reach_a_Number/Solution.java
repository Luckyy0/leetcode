package leet_code.Problem_754_Medium_Reach_a_Number;

public class Solution {

    /**
     * Finds min moves to reach target.
     * Strategy: Mathematical simulation based on sum of first k integers.
     * Time: O(sqrt(target)), Space: O(1).
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        int sum = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            k++;
            sum += k;
        }

        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.reachNumber(2)); // 3
        System.out.println("Result 2: " + sol.reachNumber(3)); // 2
        System.out.println("Result 3: " + sol.reachNumber(-2)); // 3
    }
}
