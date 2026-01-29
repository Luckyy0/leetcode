package leetcode.P1523_CountOddNumbersInAnIntervalRange;

class Solution {
    public int countOdds(int low, int high) {
        return countUpTo(high) - countUpTo(low - 1);
    }

    private int countUpTo(int n) {
        if (n < 0)
            return 0;
        return (n + 1) / 2;
    }
}
