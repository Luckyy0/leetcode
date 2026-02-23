package leet_code.Problem_932_Medium_Beautiful_Array;

import java.util.ArrayList;

/**
 * Problem 932: Beautiful Array
 * https://leetcode.com/problems/beautiful-array/
 */
public class Solution {

    /**
     * Constructs a beautiful array of length n.
     * Strategy: Divide and Conquer (Iterative).
     * 
     * @param n Length of the array.
     * @return A beautiful array.
     * 
     *         Tóm tắt chiến lược:
     *         1. Điều kiện của mảng đẹp là: không có `i < k < j` sao cho `nums[k] *
     *         2 = nums[i] + nums[j]`.
     *         Điều này có nghĩa `nums[i], nums[k], nums[j]` không lập thành cấp số
     *         cộng.
     *         2. Nhận xét: `nums[k] * 2` luôn là số CHẴN.
     *         Nếu `nums[i]` là LẺ và `nums[j]` là CHẴN (hoặc ngược lại), thì
     *         `nums[i] + nums[j]` là LẺ.
     *         Chẵn không bao giờ bằng Lẻ, nên điều kiện sẽ luôn thỏa mãn nếu ta
     *         tách Lẻ sang một bên và Chẵn sang một bên.
     *         3. Chiến lược chia để trị:
     *         - Nếu ta có một mảng đẹp `A` kích thước `m`, ta có thể tạo ra mảng
     *         đẹp mới:
     *         - `2*A - 1` (các số lẻ) vẫn giữ tính chất đẹp (biến đổi tuyến tính
     *         `ax+b` giữ nguyên tính chất cấp số cộng).
     *         - `2*A` (các số chẵn) cũng giữ tính chất đẹp.
     *         - Kết hợp: `[2*A - 1] + [2*A]` sẽ tạo thành mảng đẹp kích thước `2m`.
     *         4. Bắt đầu từ mảng `[1]`, lặp lại quá trình nhân đôi kích thước cho
     *         đến khi đủ `n` phần tử.
     *         Lọc bỏ các phần tử lớn hơn `n`.
     */
    public int[] beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);

        while (res.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            // Add odd numbers based on current beautiful array
            // If x is beautiful, 2*x - 1 is beautiful part (odds)
            for (int x : res) {
                if (x * 2 - 1 <= n) {
                    temp.add(x * 2 - 1);
                }
            }
            // Add even numbers based on current beautiful array
            // If x is beautiful, 2*x is beautiful part (evens)
            for (int x : res) {
                if (x * 2 <= n) {
                    temp.add(x * 2);
                }
            }
            res = temp;
        }

        // Convert ArrayList to array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] res1 = sol.beautifulArray(4);
        System.out.print("Result: ");
        for (int x : res1)
            System.out.print(x + " "); // Example: 1 3 2 4 (or similar permutation)
        System.out.println();

        int[] res2 = sol.beautifulArray(5);
        System.out.print("Result: ");
        for (int x : res2)
            System.out.print(x + " "); // Example: 1 5 3 2 4
        System.out.println();
    }
}
