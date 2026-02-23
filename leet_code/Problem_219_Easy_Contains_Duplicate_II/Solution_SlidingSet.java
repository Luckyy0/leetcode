package leet_code.Problem_219_Easy_Contains_Duplicate_II;

import java.util.HashSet;
import java.util.Set;

public class Solution_SlidingSet {

    /**
     * Checks if there are duplicates within distance k.
     * Uses a Sliding Window (HashSet of size k).
     * Time: O(N), Space: O(min(N, K)).
     * 
     * Kiểm tra xem có bản sao trong khoảng cách k hay không.
     * Sử dụng Cửa sổ trượt (HashSet kích thước k).
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Check if current num is in the set
            // Kiểm tra xem số hiện tại có trong set không
            if (set.contains(nums[i])) {
                return true;
            }

            // Add current number
            // Thêm số hiện tại
            set.add(nums[i]);

            // Maintain the window size of k
            // Remove the oldest element that falls out of the k-range
            // Duy trì kích thước cửa sổ là k. Xóa phần tử cũ nhất rơi ra khỏi phạm vi k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_SlidingSet solution = new Solution_SlidingSet();

        // Test Case 1: [1,2,3,1], k=3 -> true
        int[] n1 = { 1, 2, 3, 1 };
        System.out.println("Nearby Dup 1: " + solution.containsNearbyDuplicate(n1, 3));

        // Test Case 2: [1,2,3,1,2,3], k=2 -> false
        int[] n2 = { 1, 2, 3, 1, 2, 3 };
        System.out.println("Nearby Dup 2: " + solution.containsNearbyDuplicate(n2, 2));
    }
}
