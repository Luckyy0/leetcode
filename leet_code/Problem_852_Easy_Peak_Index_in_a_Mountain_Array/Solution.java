package leet_code.Problem_852_Easy_Peak_Index_in_a_Mountain_Array;

/**
 * Problem 852: Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class Solution {

    /**
     * Finds the peak index in a mountain array using Binary Search.
     * Strategy: Since the array increases and then decreases, we look for
     * the transition point where arr[i] > arr[i+1].
     * 
     * @param arr A mountain array.
     * @return The index of the peak.
     * 
     *         Tóm tắt chiến lược:
     *         Sử dụng Tìm kiếm nhị phân để tìm đỉnh. Nếu phần tử ở giữa nhỏ hơn
     *         phần tử
     *         kế tiếp, đỉnh nằm ở phía bên phải. Ngược lại, đỉnh nằm ở bên trái
     *         hoặc
     *         chính là phần tử hiện tại.
     */
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Compare mid with the next element
            if (arr[mid] < arr[mid + 1]) {
                // We are in the increasing part, peak is to the right
                low = mid + 1;
            } else {
                // We are in the decreasing part or at the peak, peak is to the left or at mid
                high = mid;
            }
        }

        // low and high converge at the peak index
        return low;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 0, 1, 0 };
        System.out.println("Peak index: " + sol.peakIndexInMountainArray(arr1)); // Expected: 1

        int[] arr2 = { 0, 2, 1, 0 };
        System.out.println("Peak index: " + sol.peakIndexInMountainArray(arr2)); // Expected: 1

        int[] arr3 = { 0, 10, 5, 2 };
        System.out.println("Peak index: " + sol.peakIndexInMountainArray(arr3)); // Expected: 1
    }
}
