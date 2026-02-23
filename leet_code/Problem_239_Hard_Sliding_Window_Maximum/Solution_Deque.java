package leet_code.Problem_239_Hard_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_Deque {

    /**
     * Finds the maximum in each sliding window of size k.
     * Uses a Monotonic Deque (Decreasing) to achieve O(N) time.
     * 
     * Tìm giá trị lớn nhất trong mỗi cửa sổ trượt kích thước k.
     * Sử dụng Deque đơn điệu (Giảm dần) để đạt thời gian O(N).
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // Deque stores INDICES of elements
        // Deque lưu CHỈ SỐ của các phần tử
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window
            // Window range is [i - k + 1, i]
            // 1. Loại bỏ các chỉ số nằm ngoài cửa sổ hiện tại
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove indices from the back whose values are smaller than current value
            // because they can't be the maximum if current value is present
            // 2. Loại bỏ các chỉ số từ phía sau có giá trị nhỏ hơn giá trị hiện tại
            // vì chúng không thể là max nếu giá trị hiện tại tồn tại
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index
            // 3. Thêm chỉ số hiện tại
            deque.offerLast(i);

            // 4. Add the maximum (front of deque) to result
            // Only strictly after the first window is formed (i >= k - 1)
            // 4. Thêm max (đầu deque) vào kết quả
            // Chỉ khi cửa sổ đầu tiên đã hình thành (i >= k - 1)
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Deque solution = new Solution_Deque();

        // Test Case 1: [1,3,-1,-3,5,3,6,7], k=3 -> [3,3,5,5,6,7]
        int[] n1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println("Max Window 1: " + Arrays.toString(solution.maxSlidingWindow(n1, 3)));

        // Test Case 2: [1], k=1 -> [1]
        int[] n2 = { 1 };
        System.out.println("Max Window 2: " + Arrays.toString(solution.maxSlidingWindow(n2, 1)));
    }
}
