package leet_code.Problem_898_Medium_Bitwise_ORs_of_Subarrays;

import java.util.*;

/**
 * Problem 898: Bitwise ORs of Subarrays
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class Solution {

    /**
     * Calculates the number of unique subarray bitwise ORs.
     * Strategy: DP with Set Optimization.
     * 
     * @param arr Array of integers.
     * @return Number of unique ORs.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ý tưởng ngây thơ là tính OR của tất cả O(N^2) mảng con. Điều này
     *         quá chậm.
     *         2. Tuy nhiên, nếu ta xét các mảng con kết thúc tại một chỉ số i, giá
     *         trị
     *         OR của chúng sẽ có tính chất đơn điệu (chỉ thêm bit 1, không bao giờ
     *         mất đi).
     *         3. Do các số nguyên là 32-bit (hoặc khoảng 30 bit cho 10^9), số lượng
     *         giá trị OR duy nhất kết thúc tại i không thể vượt quá 30.
     *         4. Vì vậy, ta có thể duy trì một tập hợp 'cur' chứa các giá trị OR
     *         kết thúc
     *         tại vị trí i-1.
     *         5. Khi xét phần tử x tại vị trí i, tập hợp 'next' (chứa các giá trị
     *         OR kết thúc tại i)
     *         sẽ bao gồm {x} và {val | x với mọi val trong cur}.
     *         6. Tổng độ phức tạp là O(N * 30).
     */
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for (int val : cur) {
                next.add(val | x);
            }
            cur = next;
            ans.addAll(cur);
        }

        return ans.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.subarrayBitwiseORs(new int[] { 0 })); // 1
        System.out.println("Result: " + sol.subarrayBitwiseORs(new int[] { 1, 1, 2 })); // 3
        System.out.println("Result: " + sol.subarrayBitwiseORs(new int[] { 1, 2, 4 })); // 6
    }
}
