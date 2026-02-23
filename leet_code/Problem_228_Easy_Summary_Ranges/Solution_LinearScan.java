package leet_code.Problem_228_Easy_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution_LinearScan {

    /**
     * Groups sorted numbers into ranges.
     * Uses a single pass linear scan.
     * Time: O(N), Space: O(1).
     * 
     * Nhóm các số đã sắp xếp thành các phạm vi.
     * Sử dụng quét tuyến tính một lần.
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            // Fast forward while current sequence is continuous
            // Tua nhanh trong khi chuỗi hiện tại liên tục
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_LinearScan solution = new Solution_LinearScan();

        // Test Case 1: [0,1,2,4,5,7] -> ["0->2","4->5","7"]
        int[] n1 = { 0, 1, 2, 4, 5, 7 };
        System.out.println("Ranges 1: " + solution.summaryRanges(n1));

        // Test Case 2: [0,2,3,4,6,8,9] -> ["0","2->4","6","8->9"]
        int[] n2 = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println("Ranges 2: " + solution.summaryRanges(n2));
    }
}
