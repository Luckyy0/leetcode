package leetcode.P1094_CarPooling;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001]; // Constraint: to <= 1000
        for (int[] t : trips) {
            diff[t[1]] += t[0];
            diff[t[2]] -= t[0];
        }

        int currentLoad = 0;
        for (int d : diff) {
            currentLoad += d;
            if (currentLoad > capacity)
                return false;
        }
        return true;
    }
}
