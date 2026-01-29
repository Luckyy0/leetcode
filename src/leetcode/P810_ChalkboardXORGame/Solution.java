package leetcode.P810_ChalkboardXORGame;

class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;

        // Alice wins if xor is already 0, OR if we have even number of elements.
        // Alice thang neu xor da bang 0, HOAC neu chung ta co so luong phan tu chan.
        return xor == 0 || nums.length % 2 == 0;
    }
}
