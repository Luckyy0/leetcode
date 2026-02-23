package leet_code.Problem_60_Hard_Permutation_Sequence;

import java.util.*;

public class Solution_Math {

    /**
     * Finds the k-th permutation sequence.
     * Uses the Factorial Number System approach.
     * Tìm chuỗi hoán vị thứ k.
     * Sử dụng phương pháp Hệ số Giai thừa.
     */
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // Initialize numbers list and precompute factorials
        // Khởi tạo danh sách các số và tính trước các giai thừa
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // Adjust k to be 0-indexed
        // Điều chỉnh k để bắt đầu từ chỉ số 0
        k--;

        for (int i = 1; i <= n; i++) {
            // Determine the index of the next number
            // Xác định chỉ số của số tiếp theo
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));

            // Remove the used number from the list
            // Loại bỏ số đã sử dụng khỏi danh sách
            numbers.remove(index);

            // Update k for the next iteration
            // Cập nhật k cho lần lặp tiếp theo
            k %= factorial[n - i];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1
        System.out.println("Test Case 1 (n=3, k=3): " + solution.getPermutation(3, 3));
        // Expected: "213"

        // Test Case 2
        System.out.println("Test Case 2 (n=4, k=9): " + solution.getPermutation(4, 9));
        // Expected: "2314"

        // Test Case 3
        System.out.println("Test Case 3 (n=3, k=1): " + solution.getPermutation(3, 1));
        // Expected: "123"
    }
}
