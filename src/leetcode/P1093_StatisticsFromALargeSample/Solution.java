package leetcode.P1093_StatisticsFromALargeSample;

class Solution {
    public double[] sampleStats(int[] count) {
        long totalCount = 0;
        long sum = 0;
        int min = -1, max = -1;
        int mode = 0, maxFreq = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (min == -1)
                    min = i;
                max = i;

                totalCount += count[i];
                sum += (long) i * count[i];

                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
            }
        }

        double mean = (double) sum / totalCount;
        double median = 0;

        long countSoFar = 0;
        int median1 = -1, median2 = -1;

        long k1 = (totalCount + 1) / 2; // For odd, mid. For even, left mid.
        long k2 = (totalCount + 2) / 2; // For odd, same as k1. For even, right mid.

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (countSoFar < k1 && countSoFar + count[i] >= k1) {
                    median1 = i;
                }
                if (countSoFar < k2 && countSoFar + count[i] >= k2) {
                    median2 = i;
                }
                countSoFar += count[i];
            }
        }
        median = (median1 + median2) / 2.0;

        return new double[] { min, max, mean, median, mode };
    }
}
