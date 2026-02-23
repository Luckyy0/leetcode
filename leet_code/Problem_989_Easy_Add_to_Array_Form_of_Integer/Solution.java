package leet_code.Problem_989_Easy_Add_to_Array_Form_of_Integer;

import java.util.*;

/**
 * Problem 989: Add to Array-Form of Integer
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class Solution {

    /**
     * Adds integer k to integer array num.
     * Strategy: Right-to-Left Digit Addition.
     * 
     * @param num Array representing big integer.
     * @param k   Integer to add.
     * @return Array form of sum.
     * 
     *         Tóm tắt chiến lược:
     *         1. Không thể chuyển mảng `num` thành số nguyên vì `num` có thể lên
     *         tới 10000 chữ số, vượt qua kiểu dữ liệu thông thường `long`.
     *         2. Ta sẽ thực hiện phép cộng trên từng chữ số từ phải sang trái (hàng
     *         đơn vị trước tiên).
     *         3. Bắt đầu lấy con trỏ `i` tại vị trí `num.length - 1` (chữ số nhỏ
     *         nhất).
     *         4. Trong vòng lặp (cho đến khi cả `num` đã được duyệt hết và số `k`
     *         còn dư bằng 0):
     *         - Ta trực tiếp cộng `num[i]` hiện tại vào `k`.
     *         - Kết quả: `k` mang giá trị là phép cộng tại chữ số hàng hiện tại +
     *         số nhớ từ hàng trước đó (nếu có).
     *         5. Phần hàng đơn vị của `k` chính là `k % 10`. Ta thêm nó vào danh
     *         sách `result`.
     *         6. Phần còn lại (phần nhớ) là `k / 10`. Nó sẽ tiếp tục được mang qua
     *         hàng tiếp theo bằng cách gán lại `k = k / 10`.
     *         7. Giảm dần `i`.
     *         8. Rút kết quả, mảng `result` hiện đang lưu thứ tự các chữ số từ bé
     *         đến lớn. Ta lật ngược nó trước khi trả về.
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }

            result.add(k % 10);
            k /= 10;

            i--;
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] num1 = { 1, 2, 0, 0 };
        int k1 = 34;
        System.out.println("Result: " + sol.addToArrayForm(num1, k1)); // [1, 2, 3, 4]

        int[] num2 = { 2, 7, 4 };
        int k2 = 181;
        System.out.println("Result: " + sol.addToArrayForm(num2, k2)); // [4, 5, 5]

        int[] num3 = { 2, 1, 5 };
        int k3 = 806;
        System.out.println("Result: " + sol.addToArrayForm(num3, k3)); // [1, 0, 2, 1]
    }
}
