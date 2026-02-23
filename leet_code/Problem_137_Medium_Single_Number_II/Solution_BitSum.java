package leet_code.Problem_137_Medium_Single_Number_II;

public class Solution_BitSum {

    /**
     * Finds the single number that appears once in an array where
     * every other element appears exactly three times.
     * Uses bit summation to achieve O(N) time and O(1) space.
     * 
     * Tìm số duy nhất xuất hiện một lần trong một mảng mà mọi phần tử
     * khác đều xuất hiện đúng ba lần.
     * Sử dụng phương pháp tổng hợp bit để đạt thời gian O(N) và không gian O(1).
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        // Iterate through each of the 32 bit positions
        // Lặp qua từng vị trí trong số 32 bit
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;

            // For each number, check if the i-th bit is set
            // Đối với mỗi số, kiểm tra xem bit thứ i có được đặt hay không
            for (int num : nums) {
                // Extract the i-th bit using right shift and masking
                // Trích xuất bit thứ i bằng cách dịch phải và mặt nạ
                bitSum += (num >> i) & 1;
            }

            // If the total count for this bit matches the (3n + 1) pattern,
            // it means the single number must have this bit set.
            // Nếu tổng số lượng bit này khớp với quy luật (3n + 1),
            // điều đó có nghĩa là số duy nhất phải có bit này được đặt.
            if (bitSum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BitSum solution = new Solution_BitSum();

        // Test Case 1: [2, 2, 3, 2]
        int[] n1 = { 2, 2, 3, 2 };
        System.out.println("Test Case 1: " + solution.singleNumber(n1));
        // Expected: 3

        // Test Case 2: [0, 1, 0, 1, 0, 1, 99]
        int[] n2 = { 0, 1, 0, 1, 0, 1, 99 };
        System.out.println("Test Case 2: " + solution.singleNumber(n2));
        // Expected: 99
    }
}
