package leetcode.P2081_SumOfKMirrorNumbers;

public class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;

        // Generate palindromes in base k by length
        int len = 1;
        while (count < n) {
            // Generate all base-k palindromes of length 'len'
            // Construct from first half
            int halfLen = (len + 1) / 2;
            long start = (long) Math.pow(k, halfLen - 1);
            long end = (long) Math.pow(k, halfLen);

            for (long i = start; i < end; i++) {
                long val = generatePalindrome(i, len, k);

                if (isPalindromeBase10(val)) {
                    sum += val;
                    count++;
                    if (count == n)
                        break;
                }
            }
            len++;
        }

        return sum;
    }

    // Create palindrome of total length 'len' using 'half' as the first half (in
    // base k logic)
    // Actually, 'half' is the decimal value of the first half digits in base k.
    // e.g. k=10. len=3. half=12. Palindrome 121.
    // e.g. k=2. len=3. half=3 (11). Palindrome 111 (7).
    private long generatePalindrome(long half, int len, int k) {
        long res = half;
        long temp = half;
        if (len % 2 != 0) {
            temp /= k;
        }

        while (temp > 0) {
            res = res * k + (temp % k);
            temp /= k;
        }
        return res;
    }

    private boolean isPalindromeBase10(long val) {
        String s = Long.toString(val);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
