package leetcode.P774_MinimizeMaxDistanceToGasStation;

class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0, right = 1e8;

        // Precision requirement: 1e-6
        // Yêu cầu về độ chính xác: 1e-6
        while (right - left > 1e-6) {
            double mid = left + (right - left) / 2.0;
            if (canSatisfy(stations, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean canSatisfy(int[] stations, int k, double d) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            count += (int) ((stations[i + 1] - stations[i]) / d);
        }
        return count <= k;
    }
}
