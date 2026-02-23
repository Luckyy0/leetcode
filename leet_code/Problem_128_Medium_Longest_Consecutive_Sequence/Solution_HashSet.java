package leet_code.Problem_128_Medium_Longest_Consecutive_Sequence;

import java.util.*;

public class Solution_HashSet {

    /**
     * Finds the length of the longest consecutive elements sequence in O(n) time.
     * Uses a HashSet to enable O(1) lookups and identify sequence starts.
     * 
     * Tìm độ dài của chuỗi phần tử liên tiếp dài nhất trong thời gian O(n).
     * Sử dụng HashSet để có thể tra cứu với thời gian O(1) và xác định điểm bắt đầu
     * chuỗi.
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Put all numbers in a HashSet for O(1) lookups
        // Đưa tất cả các số vào HashSet để tra cứu trong O(1)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            // Check if 'num' is the start of a sequence
            // 'num' is a start if 'num - 1' is NOT in the set
            // Kiểm tra xem 'num' có phải là điểm bắt đầu của một chuỗi hay không
            // 'num' là điểm bắt đầu nếu 'num - 1' KHÔNG có trong tập hợp
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand the sequence upwards
                // Mở rộng chuỗi về phía trên
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the maximum streak found so far
                // Cập nhật chuỗi dài nhất được tìm thấy cho đến nay
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Solution_HashSet solution = new Solution_HashSet();

        // Test Case 1: [100, 4, 200, 1, 3, 2]
        int[] n1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Test Case 1: " + solution.longestConsecutive(n1));
        // Expected: 4

        // Test Case 2: [0,3,7,2,5,8,4,6,0,1]
        int[] n2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("Test Case 2: " + solution.longestConsecutive(n2));
        // Expected: 9
    }
}
