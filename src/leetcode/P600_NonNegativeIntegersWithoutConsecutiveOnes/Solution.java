package leetcode.P600_NonNegativeIntegersWithoutConsecutiveOnes;

class Solution {
    public int findIntegers(int n) {
        // Precompute Fibonacci numbers
        // f[i] stores the number of valid binary strings of length i
        // f[i] lưu trữ số lượng chuỗi nhị phân hợp lệ có độ dài i
        // f[0] = 1 (""), f[1] = 2 ("0", "1"), f[2] = 3 ("00", "01", "10")
        // Relation: f[i] = f[i-1] + f[i-2] (appending 0 to f[i-1], appending 01 to
        // f[i-2])
        // Wait, standard digit DP Fibonacci:
        // ends with 0: f[i-1]
        // ends with 1: must be 01... -> f[i-2]

        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int count = 0;
        int prevBit = 0;

        // Iterate from MSB (30 down to 0, since n <= 10^9 < 2^30)
        // Lặp từ MSB (30 xuống 0, vì n <= 10^9 < 2^30)
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                // If current bit of n is 1
                // We add cases where this bit is 0 (which are strictly smaller than n)
                // These cases correspond to valid strings of length i
                // Nếu bit hiện tại của n là 1
                // Chúng ta thêm các trường hợp mà bit này là 0 (nhỏ hơn hẳn n)
                // Các trường hợp này tương ứng với các chuỗi hợp lệ có độ dài i
                count += f[i];

                if (prevBit == 1) {
                    // Two consecutive ones in n -> we can't continue matching n
                    // We already added all valid numbers smaller than current prefix
                    // Return immediately
                    // Hai số một liên tiếp trong n -> chúng ta không thể tiếp tục khớp n
                    // Chúng ta đã thêm tất cả các số hợp lệ nhỏ hơn tiền tố hiện tại
                    // Trả về ngay lập tức
                    return count;
                }
                prevBit = 1;
            } else {
                // If current bit is 0, we can only put 0.
                // Continue checking next bit.
                // Nếu bit hiện tại là 0, chúng ta chỉ có thể đặt 0.
                // Tiếp tục kiểm tra bit tiếp theo.
                prevBit = 0;
            }
        }

        // If we processed all bits without returning, n itself is valid
        // Nếu chúng ta xử lý tất cả các bit mà không trả về, bản thân n là hợp lệ
        return count + 1;
    }
}
