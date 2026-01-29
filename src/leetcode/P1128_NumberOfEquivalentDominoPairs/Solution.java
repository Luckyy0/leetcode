package leetcode.P1128_NumberOfEquivalentDominoPairs;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // values 1-9 -> keys 11-99
        int pairs = 0;

        for (int[] d : dominoes) {
            int min = Math.min(d[0], d[1]);
            int max = Math.max(d[0], d[1]);
            int key = min * 10 + max;

            pairs += count[key];
            count[key]++;
        }
        return pairs;
    }
}
