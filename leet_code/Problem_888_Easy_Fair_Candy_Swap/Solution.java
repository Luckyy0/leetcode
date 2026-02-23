package leet_code.Problem_888_Easy_Fair_Candy_Swap;

import java.util.*;

/**
 * Problem 888: Fair Candy Swap
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class Solution {

    /**
     * Determines the pair of candy sizes to swap.
     * Strategy: Calculate the diff needed and search for it.
     * 
     * @param aliceSizes Alice's candy sizes.
     * @param bobSizes   Bob's candy sizes.
     * @return Array [alice_size, bob_size].
     * 
     *         Tóm tắt chiến lược:
     *         1. Tính tổng kẹo của Alice (SumA) và Bob (SumB).
     *         2. Gọi x là kẹo Alice cho, y là kẹo Bob cho.
     *         Ta cần: SumA - x + y = SumB - y + x
     *         => 2y - 2x = SumB - SumA
     *         => y = x + (SumB - SumA) / 2
     *         3. Tính diff = (SumB - SumA) / 2.
     *         4. Lưu tất cả các giá trị kẹo của Bob vào một HashSet để tìm kiếm
     *         nhanh.
     *         5. Duyệt qua từng thanh kẹo x của Alice. Kiểm tra xem trong set của
     *         Bob
     *         có tồn tại giá trị y = x + diff hay không.
     *         6. Nếu có, trả về cặp [x, y].
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;

        for (int x : aliceSizes)
            sumA += x;
        for (int y : bobSizes)
            sumB += y;

        int diff = (sumB - sumA) / 2;

        Set<Integer> setB = new HashSet<>();
        for (int y : bobSizes) {
            setB.add(y);
        }

        for (int x : aliceSizes) {
            if (setB.contains(x + diff)) {
                return new int[] { x, x + diff };
            }
        }

        return new int[0]; // Should not reach here
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + Arrays.toString(sol.fairCandySwap(new int[] { 1, 1 }, new int[] { 2, 2 }))); // [1,
                                                                                                                     // 2]
        System.out.println("Result: " + Arrays.toString(sol.fairCandySwap(new int[] { 1, 2 }, new int[] { 2, 3 }))); // [1,
                                                                                                                     // 2]
        System.out.println("Result: " + Arrays.toString(sol.fairCandySwap(new int[] { 2 }, new int[] { 1, 3 }))); // [2,
                                                                                                                  // 3]
    }
}
