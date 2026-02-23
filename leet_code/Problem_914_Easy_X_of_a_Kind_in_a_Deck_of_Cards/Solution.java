package leet_code.Problem_914_Easy_X_of_a_Kind_in_a_Deck_of_Cards;

import java.util.*;

/**
 * Problem 914: X of a Kind in a Deck of Cards
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Solution {

    /**
     * Determines if the deck can be partitioned into groups of size X > 1.
     * Strategy: GCD of Frequencies.
     * 
     * @param deck Input deck of cards.
     * @return True if possible, False otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đếm tần suất xuất hiện của mỗi lá bài trong bộ bài.
     *         2. Tìm một số X >= 2 sao cho tất cả các tần suất này đều chia hết cho
     *         X.
     *         3. Số X này thực chất là ước chung của tất cả các tần suất.
     *         4. Để tìm X lớn nhất có thể (hoặc kiểm tra sự tồn tại), ta tính GCD
     *         (Ước chung lớn nhất)
     *         của tất cả các tần suất.
     *         5. Nếu GCD >= 2, trả về true. Ngược lại trả về false.
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int c : deck) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int g = -1;
        for (int c : count.values()) {
            if (g == -1) {
                g = c;
            } else {
                g = gcd(g, c);
            }
        }

        return g >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.hasGroupsSizeX(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 })); // true (GCD=2)
        System.out.println("Result: " + sol.hasGroupsSizeX(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 })); // false (GCD=1)
        System.out.println("Result: " + sol.hasGroupsSizeX(new int[] { 1 })); // false (GCD=1)
    }
}
