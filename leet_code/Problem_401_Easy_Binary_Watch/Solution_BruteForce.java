package leet_code.Problem_401_Easy_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

public class Solution_BruteForce {

    /**
     * Finds all possible times with a specific number of LEDs.
     * Use simple enumeration of all hours and minutes.
     * Time: O(1), Space: O(1).
     * 
     * Tìm tất cả các thời gian khả thi với số lượng đèn LED nhất định.
     * Sử dụng phương pháp liệt kê đơn giản tất cả giờ và phút.
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        // Hour can be from 0 to 11
        // Giờ có thể từ 0 đến 11
        for (int h = 0; h < 12; h++) {
            // Minute can be from 0 to 59
            // Phút có thể từ 0 đến 59
            for (int m = 0; m < 60; m++) {
                // Count total set bits in hour and minute
                // Đếm tổng số bit được bật trong giờ và phút
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_BruteForce solution = new Solution_BruteForce();

        // Test Case 1: turnedOn = 1
        System.out.println("Result 1: " + solution.readBinaryWatch(1));

        // Test Case 2: turnedOn = 9
        System.out.println("Result 9: " + solution.readBinaryWatch(9));
    }
}
