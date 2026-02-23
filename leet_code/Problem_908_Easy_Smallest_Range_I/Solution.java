package leet_code.Problem_908_Easy_Smallest_Range_I;

/**
 * Problem 908: Smallest Range I
 * https://leetcode.com/problems/smallest-range-i/
 */
public class Solution {

    /**
     * Calculates the minimum possible range after at most one operation.
     * Strategy: Greedy Math (Shrink from both ends).
     * 
     * @param nums Input array.
     * @param k    Maximum adjustment value.
     * @return Minimum range score.
     * 
     *         Tóm tắt chiến lược:
     *         1. Để giảm thiểu khoảng cách giữa MAX và MIN, ta muốn:
     *         - Giảm giá trị lớn nhất xuống nhiều nhất có thể (-k).
     *         - Tăng giá trị nhỏ nhất lên nhiều nhất có thể (+k).
     *         2. Khoảng cách ban đầu là (MAX - MIN).
     *         3. Khoảng cách mới lý tưởng là (MAX - k) - (MIN + k) = (MAX - MIN) -
     *         2k.
     *         4. Tuy nhiên, khoảng cách không thể âm. Nếu (MAX - MIN) <= 2k, ta có
     *         thể
     *         đưa tất cả các phần tử về cùng một giá trị trung gian nào đó ->
     *         khoàng cách = 0.
     *         5. Vậy kết quả là max(0, (MAX - MIN) - 2k).
     */
    public int smallestRangeI(int[] nums, int k) {
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int x : nums) {
            if (x < minVal) {
                minVal = x;
            }
            if (x > maxVal) {
                maxVal = x;
            }
        }

        int diff = maxVal - minVal;

        // If the difference is already small enough to be covered by 2k adjustments
        if (diff <= 2 * k) {
            return 0;
        } else {
            return diff - 2 * k;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.smallestRangeI(new int[] { 1 }, 0)); // 0
        System.out.println("Result: " + sol.smallestRangeI(new int[] { 0, 10 }, 2)); // 6
        System.out.println("Result: " + sol.smallestRangeI(new int[] { 1, 3, 6 }, 3)); // 0
    }
}
