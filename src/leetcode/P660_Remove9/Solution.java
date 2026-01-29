package leetcode.P660_Remove9;

class Solution {
    public int newInteger(int n) {
        // The problem is equivalent to converting n to base 9.
        // Bài toán tương đương với việc chuyển đổi n sang cơ số 9.
        return Integer.parseInt(Integer.toString(n, 9));
    }
}
