package leetcode.P1601_MaximumNumberOfAchievableTransferRequests;

public class Solution {
    int maxRequests = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] netChange = new int[n];
        backtrack(requests, 0, netChange, 0);
        return maxRequests;
    }

    private void backtrack(int[][] requests, int index, int[] netChange, int count) {
        if (index == requests.length) {
            // Check if valid
            for (int val : netChange) {
                if (val != 0)
                    return;
            }
            maxRequests = Math.max(maxRequests, count);
            return;
        }

        // Option 1: Take the request
        int from = requests[index][0];
        int to = requests[index][1];

        netChange[from]--;
        netChange[to]++;
        backtrack(requests, index + 1, netChange, count + 1);

        // Backtrack
        netChange[from]++;
        netChange[to]--;

        // Option 2: Skip the request
        backtrack(requests, index + 1, netChange, count);
    }
}
