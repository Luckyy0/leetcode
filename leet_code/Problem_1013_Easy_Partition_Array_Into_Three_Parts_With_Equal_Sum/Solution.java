package leet_code.Problem_1013_Easy_Partition_Array_Into_Three_Parts_With_Equal_Sum;

/**
 * Problem 1013: Partition Array Into Three Parts With Equal Sum
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class Solution {

    /**
     * Determines if an array can be partitioned into three contiguous parts with
     * equal sums.
     * Strategy: Greedy approach.
     * 
     * @param arr The array of integers.
     * @return True if partition is possible, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Muốn chặt mảng thành 3 khúc bằng nhau, tổng 3 khúc đó gộp lại CHẮC
     *         CHẮN
     *         phải là một số chia hết cho 3. Nếu tổng đó không chia hết cho 3, đáp
     *         án là false lập tức.
     *         - VD: Tổng bằng 10, đố ai chặt ra 3 khúc nguyên nào bằng khít
     *         nhau được!
     *         2. Nếu chia hết cho 3, ta gọi `target = Tổng / 3` là Vạch Đích (Mục
     *         tiêu
     *         cho 1 khúc đơn).
     *         3. Cách ngáo ngơ nhất là lồng 2 vòng For cắm chốt tìm chém mảng
     *         (O(N^2)
     *         chắc chắn nổ bùm TLE (Time Limit Exceeded) khi N=50 ngàn).
     *         4. Cách thông minh Tối Ưu (Optimal): Ta ứng dụng cơ chế THAM LAM
     *         (Greedy).
     *         - Khởi tạo Rổ gom (`currentSum = 0`) và Số khúc chém được (`parts =
     *         0`).
     *         - Chạy từ trái sang phải, vừa chạy vừa ném từng số vào Rổ gom.
     *         - NẾU (Rổ gom == Vạch Đích):
     *         Tăng số khúc chém được thêm 1 (`parts++`). Lập tức làm sạch Rổ
     *         buông mẻ này bắt mẻ khác (`currentSum = 0`).
     *         5. Có một ngoại lệ khó chịu: Giả sử `target = 0` (vì Tổng = 0). Nó
     *         có thể lỡ tay chém khúc đứt đứt đứt đứt... xẹt nát ra 4,5,6 khúc
     *         thì sao? Không hề hấn gì, bởi vì thừa ra vài khúc 0 thì gộp lại
     *         chung 1 khúc vẫn cứ ra 0!
     *         - Nên chỉ cần chém được ÍT NHẤT 3 khúc (`parts >= 3`), thì chắc chắn
     *         phần Mảng rác dư thừa cũng sẽ tự hợp sức lại thành chuẩn 3 dải duy
     *         nhất theo quy luật Toán học. Trả True thoái mái O(N)!
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Quy luật chết người: Chia mảng cho 3 thì Tổng phải chia hết cho 3
        if (totalSum % 3 != 0) {
            return false;
        }

        int target = totalSum / 3;
        int currentSum = 0;
        int partsCount = 0;

        for (int num : arr) {
            currentSum += num;

            // Tham lam: Gom đủ 1 rổ mục tiêu là đổ mẻ, chém đứt luôn không đắn đo
            if (currentSum == target) {
                partsCount++;
                currentSum = 0;
            }
        }

        // Đảm bảo phải chia được tối thiểu 3 phần hoặc hơn
        return partsCount >= 3;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
        System.out.println("Result 1: " + sol.canThreePartsEqualSum(arr1)); // expected true

        int[] arr2 = { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 };
        System.out.println("Result 2: " + sol.canThreePartsEqualSum(arr2)); // expected false

        int[] arr3 = { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 };
        System.out.println("Result 3: " + sol.canThreePartsEqualSum(arr3)); // expected true
    }
}
