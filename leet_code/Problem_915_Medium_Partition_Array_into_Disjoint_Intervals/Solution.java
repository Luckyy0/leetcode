package leet_code.Problem_915_Medium_Partition_Array_into_Disjoint_Intervals;

/**
 * Problem 915: Partition Array into Disjoint Intervals
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */
public class Solution {

    /**
     * Partitions the array into two subarrays such that max(left) <= min(right).
     * Strategy: One Pass Optimal.
     * 
     * @param nums Input array.
     * @return Length of left partition.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta cần tìm vị trí cắt `partitionIdx` nhỏ nhất sao cho mọi phần tử
     *         bên phải
     *         đều lớn hơn hoặc bằng mọi phần tử bên trái.
     *         2. Duy trì `maxLeft` là giá trị lớn nhất của phần bên trái hiện tại.
     *         Duy trì `partitionIdx` là chỉ số kết thúc của phần bên trái hiện tại.
     *         3. Duyệt qua mảng:
     *         - Cập nhật `maxSoFar` (giá trị lớn nhất đã thấy từ đầu đến vị trí i).
     *         - Nếu phần tử hiện tại `nums[i]` nhỏ hơn `maxLeft`:
     *         -> Điều này vi phạm điều kiện "mọi phần tử bên trái <= mọi phần tử
     *         bên phải"
     *         nếu ta giữ nguyên phần chia cũ. Vì `nums[i]` đáng lẽ phải thuộc phần
     *         bên phải,
     *         nhưng nó lại nhỏ hơn một phần tử nào đó trong phần bên trái
     *         (`maxLeft`).
     *         -> Do đó, `nums[i]` bắt buộc phải thuộc về phần bên trái.
     *         -> Ta mở rộng phần bên trái đến vị trí i (`partitionIdx = i`).
     *         -> Cập nhật `maxLeft` thành `maxSoFar` (vì bây giờ phần bên trái đã
     *         bao gồm các phần tử mới).
     *         4. Kết quả là `partitionIdx + 1`.
     */
    public int partitionDisjoint(int[] nums) {
        int partitionIdx = 0;
        int maxLeft = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);

            if (nums[i] < maxLeft) {
                // We must include this element in the left partition because it is smaller
                // than the maximum of our current left partition.
                partitionIdx = i;
                maxLeft = maxSoFar;
            }
        }

        return partitionIdx + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.partitionDisjoint(new int[] { 5, 0, 3, 8, 6 })); // 3 ([5,0,3], [8,6])
        System.out.println("Result: " + sol.partitionDisjoint(new int[] { 1, 1, 1, 0, 6, 12 })); // 4 ([1,1,1,0],
                                                                                                 // [6,12])
    }
}
