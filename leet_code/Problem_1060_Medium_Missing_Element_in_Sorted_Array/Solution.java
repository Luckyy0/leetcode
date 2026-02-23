package Problem_1060_Medium_Missing_Element_in_Sorted_Array;

/**
 * 1060. Missing Element in Sorted Array
 * 
 * Given a strictly increasing array nums of uniquely sorted integers and a
 * positive integer k,
 * return the kth missing number starting from the leftmost number of the array.
 */
public class Solution {

    // Hàm tính Số lượng phần tử đã bị thất lạc KHỎI MẢNG nếu tính từ điểm Đầu Tiên
    // nums[0] đến vị trí nums[idx]
    // Nếu mảng đặc khít không thiếu xót gì, Khoảng Cách Số Phân Tán Sẽ ĐÚNG BẰNG
    // TỔNG SỐ Độ Dài Chỉ Mục idx.
    // Lượng Thiếu Hụt Lẽ Ra = (Giá trị tại idx - Giá trị Nguồn nums[0]) - Số Lượng
    // Phần Tử Thật Sự Đã Trải Qua Mốc 'idx'
    private int missingAmount(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    /**
     * Thuật toán: Tìm kiếm Nhị Phân (Binary Search).
     * Yêu cầu mảng Tăng Dần Nghiêm Ngặt. Lượng Số Bị Mất Cắp Sẽ Hình Thành 1 Đồ Thị
     * Hàm Đơn Tăng.
     * Cực Kỳ Gợi Mở Để Cưa Nửa Giải Bài Toán (Chặt Phân Khúc Vùng Thiếu).
     * 
     * @param nums Mảng số nguyên tăng dần tuyệt đối
     * @param k    Vị trí số thiếu hụt
     * @return Con số bị Mất
     */
    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        // Cú So Bắt Điểm Vướng Ngoại Lệ: Nó Rơi Rớt Qua Ranh Giới Đuôi Cuối Cùng Của
        // Mảng!
        // VD: nums = [4,7,9,10], k = 1000. Lượng Thiếu Khất k Quá Lớn Tràn Hố Rìa
        // -> Đáp Ấn Nhảy Từ Đuôi Bù Lên Thiếu Khuyết (Kéo Cộng Thêm Đuôi Rìa Phải Cuối
        // Mảng)
        if (k > missingAmount(n - 1, nums)) {
            return nums[n - 1] + k - missingAmount(n - 1, nums);
        }

        // Khởi Tạo Ranh Cắt Bộ Đếm Binary Search
        int left = 0;
        int right = n - 1;

        // Trạng Thái Ổn Cưa: Cắt Đôi Hồi Kép Để Xem Trạm Chữa Khát 'k' Chui Lỗ Khúc
        // Trái Cận Hay Vùng Rộng Bên Phải
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Lượng Rỗng Rớt Tới Hố Giữa Đoạn Khúc 'mid' MÀ Vẫn Nhỏ Thiết Hụt Số K Lệnh
            // Tức 'k' nằm Vượt Sâu Chôn Cất Ở Cánh Phải Đằng Sau Nữa
            if (missingAmount(mid, nums) < k) {
                left = mid + 1;
            } else {
                // Sự Thiếu Hụt Ở Lưới Lọc Cửa Giữa Này Cả Đống Đã Vượt Che Đủ Họng Lấy 'k', Bóp
                // Cận Trái Ngay Ô Nằm Khúc Cửa Lại Ngay!
                right = mid;
            }
        }

        // Phá Vòng Kiềm, Cột Mốc Điểm Khắc 'left' Rơi Ngay Đúng Chóc Kèo Vướng Gắn Trạm
        // Lĩnh Hụt Của K
        // Đáp án Là Dựng Điểm Chốt Tựa Trước Mốc Đó Tức (left - 1) + Bu Vòng Khoảng Bù
        // Trừ Còn Dư Từ Mệnh k
        return nums[left - 1] + k - missingAmount(left - 1, nums);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 4, 7, 9, 10 };
        int k1 = 1;
        System.out.println("Test 1: " + sol.missingElement(nums1, k1)); // Expected: 5

        int[] nums2 = { 4, 7, 9, 10 };
        int k2 = 3;
        System.out.println("Test 2: " + sol.missingElement(nums2, k2)); // Expected: 8

        int[] nums3 = { 1, 2, 4 };
        int k3 = 3;
        System.out.println("Test 3: " + sol.missingElement(nums3, k3)); // Expected: 6
    }
}
