package leet_code.Problem_75_Medium_Sort_Colors;

import java.util.Arrays;

public class Solution_ThreeWayPartition {

    /**
     * Sorts colors (0, 1, 2) in-place in one pass.
     * Uses the Dutch National Flag algorithm.
     * Sắp xếp các màu (0, 1, 2) tại chỗ trong một lần duyệt.
     * Sử dụng thuật toán Lá cờ Hà Lan.
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Move 0s to the beginning (low part)
                // Di chuyển các số 0 về đầu (phần low)
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1s stay in the middle (mid part)
                // Các số 1 giữ ở giữa (phần mid)
                mid++;
            } else { // nums[mid] == 2
                // Move 2s to the end (high part)
                // Di chuyển các số 2 về cuối (phần high)
                swap(nums, mid, high);
                high--;
                // Note: Do not increment mid here because the swapped value
                // from 'high' needs to be checked.
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution_ThreeWayPartition solution = new Solution_ThreeWayPartition();

        // Test Case 1
        int[] n1 = { 2, 0, 2, 1, 1, 0 };
        solution.sortColors(n1);
        System.out.println("Test Case 1: " + Arrays.toString(n1));
        // Expected: [0, 0, 1, 1, 2, 2]

        // Test Case 2
        int[] n2 = { 2, 0, 1 };
        solution.sortColors(n2);
        System.out.println("Test Case 2: " + Arrays.toString(n2));
        // Expected: [0, 1, 2]
    }
}
