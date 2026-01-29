package leetcode.P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes;

public class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
