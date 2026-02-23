package Problem_1056_Hard_Number_of_Valid_Subarrays;

import java.util.Stack;

/**
 * 1056. Number of Valid Subarrays
 * 
 * Given an integer array nums, return the number of non-empty continuous
 * subarrays
 * with the leftmost element of the subarray not larger than other elements in
 * the subarray.
 */
public class Solution {

    /**
     * Thuật toán: Ngăn Xếp Đơn Điệu (Monotonic Stack).
     * Yêu cầu: Đếm số mảng con mà "Phần tử đầu tiên <= Tất cả phần tử còn lại phía
     * sau nó trong mảng con đó".
     * Mẹo tư duy lật ngược: Thay vì đi mò mảng con, hãy hỏi "Với phần tử nums[i]
     * làm Lãnh đạo,
     * lãnh thổ của nó kết thúc ở đâu?".
     * Trả lời: Lãnh thổ kết thúc ngay CHÍNH TẠI ĐIỂM XUẤT HIỆN Kẻ Đầu Tiên NHỎ HƠN
     * NÓ (First Next Smaller Element).
     * 
     * Ta dùng 1 Stack Đơn điệu tăng (chứa Index) để săn tìm những Kẻ Phản LLoạn (Kẻ
     * nhỏ hơn) này!
     * 
     * @param nums Mảng số nguyên đầu vào
     * @return Tổng số mảng con hợp lệ
     */
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int validTotalCount = 0; // Biến hấn hứng số lượng mảng

        // Ngăn xếp chứa Index. Các giá trị trong mảng tương ứng với các Index này
        // luôn mang tính chất là "Cao dần hoặc bằng nhau".
        Stack<Integer> monotonicStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Khi gặp phải tên Phản Loạn nums[i] MỘT PHÁT NHỎ HƠN Đỉnh của Stack.
            // Điều này có nghĩa: Kẻ Nằm Trên Đỉnh Stack đã HẾT THỜI, lãnh thổ của hắn
            // KHÔNG THỂ vươn xa được tới i nữa vì i quá nhỏ (hệ thống sập!).
            while (!monotonicStack.isEmpty() && nums[i] < nums[monotonicStack.peek()]) {
                int brokenLeaderIndex = monotonicStack.pop();

                // Tiền bồi thường số Lượng mảng hợp lệ mà Lãnh Đạo Vừa Chết nắm giữ chính là
                // Khoảng cách từ vị trí hắn sinh ra cho tới Cột tử hình (i)
                validTotalCount += (i - brokenLeaderIndex);
            }

            // Xong vòng xét phạt, Kẻ Mệnh Lộ nums[i] ung dung bước Vô Tháp Đợi Ngày Bị Lật
            // Đổ Tiếp!
            monotonicStack.push(i);
        }

        // Cuối Khóa Hàng Tồn: Nếu có Những Lão Tướng Ế Vợ Quá Khỏe...
        // Tức là Cả đời chúng nó Quét Quá Mặt Mảng Vẫn chả Có Thằng Nào Đủ Nhỏ Hơn Đu
        // Bám Vượt Tầm Đạp Đổ Nổi Nó.
        // Tự do lãnh thổ của tụi này vươn DÀI ĐẾN TẬN Đuôi Mảng (Vị trí n).
        while (!monotonicStack.isEmpty()) {
            validTotalCount += (n - monotonicStack.pop());
        }

        return validTotalCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 1, 4, 2, 5, 3 };
        System.out.println("Test 1: " + sol.validSubarrays(nums1)); // Expected: 11

        int[] nums2 = { 3, 2, 1 };
        System.out.println("Test 2: " + sol.validSubarrays(nums2)); // Expected: 3

        int[] nums3 = { 2, 2, 2 };
        System.out.println("Test 3: " + sol.validSubarrays(nums3)); // Expected: 6
    }
}
