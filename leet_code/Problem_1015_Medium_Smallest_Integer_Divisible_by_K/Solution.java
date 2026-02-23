package leet_code.Problem_1015_Medium_Smallest_Integer_Divisible_by_K;

/**
 * Problem 1015: Smallest Integer Divisible by K
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 */
public class Solution {

    /**
     * Finds the length of the smallest number matching "111...1" divisible by K.
     * Strategy: Pigeonhole Principle & Modulo Arithmetic (O(K)).
     * 
     * @param k The given divisor.
     * @return The length of the smallest valid number, or -1 if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Không thể giải bằng cách dùng Số lớn (BigInteger) ghép dần dãy
     *         11111... vì N có thể dài cả trăm ngàn chữ số -> Xử lý chậm rì, TLE.
     *         2. Điều duy nhất khiến ta bận tâm là nó ĐÃ CHIA HẾT hay CHƯA. Nghĩa
     *         là số dư `P % K == 0`.
     *         3. Dựa theo lý thuyết Toán học Modulo:
     *         Số mới mẻ `P_new` = `P_old * 10 + 1`
     *         Phép dư `P_new % K` = `((P_old % K) * 10 + 1) % K`.
     *         Tức là mình không cần lưu cái số trăm ngàn ký tự kia, mình chỉ
     *         việc lưu phần Số Dư của cỗ số ấy (một số bé tí ti nằm gọn từ 0 đến
     *         K-1).
     *         4. Loại trừ thẳng thừng các con số không đội trời chung (như số tận
     *         cùng 2, 4, 6 hay số tận cùng 0, 5) -> Dãy đuôi `1` đời nào chia chẵn
     *         (K % 2 == 0 hoặc K % 5 == 0). Trả -1.
     *         5. Vòng lặp: Bắt đầu dò số từ 1 (độ dài chiều dài = 1). Tìm `P % K`
     *         (nghĩa là gộp dần modulo). Dừng lại ngay khi `P == 0`.
     *         6. Có thể nó sẽ xoay thành Vòng Lặp Vô Cuối nếu không chia được?
     *         Đừng lo! Nguyên lý "Chuồng Bồ Câu" phán: Chia dư cho K chỉ có K
     *         đáp án. Qua luân hồi K vòng, mà bạn vẫn không bắt được số 0,
     *         thì nghĩa là vòng sau đó sẽ xào lại số dư đã xổ ra... Lập vòng vô
     *         tận!
     *         Do đó ta giới hạn Vòng quét đúng bằng bộ số K là bóc sạch TLE.
     */
    public int smallestRepunitDivByK(int k) {
        // Sự thật khắc nghiệt: Số chẵn hoặc số có đuôi 5 KHÔNG THỂ có bội số kết bằng
        // đuôi 1.
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        // Bắt đầu cày số dư thay vì cày giá trị thật.
        int remainder = 0;

        // Vòng lặp sinh số mới, giới hạn số chim trong tổ <= K
        for (int length = 1; length <= k; length++) {

            // Lịch sử Modulo: (Số cũ x 10 + 1) % K
            remainder = (remainder * 10 + 1) % k;

            // Số dư bằng phẳng tức là trọn gói chia hết.
            if (remainder == 0) {
                return length;
            }
        }

        // Khỏi tìm mỏi mắt nữa, định luật bồ câu ấn định bạn vô danh
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.smallestRepunitDivByK(1)); // expected 1
        System.out.println("Result 2: " + sol.smallestRepunitDivByK(2)); // expected -1
        System.out.println("Result 3: " + sol.smallestRepunitDivByK(3)); // expected 3
        System.out.println("Result 4: " + sol.smallestRepunitDivByK(13)); // expected 6 (111111 / 13 = 8547)
    }
}
