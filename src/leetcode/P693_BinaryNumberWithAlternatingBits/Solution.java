package leetcode.P693_BinaryNumberWithAlternatingBits;

class Solution {
    public boolean hasAlternatingBits(int n) {
        // Shift n right by 1 and XOR with n
        // Dịch n sang phải 1 bit và thực hiện phép XOR với chính nó
        int x = n ^ (n >> 1);

        // If n has alternating bits, x will be a sequence of 1s (e.g., 7 = 111)
        // Check if x + 1 is a power of 2
        return (x & (x + 1)) == 0;
    }
}
