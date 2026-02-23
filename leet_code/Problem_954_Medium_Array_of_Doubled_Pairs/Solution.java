package leet_code.Problem_954_Medium_Array_of_Doubled_Pairs;

import java.util.*;

/**
 * Problem 954: Array of Doubled Pairs
 * https://leetcode.com/problems/array-of-doubled-pairs/
 */
public class Solution {

    /**
     * Checks if the array can be reordered such that every contiguous pair (2*i,
     * 2*i+1) satisfies arr[2*i+1] = 2 * arr[2*i].
     * Strategy: Greedy approach with HashMap and Sorting by Absolute Value.
     * 
     * @param arr The input integer array.
     * @return true if valid reordering exists, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đếm tần suất xuất hiện của mỗi số trong mảng bằng HashMap.
     *         2. Sắp xếp các số theo giá trị tuyệt đối tăng dần.
     *         - Tại sao phải sắp xếp theo giá trị tuyệt đối?
     *         Giả sử ta xét số `x`. Nếu `x` muốn tạo cặp, nó phải ghép với `2*x`
     *         hoặc `x/2`.
     *         Bằng cách xét từ số có giá trị tuyệt đối nhỏ nhất, ta đảm bảo rằng
     *         `x` không thể là "kết quả gấp đôi" của một số nào đó chưa được xét
     *         (vì |x/2| < |x|).
     *         Do đó, `x` BẮT BUỘC phải ghép cặp với `2*x`.
     *         Điều này đúng với cả số dương và số âm (ví dụ: xét -2 trước, phải
     *         ghép với -4 vì |-2| < |-4|).
     *         3. Duyệt qua các số đã sắp xếp:
     *         - Nếu số `x` đã được sử dụng hết (count == 0), bỏ qua.
     *         - Nếu còn `x`, kiểm tra xem có đủ số lượng `2*x` để ghép cặp không.
     *         - Nếu không đủ hoặc không có `2*x`, trả về false.
     *         - Nếu đủ, giảm tần suất của cả `x` và `2*x`.
     *         4. Nếu duyệt hết mà không gặp lỗi, trả về true.
     */
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        // Count frequencies
        for (int x : arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Use Integer[] to allow custom comparator
        Integer[] index = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            index[i] = arr[i];
        }

        // Sort based on absolute value
        Arrays.sort(index, Comparator.comparingInt(Math::abs));

        for (int x : index) {
            // If this element has already been used in a pair, skip it
            if (count.get(x) == 0) {
                continue;
            }

            int target = 2 * x;

            // Check if we have the target 2*x available
            if (count.getOrDefault(target, 0) <= 0) {
                return false;
            }

            // Decrement counts for both x and 2*x
            count.put(x, count.get(x) - 1);
            count.put(target, count.get(target) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 3, 1, 3, 6 };
        System.out.println("Result: " + sol.canReorderDoubled(arr1)); // false

        int[] arr2 = { 2, 1, 2, 6 };
        System.out.println("Result: " + sol.canReorderDoubled(arr2)); // false

        int[] arr3 = { 4, -2, 2, -4 };
        System.out.println("Result: " + sol.canReorderDoubled(arr3)); // true
    }
}
