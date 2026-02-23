package leet_code.Problem_950_Medium_Reveal_Cards_In_Increasing_Order;

import java.util.*;

/**
 * Problem 950: Reveal Cards In Increasing Order
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class Solution {

    /**
     * Reorders the deck so that revealing cards follows increasing order.
     * Strategy: Simulation using Queue.
     * 
     * @param deck Input array of cards.
     * @return Reordered deck.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng `deck` theo thứ tự tăng dần.
     *         2. Sử dụng một hàng đợi (Queue) để chứa các chỉ số ban đầu `0, 1,
     *         ..., n-1`.
     *         Hàng đợi này mô phỏng vị trí của các lá bài trong bộ bài chưa biết
     *         thứ tự.
     *         3. Thực hiện mô phỏng quá trình lật bài:
     *         - Lấy chỉ số đầu tiên ra khỏi hàng đợi (`poll`). Chỉ số này tương ứng
     *         với vị trí lá bài sẽ được lật ĐẦU TIÊN.
     *         Do đó, ta gán giá trị nhỏ nhất của `deck` (đã sắp xếp) vào vị trí này
     *         trong mảng kết quả.
     *         - Nếu hàng đợi vẫn còn phần tử, lấy chỉ số tiếp theo và đưa xuống
     *         cuối hàng đợi (`add(poll)`).
     *         Điều này tương ứng với hành động "bỏ lá bài tiếp theo xuống đáy bộ
     *         bài".
     *         4. Lặp lại quá trình cho đến khi gán hết tất cả các giá trị từ `deck`
     *         đã sắp xếp vào đúng vị trí chỉ số lật được.
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        // Step 1: Sort the deck
        Arrays.sort(deck);

        // Step 2: Initialize queue with indices
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];

        // Step 3: Simulate
        for (int card : deck) {
            // Get the index where the current smallest card should be placed
            int index = indexQueue.poll();
            result[index] = card;

            // Move the next index to the bottom of the queue
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] d1 = { 17, 13, 11, 2, 3, 5, 7 };
        int[] res1 = sol.deckRevealedIncreasing(d1);
        System.out.println("Result: " + Arrays.toString(res1)); // [2, 13, 3, 11, 5, 17, 7]

        int[] d2 = { 1, 1000 };
        int[] res2 = sol.deckRevealedIncreasing(d2);
        System.out.println("Result: " + Arrays.toString(res2)); // [1, 1000]
    }
}
