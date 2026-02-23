package leet_code.Problem_35_Easy_Search_Insert_Position;

public class Solution_BinarySearch {

    /**
     * Finds the index to insert target.
     * Uses Binary Search.
     * Tìm chỉ số để chèn target.
     * Sử dụng Tìm kiếm Nhị phân.
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        int[] n1 = { 1, 3, 5, 6 };
        int t1 = 5;
        System.out.println("Test Case 1: " + solution.searchInsert(n1, t1));
        // Expected: 2

        // Test Case 2
        int[] n2 = { 1, 3, 5, 6 };
        int t2 = 2;
        System.out.println("Test Case 2: " + solution.searchInsert(n2, t2));
        // Expected: 1

        // Test Case 3
        int[] n3 = { 1, 3, 5, 6 };
        int t3 = 7;
        System.out.println("Test Case 3: " + solution.searchInsert(n3, t3));
        // Expected: 4
    }
}
