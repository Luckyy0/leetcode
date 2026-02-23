package leet_code.Problem_34_Medium_Find_First_And_Last_Position_Of_Element_In_Sorted_Array;

import java.util.Arrays;

public class Solution_BinarySearch {

    /**
     * Finds starting and ending position of target.
     * Uses Two Binary Searches.
     * Tìm vị trí bắt đầu và kết thúc của target.
     * Sử dụng Hai lần Tìm kiếm Nhị phân.
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                // If found, record candidate and keep searching left
                // Nếu tìm thấy, ghi nhận ứng viên và tiếp tục tìm bên trái
                if (nums[mid] == target) {
                    index = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                // If found, record candidate and keep searching right
                // Nếu tìm thấy, ghi nhận ứng viên và tiếp tục tìm bên phải
                if (nums[mid] == target) {
                    index = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        int[] n1 = { 5, 7, 7, 8, 8, 10 };
        int t1 = 8;
        System.out.println("Test Case 1: " + Arrays.toString(solution.searchRange(n1, t1)));
        // Expected: [3, 4]

        // Test Case 2
        int[] n2 = { 5, 7, 7, 8, 8, 10 };
        int t2 = 6;
        System.out.println("Test Case 2: " + Arrays.toString(solution.searchRange(n2, t2)));
        // Expected: [-1, -1]

        // Test Case 3
        int[] n3 = {};
        int t3 = 0;
        System.out.println("Test Case 3: " + Arrays.toString(solution.searchRange(n3, t3)));
        // Expected: [-1, -1]
    }
}
