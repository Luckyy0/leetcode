package leet_code.Problem_628_Easy_Maximum_Product_of_Three_Numbers;

public class Solution_Linear {

    /**
     * Finds the maximum product of three numbers in an array.
     * Strategy: Single pass to find 3 largest and 2 smallest numbers.
     * Time: O(N), Space: O(1).
     */
    public int maximumProduct(int[] nums) {
        // Track the three largest numbers
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        // Track the two smallest numbers (could be negative)
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : nums) {
            // Update maxes
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            // Update mins
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        // Two candidates:
        // 1. Three largest numbers
        // 2. Two most negative numbers * the largest positive number
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static void main(String[] args) {
        Solution_Linear sol = new Solution_Linear();
        System.out.println("Result [1,2,3,4]: " + sol.maximumProduct(new int[] { 1, 2, 3, 4 })); // 24
        System.out.println("Result [-10,-10,1,3,2]: " + sol.maximumProduct(new int[] { -10, -10, 1, 3, 2 })); // 300
    }
}
