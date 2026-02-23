package leet_code.Problem_1011_Medium_Capacity_To_Ship_Packages_Within_D_Days;

/**
 * Problem 1011: Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class Solution {

    /**
     * Finds the minimum capacity ship that can carry all packages within the given
     * days.
     * Strategy: Binary Search on Answer / Target function minimization.
     * 
     * @param weights The array of package weights.
     * @param days    The maximum number of days allowed to ship.
     * @return The minimum ship capacity.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hãy đặt bài toán theo kiểu DÒ SỐ. Ta cần tìm một Sức Chứa
     *         (Capacity)
     *         nhỏ nhất có thể.
     *         2. Chắc chắn rằng sếp muốn đưa Sức Chứa về cực tiểu, nhưng nó không
     *         thể bé hơn kiện hàng to nhất (Nếu không thì sập boong tàu).
     *         -> Đó là chặn Dưới (`left = max(w)`).
     *         3. Nếu ta gom hết hàng tống lên đúng 1 chuyến đò (Giao trong 1 ngày),
     *         ta cần tàu to bằng tổng tất cả các kiện.
     *         -> Đó là chặn Trên (`right = sum(w)`).
     *         4. Rõ ràng, đáp án Tàu Nặng Bao Nhiêu sẽ nằm từ [Trữ Lượng Dưới,
     *         Trữ Lượng Trên].
     *         5. Do Mảng đáp án này [10, 11, ..., 50] có dạng ĐƠN ĐIỆU (Monotonic).
     *         (Tức là sức chở 25 mà chở KHÔNG KỊP, thì 24, 23, 22 cũng KHÔNG KỊP
     *         luôn).
     *         (Trái lại, sức chở 26 mà MÁT MÁI CHỞ VỪA trong giới hạn ngày, thì 27,
     *         28,
     *         ... cũng VỪA KHÍT).
     *         6. Nhờ sự Đơn Điều Thần Thánh đó, mình mượn phép Tìm Kiếm Nhị Phân
     *         (Binary Search) để chặt nhỏ khoảng tìm kiếm xuống Log2(N). Dù tàu
     *         chứa
     *         cỡ nào đi nữa, chia cắt khoảng chừng 25-30 lần là ra đáp án chuẩn
     *         nhất!
     */
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        // Tìm chặn dưới (Kiện béo nhất) và chặn trên (Tổng tất cả)
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        // Bắt đầu cưa nhị phân dò Tải Trọng (Mid)
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                // Đủ khả năng chở, hãy cố thử xem cưa ép con tàu xuống cho nhẹ phí
                right = mid - 1;
            } else {
                // Tàu quá nát, chở không kịp thời hạn, bắt buộc phải đổi tàu to hơn
                left = mid + 1;
            }
        }

        // Khi con trỏ Left chạy lấn qua con trỏ Right, đó chính là giới hạn nhỏ nhất.
        return left;
    }

    // Hàm đi làm thị sát thực tế
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int w : weights) {
            // Đưa thêm kiện này lên tàu có bị trào boong không?
            if (currentLoad + w > capacity) {
                // Trào rồi, sập chuyến. Bắt buộc để kiện này sang chuyến ngày kế tiếp!
                daysNeeded++;
                currentLoad = w;
            } else {
                // Còn dư chỗ, ấn nó vào chở tiếp luôn
                currentLoad += w;
            }
        }

        // Ngày cần chở mà ít hơn hoặc bằng hợp đồng là Quá Ngon (True)
        return daysNeeded <= days;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] weights1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Result 1: " + sol.shipWithinDays(weights1, 5)); // expected 15

        int[] weights2 = { 3, 2, 2, 4, 1, 4 };
        System.out.println("Result 2: " + sol.shipWithinDays(weights2, 3)); // expected 6

        int[] weights3 = { 1, 2, 3, 1, 1 };
        System.out.println("Result 3: " + sol.shipWithinDays(weights3, 4)); // expected 3
    }
}
