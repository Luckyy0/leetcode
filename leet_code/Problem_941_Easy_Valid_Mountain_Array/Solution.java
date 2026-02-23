package leet_code.Problem_941_Easy_Valid_Mountain_Array;

/**
 * Problem 941: Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class Solution {

    /**
     * Checks if the given array is a valid mountain array.
     * Strategy: Two-pass linear scan (climb up, check peak, climb down).
     * 
     * @param arr The input integer array.
     * @return true if valid mountain array, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt từ đầu mảng để tìm sườn dốc đi lên (tăng dần).
     *         2. Nếu sườn đi lên không tồn tại (đỉnh ngay tại đầu) hoặc đi lên đến
     *         hết mảng (đỉnh ngay tại cuối),
     *         thì đó không phải là núi hợp lệ.
     *         3. Từ vị trí đỉnh tìm được, tiếp tục duyệt để tìm sườn dốc đi xuống
     *         (giảm dần).
     *         4. Nếu đi xuống được đến hết mảng, trả về true. Ngược lại false.
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        // A mountain array must have at least 3 elements
        if (n < 3)
            return false;

        int i = 0;

        // Walk up: find the peak
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be at the start (no uphill) or at the end (no downhill)
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Walk down: verify the rest is strictly decreasing
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // If we reached the end, it's a valid mountain
        return i == n - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.validMountainArray(new int[] { 2, 1 })); // false
        System.out.println("Result: " + sol.validMountainArray(new int[] { 3, 5, 5 })); // false
        System.out.println("Result: " + sol.validMountainArray(new int[] { 0, 3, 2, 1 })); // true
    }
}
