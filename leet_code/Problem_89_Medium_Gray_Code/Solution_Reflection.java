package leet_code.Problem_89_Medium_Gray_Code;

import java.util.*;

public class Solution_Reflection {

    /**
     * Generates an n-bit Gray code sequence.
     * Uses the reflection method to ensure adjacent numbers differ by one bit.
     * Tạo chuỗi mã Gray n-bit.
     * Sử dụng phương pháp phản xạ để đảm bảo các số liền kề khác nhau một bit.
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // Start with 0
        // Bắt đầu với 0
        result.add(0);

        for (int i = 0; i < n; i++) {
            int size = result.size();
            // The bit to add for the reflected part
            // Bit cần thêm cho phần phản xạ
            int addBit = 1 << i;

            // Iterate backwards through existing elements to reflect them
            // Duyệt ngược qua các phần tử hiện có để phản xạ chúng
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | addBit);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Reflection solution = new Solution_Reflection();

        // Test Case 1: n = 2
        System.out.println("Test Case 1 (n=2): " + solution.grayCode(2));
        // Expected: [0, 1, 3, 2]

        // Test Case 2: n = 1
        System.out.println("Test Case 2 (n=1): " + solution.grayCode(1));
        // Expected: [0, 1]
    }
}
