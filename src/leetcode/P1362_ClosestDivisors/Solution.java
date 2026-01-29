package leetcode.P1362_ClosestDivisors;

class Solution {
    public int[] closestDivisors(int num) {
        int[] pair1 = findClosest(num + 1);
        int[] pair2 = findClosest(num + 2);

        if (Math.abs(pair1[0] - pair1[1]) < Math.abs(pair2[0] - pair2[1])) {
            return pair1;
        } else {
            return pair2;
        }
    }

    private int[] findClosest(int n) {
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {
                return new int[] { i, n / i };
            }
        }
        return new int[] { 1, n };
    }
}
