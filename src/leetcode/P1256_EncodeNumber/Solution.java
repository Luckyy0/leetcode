package leetcode.P1256_EncodeNumber;

class Solution {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
