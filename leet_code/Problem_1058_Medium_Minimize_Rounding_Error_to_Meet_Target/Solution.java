package Problem_1058_Medium_Minimize_Rounding_Error_to_Meet_Target;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1058. Minimize Rounding Error to Meet Target
 * 
 * Given an array of prices [p1,p2...,pn] and a target, round each price pi to
 * Roundi(pi) so that the rounded array
 * [Round1(p1),Round2(p2)...,Roundn(pn)] sums to the given target. Each price pi
 * can be rounded either up or down.
 * 
 * Return the string "-1" if the target cannot be reached. Otherwise, return the
 * minimum rounding error,
 * which is defined as sum(|Roundi(pi) - (pi)|) formatted to 3 decimal places.
 */
public class Solution {

    /**
     * Thuật toán: Tham Lam (Greedy) dựa trên Phần thập phân.
     * Để tổng sau khi làm tròn bằng target:
     * - Ta tính floorSum (tổng nếu làm tròn xuống tất cả) và ceilSum (tổng nếu làm
     * tròn lên tất cả).
     * - Nếu target không nằm trong [floorSum, ceilSum], trả về "-1".
     * - Số lượng phần tử BẮT BUỘC phải làm tròn LÊN là: elementsToCeil = target -
     * floorSum.
     * - Phần tử còn lại sẽ làm tròn XUỐNG.
     * Để sai số là ÍT NHẤT: Ta nên ưu tiên làm tròn LÊN cho những số có PHẦN THẬP
     * PHÂN LỚN NHẤT
     * (vì chúng đã gần với phần nguyên phía trên, rướn lên sẽ mất ít chi phí sai số
     * nhất).
     * 
     * Mẹo tránh sai số Float/Double: Nhân toàn bộ với 1000 để tính toán trên số
     * Nguyên (Integer) 100 %.
     * 
     * @param prices Mảng chứa các chuỗi giá, mỗi chuỗi có chính xác 3 chữ số thập
     *               phân
     * @param target Mục tiêu tổng cần đạt được
     * @return Chuỗi định dạng 3 chữ số thập phân chứa tổng sai số nhỏ nhất, hoặc
     *         "-1" nếu không thể.
     */
    public String minimizeError(String[] prices, int target) {
        int floorSum = 0;
        int ceilSum = 0;

        // Hàng Đợi Ưu Tiên (Max-Heap) lưu các phần thập phân LỚN NHẤT lên đầu.
        PriorityQueue<Integer> fractionMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String priceStr : prices) {
            // Giá gốc luôn có 3 chữ số thập phân. Ví dụ "0.700"
            // Xóa dấu chấm để biến thành số nguyên: 700! Tránh hoàn toàn việc
            // Double.parseDouble bị sai số.
            int rawPriceThousandFold = Integer.parseInt(priceStr.replace(".", ""));

            int integerFloorValue = rawPriceThousandFold / 1000;
            int fractionalRemains = rawPriceThousandFold % 1000;

            floorSum += integerFloorValue;

            if (fractionalRemains > 0) {
                ceilSum += (integerFloorValue + 1);
                fractionMaxHeap.offer(fractionalRemains);
            } else {
                ceilSum += integerFloorValue;
            }
        }

        // Cú Test Tuyệt Vọng: Bơm hết Cỡ Lên Trần hay Đè sạch xuống Đáy cũng không chạm
        // nổi mốc Đích
        if (target < floorSum || target > ceilSum) {
            return "-1";
        }

        // Khắc cốt lượng quân cờ Bắt Buộc Phải Xốc Lên Trần!
        int elementsToCeil = target - floorSum;

        int totalErrorInThousands = 0;

        // Rút củi lấy Dần Ưu Tiên Thằng Đuôi To Khét Nhất Làm Tròn Lên Cứu Hao Tổn
        while (!fractionMaxHeap.isEmpty()) {
            int currentBellyFraction = fractionMaxHeap.poll();

            if (elementsToCeil > 0) {
                // Đội Nóc (Ceil) - Sai lệch phải gánh: 1000 - phần thập phân
                // VD: .700 làm tròn thành 1.000 -> Lệch: 300
                totalErrorInThousands += (1000 - currentBellyFraction);
                elementsToCeil--;
            } else {
                // Gạt Sàn (Floor) - Sai lệch phải gánh: CHÍNH LÀ phần thập phân thừa ra bị cắt
                // đi
                totalErrorInThousands += currentBellyFraction;
            }
        }

        // Ép Nước Chuỗi Cẩn Thận Dính Lỗi Locale Phẩy của Châu Âu (Locale.US giữ dấu
        // Chấm '.')
        return String.format(java.util.Locale.US, "%.3f", totalErrorInThousands / 1000.0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] prices1 = { "0.700", "2.800", "4.900" };
        int target1 = 8;
        System.out.println("Test 1: " + sol.minimizeError(prices1, target1)); // Expected: "1.000"

        String[] prices2 = { "1.500", "2.500", "3.500" };
        int target2 = 10;
        System.out.println("Test 2: " + sol.minimizeError(prices2, target2)); // Expected: "-1"

        String[] prices3 = { "1.500", "2.500", "3.500" };
        int target3 = 9;
        System.out.println("Test 3: " + sol.minimizeError(prices3, target3)); // Expected: "1.500"
    }
}
