package leet_code.Problem_845_Medium_Longest_Mountain_in_Array;

/**
 * Problem 845: Longest Mountain in Array
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class Solution {

    /**
     * Finds the length of the longest mountain subarray.
     * Strategy: Identify peaks and expand outwards to the bases.
     * 
     * @param arr Array of integers.
     * @return Length of the longest mountain.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt mảng để tìm các "đỉnh" (peak). Một phần tử là đỉnh nếu nó
     *         lớn hơn
     *         cả phần tử trước và sau nó (arr[i-1] < arr[i] > arr[i+1]).
     *         2. Khi tìm thấy một đỉnh, ta mở rộng sang hai bên:
     *         - Mở rộng sang trái trong khi các giá trị vẫn đang giảm (đi xuống
     *         chân núi bên trái).
     *         - Mở rộng sang phải trong khi các giá trị vẫn đang giảm (đi xuống
     *         chân núi bên phải).
     *         3. Tính độ dài của ngọn núi vừa tìm được (right - left + 1).
     *         4. Cập nhật độ dài lớn nhất và tiếp tục tìm đỉnh tiếp theo từ vị trí
     *         'right'.
     */
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int i = 1; // Peaks can't be at the edges

        while (i < n - 1) {
            // Check if current index i is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                // Expand left
                int left = i - 1;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand right
                int right = i + 1;
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Update max length
                maxLen = Math.max(maxLen, right - left + 1);

                // Optimization: skip past the current mountain
                i = right;
            } else {
                i++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a1 = { 2, 1, 4, 7, 3, 2, 5 };
        System.out.println("Max Len: " + sol.longestMountain(a1)); // 5

        int[] a2 = { 2, 2, 2 };
        System.out.println("Max Len: " + sol.longestMountain(a2)); // 0
    }
}
