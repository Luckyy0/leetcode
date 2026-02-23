package leet_code.Problem_220_Hard_Contains_Duplicate_III;

import java.util.TreeSet;

public class Solution_TreeSet {

    /**
     * Checks if there are duplicates with value difference <= valueDiff within
     * index difference <= indexDiff.
     * Uses a TreeSet (Sliding Window) for O(N log K) time complexity.
     * 
     * Kiểm tra bản sao với chênh lệch giá trị <= valueDiff trong khoảng cách chỉ số
     * <= indexDiff.
     * Sử dụng TreeSet (Cửa sổ trượt) cho độ phức tạp O(N log K).
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0) {
            return false;
        }

        // Use Long to prevent overflow during value comparisons (nums[i] + valueDiff)
        // Sử dụng Long để tránh tràn số khi so sánh giá trị
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long currentVal = (long) nums[i];

            // We want to find a number 'x' in the set such that:
            // |currentVal - x| <= valueDiff
            // -> -valueDiff <= x - currentVal <= valueDiff
            // -> currentVal - valueDiff <= x <= currentVal + valueDiff
            // So we start by looking for the smallest x >= currentVal - valueDiff

            // Tìm số 'x' nhỏ nhất trong set sao cho x >= currentVal - valueDiff
            Long ceiling = set.ceiling(currentVal - valueDiff);

            // If such 'x' exists and is also <= currentVal + valueDiff, we found a pair
            // Nếu 'x' tồn tại và cũng <= currentVal + valueDiff, ta tìm thấy cặp
            if (ceiling != null && ceiling <= currentVal + valueDiff) {
                return true;
            }

            set.add(currentVal);

            // Maintain sliding window of size indexDiff
            // Duy trì cửa sổ trượt kích thước indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_TreeSet solution = new Solution_TreeSet();

        // Test Case 1: [1,2,3,1], k=3, t=0 -> true
        int[] n1 = { 1, 2, 3, 1 };
        System.out.println("Result 1: " + solution.containsNearbyAlmostDuplicate(n1, 3, 0));

        // Test Case 2: [1,5,9,1,5,9], k=2, t=3 -> false
        int[] n2 = { 1, 5, 9, 1, 5, 9 };
        System.out.println("Result 2: " + solution.containsNearbyAlmostDuplicate(n2, 2, 3));
    }
}
