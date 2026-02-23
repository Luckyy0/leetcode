package leet_code.Problem_902_Hard_Numbers_At_Most_N_Given_Digit_Set;

/**
 * Problem 902: Numbers At Most N Given Digit Set
 * https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 */
public class Solution {

    /**
     * Calculates how many numbers <= N can be formed by the digit set.
     * Strategy: Count by length + Prefix matching.
     * 
     * @param digits Allowed digits (sorted, unique).
     * @param n      Limit N.
     * @return Count of valid numbers.
     * 
     *         Tóm tắt chiến lược:
     *         1. Chia bài toán làm 2 phần:
     *         - Các số có ít chữ số hơn N: Chắc chắn nhỏ hơn N.
     *         Với độ dài L < K (số chữ số của N), số lượng là M^L (M là số lượng
     *         chữ số cho phép).
     *         - Các số có cùng số chữ số với N: Cần kiểm tra từng chữ số từ trái
     *         sang phải.
     *         2. Duyệt từng vị trí i từ trái sang phải của N:
     *         - Với mỗi chữ số d trong tập cho phép:
     *         - Nếu d < N[i]: Ta có thể chọn d cho vị trí này, và các vị trí còn
     *         lại (K-1-i)
     *         có thể chọn bất kỳ chữ số nào. Số lượng = M^(K-1-i).
     *         - Nếu d == N[i]: Ta chọn d, nhưng cần tiếp tục kiểm tra vị trí tiếp
     *         theo (i+1).
     *         - Nếu d > N[i]: Không thể chọn d vì số tạo thành sẽ lớn hơn N. Dừng
     *         lại.
     *         - Nếu tại vị trí i không tìm được d == N[i], nghĩa là không thể tạo
     *         ra tiền tố khớp với N,
     *         nên ta dừng và trả về kết quả hiện tại.
     *         3. Nếu duyệt hết tất cả các vị trí và luôn tìm được d == N[i], nghĩa
     *         là N chính nó là hợp lệ.
     *         Cộng thêm 1 vào kết quả.
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int k = s.length();
        int m = digits.length;
        int ans = 0;

        // 1. Count numbers with fewer digits than N
        for (int i = 1; i < k; i++) {
            ans += Math.pow(m, i);
        }

        // 2. Count numbers with same number of digits as N
        for (int i = 0; i < k; i++) {
            boolean hasSame = false;
            int currentDigit = s.charAt(i) - '0';

            for (String dStr : digits) {
                int d = Integer.parseInt(dStr);

                if (d < currentDigit) {
                    // Start with 'd', rest (k-1-i) positions can be anything
                    ans += Math.pow(m, k - 1 - i);
                } else if (d == currentDigit) {
                    // Match prefix, proceed to next position to check finer constraints
                    hasSame = true;
                    // Important: We break here because digits are sorted.
                    // We found our match, need to check next index of N.
                    // We don't check d > currentDigit because they are sorted,
                    // and next iterations of d loop will definitely be > currentDigit.
                    break;
                } else {
                    // d > currentDigit, since digits are sorted, all subsequent d are also >
                    // currentDigit
                    break;
                }
            }

            // If current position in N cannot be matched by any allowed digit,
            // we cannot form N or any number starting with N[0...i].
            if (!hasSame) {
                return ans;
            }
        }

        // If we successfully matched every digit of N
        return ans + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] d1 = { "1", "3", "5", "7" };
        System.out.println("Result: " + sol.atMostNGivenDigitSet(d1, 100)); // 20

        String[] d2 = { "1", "4", "9" };
        System.out.println("Result: " + sol.atMostNGivenDigitSet(d2, 1000000000)); // 29523

        String[] d3 = { "7" };
        System.out.println("Result: " + sol.atMostNGivenDigitSet(d3, 8)); // 1
    }
}
