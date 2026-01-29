package leetcode.P1010_PairsOfSongsWithTotalDurationsDivisibleBy60;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for (int t : time) {
            int r = t % 60;
            int target = (60 - r) % 60;
            res += count[target];
            count[r]++;
        }
        return res;
    }
}
