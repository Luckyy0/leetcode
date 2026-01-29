package leetcode.P1641_CountSortedVowelStrings;

public class Solution {
    public int countVowelStrings(int n) {
        // Formula: (n+4)C4 = (n+4)(n+3)(n+2)(n+1) / 24
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
