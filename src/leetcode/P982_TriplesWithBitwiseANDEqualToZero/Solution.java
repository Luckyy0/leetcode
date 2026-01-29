package leetcode.P982_TriplesWithBitwiseANDEqualToZero;

class Solution {
    public int countTriplets(int[] nums) {
        int[] counts = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                counts[x & y]++;
            }
        }

        int res = 0;
        for (int x : nums) {
            for (int mask = 0; mask < (1 << 16); mask++) {
                if ((x & mask) == 0) {
                    res += counts[mask];
                }
            }
        }
        return res;
    }
}
