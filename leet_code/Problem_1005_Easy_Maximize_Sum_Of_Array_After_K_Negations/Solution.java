package leet_code.Problem_1005_Easy_Maximize_Sum_Of_Array_After_K_Negations;

import java.util.Arrays;

/**
 * Problem 1005: Maximize Sum Of Array After K Negations
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class Solution {

    /**
     * Maximizes the sum of the array after choosing exactly k elements and negating
     * them.
     * Strategy: Greedy approach with sorting.
     * 
     * @param nums The integer array.
     * @param k    The number of negations.
     * @return The largest possible sum.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Tham lam" (Greedy): Để làm cực đại tổng mang lại, ta ưu tiên đảo
     *         dấu các con số âm lớn nhất. Âm càng sâu đổi sang sẽ thành số siêu
     *         lớn.
     *         2. Đầu tiên, gọi Arrays.sort() mất tối đa O(N log N) để gom toàn bộ
     *         số âm về đầu mảng. Các số âm đó hiện đang xếp từ âm nhất tới ít âm
     *         nhất.
     *         3. Mình duyệt qua mảng, và hễ thấy số âm nào, lập tức lật ngược nó
     *         lại cho thành số dương, trừ dần `k` (`k--`).
     *         4. Đến một lúc, hoặc là hết sạch dấu âm, hoặc `k` tụt về 0.
     *         5. Lúc này, nếu `k` đã chẵn hoặc bằng 0 thì không sao, dấu đổi chẵn
     *         lần
     *         sẽ giữ nguyên bản chất phép toán dương/âm ban đầu.
     *         6. Nếu `k` lẻ (k % 2 != 0), bắt buộc ta phải lật một con số dương.
     *         Gặp
     *         tình huống này, ta chọn ra phần tử có trị số tuyệt đối bé nhất mảng
     *         hiện thời, đảo dấu nó.
     *         7. Tính sum rồi trả kết quả cuối cùng.
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Sắp xếp các số tăng dần
        Arrays.sort(nums);

        // Đảo dấu các số âm từ nhỏ đến lớn cho đến khi hết k hoặc hết số âm
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // Tính tổng và tìm kiếm phần tử bé nhất cho trường hợp k lẻ
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }

        // Nếu số lần dư k lẻ, nghĩa là có 1 lần ta phải trừ vào số bé nhất
        // Thay vì -min, thì do đã +min ở vòng lặp trên rồi, nên phải -2*min
        if (k % 2 != 0) {
            sum -= 2 * min;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 4, 2, 3 };
        int k1 = 1;
        System.out.println("Result 1: " + sol.largestSumAfterKNegations(nums1, k1)); // expected 5

        int[] nums2 = { 3, -1, 0, 2 };
        int k2 = 3;
        System.out.println("Result 2: " + sol.largestSumAfterKNegations(nums2, k2)); // expected 6

        int[] nums3 = { 2, -3, -1, 5, -4 };
        int k3 = 2;
        System.out.println("Result 3: " + sol.largestSumAfterKNegations(nums3, k3)); // expected 13
    }
}
