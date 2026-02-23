package leet_code.Problem_303_Easy_Range_Sum_Query_Immutable;

public class NumArray {

    private int[] prefixSum;

    /**
     * Initializes with the input array.
     * Computes prefix sums.
     * Time: O(N) init, O(1) query. Space: O(N).
     * 
     * Khởi tạo với mảng đầu vào.
     * Tính toán tổng tiền tố.
     */
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // prefixSum[i] stores sum nums[0...i-1]
        // prefixSum[i] lưu tổng nums[0...i-1]
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // Sum from left to right is prefixSum[right+1] - prefixSum[left]
        // Tổng từ left đến right là prefixSum[right+1] - prefixSum[left]
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = new NumArray(nums);

        // Queries
        System.out.println("Sum(0, 2): " + obj.sumRange(0, 2)); // 1
        System.out.println("Sum(2, 5): " + obj.sumRange(2, 5)); // -1
        System.out.println("Sum(0, 5): " + obj.sumRange(0, 5)); // -3
    }
}
