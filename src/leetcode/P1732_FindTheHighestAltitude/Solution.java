package leetcode.P1732_FindTheHighestAltitude;

public class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int maxAlt = 0;
        for (int g : gain) {
            current += g;
            maxAlt = Math.max(maxAlt, current);
        }
        return maxAlt;
    }
}
