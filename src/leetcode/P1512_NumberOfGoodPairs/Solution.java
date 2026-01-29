package leetcode.P1512_NumberOfGoodPairs;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int res = 0;
        for (int x : nums) {
            res += count[x];
            count[x]++;
        }
        return res;
    }
}
