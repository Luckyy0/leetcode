package leet_code.Problem_191_Easy_Number_Of_1_Bits;

public class Solution_HammingWeight {

    /**
     * Counts the number of set bits (1s) in the binary representation.
     * Uses Brian Kernighan's Algorithm (n & (n-1)) for efficiency.
     * Time: O(1) (proportional to set bits), Space: O(1).
     * 
     * Đếm số lượng bit 1 trong biểu diễn nhị phân.
     * Sử dụng Thuật toán Brian Kernighan (n & (n-1)) để tăng hiệu quả.
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            // Drop the lowest set bit
            // Loại bỏ bit 1 thấp nhất
            n &= (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_HammingWeight solution = new Solution_HammingWeight();

        // Test Case 1: 11 (binary 1011) -> 3
        int n1 = 11;
        System.out.println("Set bits in 11: " + solution.hammingWeight(n1));

        // Test Case 2: 128 (binary 10000000) -> 1
        int n2 = 128;
        System.out.println("Set bits in 128: " + solution.hammingWeight(n2));

        // Test Case 3: -3 (binary 1111...1101) -> 31
        int n3 = -3;
        System.out.println("Set bits in -3: " + solution.hammingWeight(n3));
    }
}
