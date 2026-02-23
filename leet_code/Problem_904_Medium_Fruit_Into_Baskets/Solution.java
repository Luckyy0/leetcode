package leet_code.Problem_904_Medium_Fruit_Into_Baskets;

import java.util.*;

/**
 * Problem 904: Fruit Into Baskets
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class Solution {

    /**
     * Finds the maximum number of fruits we can collect.
     * Strategy: Sliding Window (Longest Subarray with at most 2 distinct elements).
     * 
     * @param fruits The input array of fruit types.
     * @return The maximum number of fruits.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán yêu cầu tìm độ dài của dãy con liên tiếp dài nhất chứa
     *         tối đa
     *         2 loại số (trái cây) khác nhau.
     *         2. Sử dụng kỹ thuật Cửa sổ Trượt (Sliding Window):
     *         - Duy trì hai con trỏ `left` và `right`.
     *         - Sử dụng một HashMap `countMap` để đếm số lượng từng loại trái cây
     *         trong cửa sổ hiện tại.
     *         3. Khi mở rộng cửa sổ sang phải (tăng `right`):
     *         - Thêm loại trái cây mới vào `countMap`.
     *         - Nếu số lượng loại trái cây trong `countMap` vượt quá 2:
     *         - Thu hẹp cửa sổ từ bên trái (tăng `left`) cho đến khi số loại trở về
     *         2.
     *         - Giảm số lượng của loại trái cây tại `left` trong `countMap`. Nếu về
     *         0 thì xóa khỏi Map.
     *         4. Cập nhật độ dài tối đa `maxLen` ở mỗi bước hợp lệ.
     */
    public int totalFruit(int[] fruits) {
        // Map to store the count of each fruit type in the current window
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the map
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits, shrink the window from the left
            while (countMap.size() > 2) {
                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);

                // If the count becomes 0, remove it from the map to reduce the size
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);
                }

                left++;
            }

            // Update the maximum length found so far
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.totalFruit(new int[] { 1, 2, 1 })); // 3
        System.out.println("Result: " + sol.totalFruit(new int[] { 0, 1, 2, 2 })); // 3
        System.out.println("Result: " + sol.totalFruit(new int[] { 1, 2, 3, 2, 2 })); // 4
    }
}
