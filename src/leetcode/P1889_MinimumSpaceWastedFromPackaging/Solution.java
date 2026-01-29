package leetcode.P1889_MinimumSpaceWastedFromPackaging;

import java.util.Arrays;

public class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int n = packages.length;
        long totalPackageSum = 0;
        for (int p : packages)
            totalPackageSum += p;

        long minTotalBoxSum = Long.MAX_VALUE;

        for (int[] supplierBoxes : boxes) {
            Arrays.sort(supplierBoxes);

            // If largest box is smaller than largest package, cannot use this supplier
            if (supplierBoxes[supplierBoxes.length - 1] < packages[n - 1]) {
                continue;
            }

            long currentBoxSum = 0;
            int prevIdx = 0;

            for (int boxSize : supplierBoxes) {
                // Find how many packages <= boxSize
                // Since packages are sorted, we want upper bound
                // Optimization: Search only in range [prevIdx, n)
                int idx = upperBound(packages, prevIdx, n, boxSize);

                long count = idx - prevIdx;
                if (count > 0) {
                    currentBoxSum += count * boxSize;
                    prevIdx = idx;
                }

                if (prevIdx == n)
                    break;
            }

            minTotalBoxSum = Math.min(minTotalBoxSum, currentBoxSum);
        }

        if (minTotalBoxSum == Long.MAX_VALUE)
            return -1;

        return (int) ((minTotalBoxSum - totalPackageSum) % 1_000_000_007);
    }

    // Returns the index of the first element > target
    // Range [start, end)
    private int upperBound(int[] arr, int start, int end, int target) {
        int low = start, high = end;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
