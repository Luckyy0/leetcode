package leet_code.Problem_846_Medium_Hand_of_Straights;

import java.util.*;

/**
 * Problem 846: Hand of Straights
 * https://leetcode.com/problems/hand-of-straights/
 */
public class Solution {

    /**
     * Determines if the hand can be rearranged into groups of consecutive cards.
     * Strategy: Greedy approach using a TreeMap.
     * 
     * @param hand      Array of card values.
     * @param groupSize Required size of each group.
     * @return True if possible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Kiểm tra điều kiện cần: tổng số bài phải chia hết cho groupSize.
     *         2. Đếm số lần xuất hiện của mỗi lá bài bằng TreeMap (TreeMap giữ các
     *         khóa luôn được sắp xếp tăng dần).
     *         3. Lặp đi lặp lại:
     *         - Chọn lá bài nhỏ nhất hiện có ('first').
     *         - Thử tạo một nhóm bắt đầu từ 'first': [first, first + 1, ..., first
     *         + groupSize - 1].
     *         - Nếu bất kỳ lá bài nào trong nhóm này không có trong TreeMap, trả về
     *         false.
     *         - Nếu có, giảm số lượng của lá bài đó đi 1. Nếu số lượng về 0, xóa
     *         khỏi TreeMap.
     *         4. Nếu hoàn thành việc chia tất cả các lá bài, trả về true.
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;

        // Count card frequencies and keep them sorted
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int card : hand) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }

        while (!counts.isEmpty()) {
            // Pick the smallest card
            int first = counts.firstKey();

            // Try to form a vertical group of size groupSize
            for (int i = 0; i < groupSize; i++) {
                int current = first + i;

                // If the required consecutive card is missing, return false
                if (!counts.containsKey(current)) {
                    return false;
                }

                int c = counts.get(current);
                if (c == 1) {
                    counts.remove(current);
                } else {
                    counts.put(current, c - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] h1 = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        System.out.println("Result: " + sol.isNStraightHand(h1, 3)); // true

        int[] h2 = { 1, 2, 3, 4, 5 };
        System.out.println("Result: " + sol.isNStraightHand(h2, 4)); // false
    }
}
