package leet_code.Problem_985_Medium_Sum_of_Even_Numbers_After_Queries;

/**
 * Problem 985: Sum of Even Numbers After Queries
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
public class Solution {

    /**
     * Calculates the sum of even numbers after each query.
     * Strategy: Dynamic Running Sum.
     * 
     * @param nums    Array of integers to be updated.
     * @param queries Array of updates [val, index].
     * @return Array containing the sum of even numbers after each query.
     * 
     *         Tóm tắt chiến lược:
     *         1. Tính tổng các số chẵn trong mảng `nums` ban đầu (`evenSum`).
     *         2. Với mỗi truy vấn `query = [val, index]`:
     *         - Ta chỉ cập nhật `nums[index]`. Khi giá trị này thay đổi, tổng số
     *         chẵn chỉ thay đổi ở vị trí này.
     *         - Trừ bỏ giá trị cũ: Nếu `nums[index]` CŨ là số chẵn, nó đã được tính
     *         vào `evenSum`, nên ta trừ nó ra khỏi `evenSum`.
     *         - Cập nhật giá trị mới: `nums[index] += val`.
     *         - Thêm giá trị mới vào tổng: Nếu `nums[index]` MỚI là số chẵn, ta
     *         cộng nó vào `evenSum`.
     *         3. Lưu `evenSum` hiện tại vào mảng kết quả tương ứng.
     *         4. Bằng cách cập nhật chỉ số phần tử (delta update) này, thời gian
     *         cho mỗi truy vấn chỉ mất $O(1)$.
     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;

        // Initial sum of all even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        int[] answer = new int[queries.length];

        // Process updates
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];

            // Subtract the old value if it was even
            if (nums[index] % 2 == 0) {
                evenSum -= nums[index];
            }

            // Apply the query update directly onto nums array
            nums[index] += val;

            // If the updated value is even, add it back to the sum
            if (nums[index] % 2 == 0) {
                evenSum += nums[index];
            }

            // Store the current evenSum
            answer[i] = evenSum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] result1 = sol.sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
                new int[][] { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } });
        // Expected: [8,6,2,4]
        for (int r : result1)
            System.out.print(r + " ");
        System.out.println();
    }
}
