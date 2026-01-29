package leetcode.P1529_MinimumSuffixFlips;

class Solution {
    public int minFlips(String target) {
        int flips = 0;
        char state = '0';

        for (char c : target.toCharArray()) {
            if (c != state) {
                flips++;
                state = c;
            }
        }

        return flips;
    }
}
