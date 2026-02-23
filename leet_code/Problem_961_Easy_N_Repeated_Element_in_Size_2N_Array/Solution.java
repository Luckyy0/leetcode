package leet_code.Problem_961_Easy_N_Repeated_Element_in_Size_2N_Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 961: N-Repeated Element in Size 2N Array
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class Solution {

    /**
     * Finds the element repeated N times in an array of size 2N.
     * Strategy: First Duplicate (HashSet).
     * 
     * @param nums Array of 2N integers.
     * @return The element that is repeated N times.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mảng có kích thước `2N`.
     *         2. Có `N+1` phần tử duy nhất (unique elements).
     *         3. Chính xác một phần tử được lặp lại `N` lần. Các phần tử còn lại
     *         (`N` phần tử) đều xuất hiện đúng 1 lần.
     *         4. Từ các tính chất trên suy ra: Chỉ có duy nhất một phần tử xuất
     *         hiện nhiều hơn 1 lần.
     *         Tất cả các phần tử khác đều chỉ xuất hiện một lần duy nhất.
     *         5. Vì vậy, ta chỉ cần duyệt qua mảng và tìm phần tử đầu tiên bị lặp
     *         lại.
     *         Sử dụng HashSet để lưu các số đã gặp. Số đầu tiên đã có trong Set
     *         chính là đáp án.
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Check if the number has already been seen
            if (seen.contains(num)) {
                return num; // Found the repeated element (it's the only one that repeats)
            }
            seen.add(num);
        }

        throw new IllegalArgumentException("No repeated element found");
    }

    /**
     * Alternative approach with O(1) Space (Probabilistic / Pattern based).
     * Since the element appears N times in 2N slots, it's very dense.
     * It must appear within distance 3 (nums[i] == nums[i+1] or nums[i] ==
     * nums[i+2]) almost always.
     * Except for edge cases like [x, y, z, x], but iterating all pairs handles it.
     */
    public int repeatedNTimesConstantSpace(int[] nums) {
        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < nums.length - k; i++) {
                if (nums[i] == nums[i + k]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 1, 2, 3, 3 };
        System.out.println("Result: " + sol.repeatedNTimes(n1)); // 3

        int[] n2 = { 2, 1, 2, 5, 3, 2 };
        System.out.println("Result: " + sol.repeatedNTimes(n2)); // 2

        int[] n3 = { 5, 1, 5, 2, 5, 3, 5, 4 };
        System.out.println("Result: " + sol.repeatedNTimes(n3)); // 5
    }
}
