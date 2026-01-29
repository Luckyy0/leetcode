package leetcode.P2137_PourWaterBetweenBucketsToMakeWaterLevelsEqual;

public class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        double low = 0;
        double maxVal = 0;
        double sum = 0;
        for (int b : buckets) {
            maxVal = Math.max(maxVal, b);
            sum += b;
        }
        double high = maxVal; // Actually sum is safer upper bound conceptually but avg <= max
        // Theoretical max is total sum if loss 0, but average is bounded by max element
        // initially is wrong?
        // No, average <= Max.

        double ratio = 1.0 - loss / 100.0;

        // 100 iterations for precision
        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2;
            if (check(buckets, mid, ratio)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private boolean check(int[] buckets, double target, double ratio) {
        double give = 0;
        double need = 0;

        for (int b : buckets) {
            if (b > target) {
                give += (b - target);
            } else {
                need += (target - b);
            }
        }

        return give * ratio >= need;
    }
}
