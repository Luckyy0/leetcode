package leet_code.Problem_209_Medium_Minimum_Size_Subarray_Sum;

public class Solution_SlidingWindow {

    /**
     * Finds the minimal length of a subarray whose sum is greater than or equal to
     * target.
     * Uses the Sliding Window technique (Two Pointers).
     * Time: O(N), Space: O(1).
     * 
     * Tìm độ dài tối thiểu của mảng con có tổng lớn hơn hoặc bằng target.
     * Sử dụng kỹ thuật Cửa sổ trượt (Hai con trỏ).
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int currentSum = 0;
        int minLen = Integer.MAX_VALUE;

        // Expand the window with 'right' pointer
        // Mở rộng cửa sổ với con trỏ 'right'
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Contract the window while the condition is met
            // Thu hẹp cửa sổ trong khi điều kiện được thỏa mãn
            while (currentSum >= target) {
                // Determine minimal length
                // Xác định độ dài tối thiểu
                minLen = Math.min(minLen, right - left + 1);

                // Subtract the element at 'left' and move 'left' forward
                // Trừ phần tử tại 'left' và di chuyển 'left' về phía trước
                currentSum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1: target = 7, nums = [2,3,1,2,4,3] -> 2 ([4,3])
        int[] nums1 = { 2, 3, 1, 2, 4, 3 };
        System.out.println("Min Len 1: " + solution.minSubArrayLen(7, nums1));

        // Test Case 2: target = 4, nums = [1,4,4] -> 1 ([4])
        int[] nums2 = { 1, 4, 4 };
        System.out.println("Min Len 2: " + solution.minSubArrayLen(4, nums2));

        // Test Case 3: target = 11, nums = [1,1,1,1,1,1,1,1] -> 0
        int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println("Min Len 3: " + solution.minSubArrayLen(11, nums3));
    }
}
