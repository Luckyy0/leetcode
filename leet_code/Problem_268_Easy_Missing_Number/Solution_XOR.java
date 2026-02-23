package leet_code.Problem_268_Easy_Missing_Number;

public class Solution_XOR {

    /**
     * Finds the missing number in the range [0, n].
     * Uses XOR bit manipulation.
     * Time: O(N), Space: O(1).
     * 
     * Tìm số bị thiếu trong phạm vi [0, n].
     * Sử dụng thao tác bit XOR.
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;

        for (int i = 0; i < n; i++) {
            // XOR index i and value nums[i]
            // We XOR n separately (initial value) because loop only goes to n-1
            // XOR chỉ số i và giá trị nums[i]
            // Chúng ta XOR n riêng (giá trị khởi tạo) vì vòng lặp chỉ chạy đến n-1
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    public static void main(String[] args) {
        Solution_XOR solution = new Solution_XOR();

        // Test Case 1: [3,0,1] -> 2
        int[] n1 = { 3, 0, 1 };
        System.out.println("Missing 1: " + solution.missingNumber(n1));

        // Test Case 2: [0,1] -> 2
        int[] n2 = { 0, 1 };
        System.out.println("Missing 2: " + solution.missingNumber(n2));
    }
}
