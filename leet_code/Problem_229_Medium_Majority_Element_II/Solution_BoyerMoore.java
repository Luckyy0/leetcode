package leet_code.Problem_229_Medium_Majority_Element_II;

import java.util.ArrayList;
import java.util.List;

public class Solution_BoyerMoore {

    /**
     * Finds elements appearing more than n/3 times.
     * Uses Extended Boyer-Moore Voting Algorithm.
     * Time: O(N), Space: O(1).
     * 
     * Tìm các phần tử xuất hiện nhiều hơn n/3 lần.
     * Sử dụng Thuật toán Bỏ phiếu Boyer-Moore mở rộng.
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        // 1. Find candidates
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2. Verify candidates
        // 2. Xác minh ứng viên
        int limit = nums.length / 3;
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1)
                count1++;
            if (candidate2 != null && num == candidate2)
                count2++;
        }

        if (count1 > limit)
            result.add(candidate1);
        if (count2 > limit)
            result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        Solution_BoyerMoore solution = new Solution_BoyerMoore();

        // Test Case 1: [3,2,3] -> [3]
        int[] n1 = { 3, 2, 3 };
        System.out.println("Majority 1: " + solution.majorityElement(n1));

        // Test Case 2: [1] -> [1]
        int[] n2 = { 1 };
        System.out.println("Majority 2: " + solution.majorityElement(n2));

        // Test Case 3: [1,2] -> [1,2]
        int[] n3 = { 1, 2 };
        System.out.println("Majority 3: " + solution.majorityElement(n3));
    }
}
