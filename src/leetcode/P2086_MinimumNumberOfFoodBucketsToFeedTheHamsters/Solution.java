package leetcode.P2086_MinimumNumberOfFoodBucketsToFeedTheHamsters;

public class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int buckets = 0;
        int lastBucketPos = -2; // Position of the last placed bucket

        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                // Check if already fed by a bucket at i-1
                if (lastBucketPos == i - 1) {
                    continue;
                }

                // Need to place a bucket
                // Try right (i+1)
                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    lastBucketPos = i + 1;
                    buckets++;
                }
                // Try left (i-1)
                else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.') {
                    lastBucketPos = i - 1; // Actually this doesn't help future ones
                    buckets++;
                } else {
                    return -1;
                }
            }
        }

        return buckets;
    }
}
