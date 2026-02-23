package leet_code.Problem_334_Medium_Increasing_Triplet_Subsequence;

public class Solution_Greedy {

    /**
     * Checks if increasing triplet exists.
     * Uses Two Thresholds strategy.
     * Time: O(N), Space: O(1).
     * 
     * Kiểm tra xem có tồn tại bộ ba tăng dần không.
     * Sử dụng chiến lược Hai Ngưỡng.
     */
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            // Found smaller 'first' element
            // Tìm thấy phần tử 'first' nhỏ hơn
            if (n <= first) {
                first = n;
            }
            // Found number bigger than 'first' but smaller than 'second'
            // Tìm thấy số lớn hơn 'first' nhưng nhỏ hơn 'second'
            else if (n <= second) {
                second = n;
            }
            // Found number bigger than both
            // Tìm thấy số lớn hơn cả hai
            else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [1,2,3,4,5] -> true
        int[] n1 = { 1, 2, 3, 4, 5 };
        System.out.println("Result 1: " + solution.increasingTriplet(n1));

        // Test Case 2: [5,4,3,2,1] -> false
        int[] n2 = { 5, 4, 3, 2, 1 };
        System.out.println("Result 2: " + solution.increasingTriplet(n2));

        // Test Case 3: [2,1,5,0,4,6] -> true
        int[] n3 = { 2, 1, 5, 0, 4, 6 };
        System.out.println("Result 3: " + solution.increasingTriplet(n3));
    }
}
