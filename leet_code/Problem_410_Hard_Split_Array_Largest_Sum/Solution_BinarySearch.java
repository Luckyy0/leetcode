package leet_code.Problem_410_Hard_Split_Array_Largest_Sum;

public class Solution_BinarySearch {

    /**
     * Finds the minimized largest sum of split array.
     * Uses Binary Search on the answer space.
     * Time: O(N * log(Sum)), Space: O(1).
     * 
     * Tìm tổng lớn nhất được tối thiểu hóa khi chia mảng.
     * Sử dụng tìm kiếm nhị phân trên không gian kết quả.
     */
    public int splitArray(int[] nums, int k) {
        long low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        long res = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) res;
    }

    // Checks if it's possible to split nums into k or fewer subarrays
    // with each subarray sum <= mid
    private boolean canSplit(int[] nums, int k, long limit) {
        int count = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > limit) {
                count++;
                currentSum = num;
                // If we need more than k subarrays, limit is too small
                if (count > k)
                    return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: [7,2,5,10,8], k=2 -> 18
        System.out.println("Result 1: " + solution.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));

        // Test Case 2: [1,2,3,4,5], k=2 -> 9
        System.out.println("Result 2: " + solution.splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
    }
}
