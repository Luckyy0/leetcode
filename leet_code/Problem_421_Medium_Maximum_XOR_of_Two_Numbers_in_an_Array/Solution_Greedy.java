package leet_code.Problem_421_Medium_Maximum_XOR_of_Two_Numbers_in_an_Array;

import java.util.HashSet;
import java.util.Set;

public class Solution_Greedy {

    /**
     * Finds the maximum XOR value of two numbers in an array.
     * Uses a greedy approach from MSB to LSB with a HashSet of prefixes.
     * Time: O(31 * N), Space: O(N).
     * 
     * Tìm giá trị XOR lớn nhất của hai số trong mảng.
     * Sử dụng phương pháp tham lam từ MSB sang LSB với HashSet các tiền tố.
     */
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        // Build the maxResult bit by bit from MSB to LSB
        // Xây dựng maxResult từng bit một từ bit trọng số lớn nhất đến nhỏ nhất
        for (int i = 30; i >= 0; i--) {
            // mask sets bits from 30 down to i to 1
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // Extract prefix of num up to bit i
                set.add(num & mask);
            }

            // Try setting the i-th bit of maxResult to 1
            int hypotheticalMax = maxResult | (1 << i);

            for (int prefix : set) {
                // Theorem: if a ^ b = c, then a ^ c = b
                // Logic: check if there exists another prefix such that prefix ^
                // hypotheticalMax is in the set
                if (set.contains(prefix ^ hypotheticalMax)) {
                    maxResult = hypotheticalMax;
                    break;
                }
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [3, 10, 5, 25, 2, 8] -> 28
        int[] nums1 = { 3, 10, 5, 25, 2, 8 };
        System.out.println("Result 1: " + solution.findMaximumXOR(nums1));

        // Test Case 2: [14,70,53,83,49,91,36,80,92,51,66,70] -> 127
        int[] nums2 = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
        System.out.println("Result 2: " + solution.findMaximumXOR(nums2));
    }
}
