package leetcode.P1013_PartitionArrayIntoThreePartsWithEqualSum;

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int x : arr)
            sum += x;
        if (sum % 3 != 0)
            return false;

        int target = sum / 3;
        int currentSum = 0;
        int parts = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == target) {
                parts++;
                currentSum = 0;
                // If we found 2 parts, the rest must sum to target (since total is 3*target)
                // However, we need to ensure partitions are non-empty.
                // The loop ensures we process elements. We need to make sure we don't finish
                // the array exactly on part 2 without leaving elements for part 3.
                // But simplified logic: if we find 3 parts, return true.
                if (parts == 3)
                    return true;
            }
        }

        // Edge case: if sum is 0, we might find many 0-sum parts. But simple check is
        // generally ok.
        // Actually, returning true when parts >= 3 is strictly technically correct if
        // we handle index bounds,
        // but given the question "partition into 3 non-empty", logic can be:
        // Find part1, then find part2. The rest is part3.
        return false;
    }

    // Improved logic to be safer
    public boolean canThreePartsEqualSumV2(int[] arr) {
        int sum = 0;
        for (int x : arr)
            sum += x;
        if (sum % 3 != 0)
            return false;

        int target = sum / 3;
        int currentSum = 0;
        int parts = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == target) {
                parts++;
                currentSum = 0;
            }
        }
        return parts >= 3;
    }
}
