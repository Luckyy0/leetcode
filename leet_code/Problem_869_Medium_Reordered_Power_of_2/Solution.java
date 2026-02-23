package leet_code.Problem_869_Medium_Reordered_Power_of_2;

import java.util.Arrays;

/**
 * Problem 869: Reordered Power of 2
 * https://leetcode.com/problems/reordered-power-of-2/
 */
public class Solution {

    /**
     * Determines if any permutation of n is a power of 2.
     * Strategy: Numbers are permutations of each other if they have
     * the same frequency distribution of digits.
     * 
     * @param n The input integer.
     * @return True if a permutation is a power of 2.
     * 
     *         Tóm tắt chiến lược:
     *         Hai số là hoán vị của nhau nếu chúng có bảng tần suất chữ số (0-9)
     *         giống hệt nhau.
     *         Chúng ta đếm các chữ số của n, sau đó so sánh với bảng tần suất
     *         của tất cả các lũy thừa của 2 từ 2^0 đến 2^30.
     */
    public boolean reorderedPowerOf2(int n) {
        int[] targetFreq = getDigitFrequencies(n);

        // Scan all powers of 2 (up to 10^9, so 2^0 to 2^30)
        for (int i = 0; i < 31; i++) {
            int powerOf2 = 1 << i;
            if (Arrays.equals(targetFreq, getDigitFrequencies(powerOf2))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Computes the frequency of each digit (0-9) in the given number.
     */
    private int[] getDigitFrequencies(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        return freq;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.reorderedPowerOf2(1)); // true
        System.out.println("Result: " + sol.reorderedPowerOf2(10)); // false
        System.out.println("Result: " + sol.reorderedPowerOf2(46)); // true (64 is power of 2)
    }
}
