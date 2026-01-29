package leetcode.P2119_ANumberAfterADoubleReversal;

public class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0)
            return true;
        return num % 10 != 0;
    }
}
