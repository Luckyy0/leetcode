package leetcode.P1428_LeftmostColumnWithAtLeastAOne;

import java.util.List;

// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0);
        int cols = dim.get(1);

        int r = 0;
        int c = cols - 1;
        int ans = -1;

        while (r < rows && c >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                ans = c;
                c--;
            } else {
                r++;
            }
        }

        return ans;
    }
}
