package leetcode.P1562_FindLatestGroupOfSizeM;

public class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n)
            return n;

        int[] length = new int[n + 2];
        int[] count = new int[n + 1];

        int result = -1;

        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            int leftLen = length[pos - 1];
            int rightLen = length[pos + 1];
            int newLen = leftLen + rightLen + 1;

            // Update length at the boundaries of the new merged interval
            length[pos - leftLen] = newLen;
            length[pos + rightLen] = newLen;

            // Update counts of lengths
            count[leftLen]--;
            count[rightLen]--;
            count[newLen]++;

            // If there is at least one group of size 'm', update latest step
            // Note: count[leftLen] might have been the group of size m that we just
            // destroyed
            // But we checked result at previous step.
            // We just need to check if count[m] > 0 right NOW.
            if (count[m] > 0) {
                result = i + 1;
            }
        }

        return result;
    }
}
