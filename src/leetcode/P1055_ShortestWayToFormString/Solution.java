package leetcode.P1055_ShortestWayToFormString;

class Solution {
    public int shortestWay(String source, String target) {
        int tLen = target.length();
        int sLen = source.length();
        int count = 0;
        int tIdx = 0;

        while (tIdx < tLen) {
            int prevTIdx = tIdx;

            // Try to match as many chars as possible in one pass of source
            for (int i = 0; i < sLen; i++) {
                if (tIdx < tLen && source.charAt(i) == target.charAt(tIdx)) {
                    tIdx++;
                }
            }

            // If tIdx didn't advance, it means current target char is not in source at all
            if (tIdx == prevTIdx)
                return -1;
            count++;
        }

        return count;
    }
}
