package leet_code.Problem_136_Easy_Single_Number;

public class Solution_Bitwise {

    /**
     * Finds the single number that appears only once in an array where
     * every other element appears exactly twice.
     * Uses bitwise XOR to achieve O(N) time and O(1) space.
     * 
     * Tìm số duy nhất chỉ xuất hiện một lần trong một mảng mà mọi phần tử
     * khác đều xuất hiện đúng hai lần.
     * Sử dụng toán tử XOR bitwise để đạt thời gian O(N) và không gian O(1).
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        // Applying XOR property: a ^ a = 0 and a ^ 0 = a
        // Áp dụng tính chất XOR: a ^ a = 0 và a ^ 0 = a
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: [2, 2, 1]
        int[] n1 = { 2, 2, 1 };
        System.out.println("Test Case 1: " + solution.singleNumber(n1));
        // Expected: 1

        // Test Case 2: [4, 1, 2, 1, 2]
        int[] n2 = { 4, 1, 2, 1, 2 };
        System.out.println("Test Case 2: " + solution.singleNumber(n2));
        // Expected: 4

        // Test Case 3: [1]
        int[] n3 = { 1 };
        System.out.println("Test Case 3: " + solution.singleNumber(n3));
        // Expected: 1
    }
}
