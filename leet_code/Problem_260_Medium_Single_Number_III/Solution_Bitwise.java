package leet_code.Problem_260_Medium_Single_Number_III;

import java.util.Arrays;

public class Solution_Bitwise {

    /**
     * Finds the two single numbers.
     * Uses XOR bit manipulation and LSB isolation.
     * Time: O(N), Space: O(1).
     * 
     * Tìm hai số đơn độc.
     * Sử dụng thao tác bit XOR và cô lập LSB.
     */
    public int[] singleNumber(int[] nums) {
        // Pass 1: Get the XOR of the two numbers we need to find
        // Lượt 1: Lấy XOR của hai số cần tìm
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }

        // rightmost 1-bit diff between x and y
        // bit 1 phải nhất khác biệt giữa x và y
        // Note: bitmask might be Integer.MIN_VALUE, so use caution or just standard
        // idiom.
        // In Java, -bitmask is valid two's complement.
        int diff = bitmask & (-bitmask);

        int x = 0;
        // Pass 2: Partition numbers into two groups and XOR
        // Lượt 2: Phân chia các số thành hai nhóm và XOR
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }

        // The other number is bitmask ^ x
        // Số còn lại là bitmask ^ x
        return new int[] { x, bitmask ^ x };
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: [1,2,1,3,2,5] -> [3, 5]
        int[] n1 = { 1, 2, 1, 3, 2, 5 };
        System.out.println("Single 1: " + Arrays.toString(solution.singleNumber(n1)));

        // Test Case 2: [-1,0] -> [-1, 0]
        int[] n2 = { -1, 0 };
        System.out.println("Single 2: " + Arrays.toString(solution.singleNumber(n2)));
    }
}
