package leet_code.Problem_751_Hard_IP_to_CIDR;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Converts a range of IPs to CIDR blocks.
     * Strategy: Greedy bit manipulation based on alignment and remaining count.
     * Time: O(log N) effectively constant (limited by 32 bits). Space: O(1).
     */
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> result = new ArrayList<>();

        while (n > 0) {
            // Find the lowest set bit (alignment constraint)
            // If start is 0, it aligns with everything, so treat maxStep as large enough
            long lowbit = (start == 0) ? (1L << 32) : (start & -start);

            // We can cover at most 'n' IPs
            // So we find the largest power of 2 that is <= lowbit AND <= n
            long step = lowbit;
            while (step > n) {
                step >>= 1;
            }

            // Add CIDR block
            result.add(longToCIDR(start, (int) step));

            // Move forward
            start += step;
            n -= step;
        }

        return result;
    }

    private long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        long res = 0;
        for (String part : parts) {
            res = res * 256 + Integer.parseInt(part);
        }
        return res;
    }

    private String longToCIDR(long ip, int step) {
        int[] parts = new int[4];
        parts[0] = (int) ((ip >> 24) & 255);
        parts[1] = (int) ((ip >> 16) & 255);
        parts[2] = (int) ((ip >> 8) & 255);
        parts[3] = (int) (ip & 255);

        // Calculate prefix length: 32 - log2(step)
        // number of trailing zeros in step
        int len = 0;
        while (step > 1) {
            step >>= 1;
            len++;
        }
        int mask = 32 - len;

        return String.format("%d.%d.%d.%d/%d", parts[0], parts[1], parts[2], parts[3], mask);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.ipToCIDR("255.0.0.7", 10));
        // Output: [255.0.0.7/32, 255.0.0.8/29, 255.0.0.16/32]

        System.out.println("Result 2: " + sol.ipToCIDR("1.1.1.1", 4));
        // Expect: [1.1.1.1/32, 1.1.1.2/31] wait...
        // 1.1.1.1 ends in 1 (odd). Max step 1. -> 1.1.1.1/32. Next start 1.1.1.2. n=3.
        // 1.1.1.2 ends in 10 (even). lowbit 2. 2 <= 3. Take 2. -> 1.1.1.2/31. Next
        // start 1.1.1.4. n=1.
        // 1.1.1.4 ends in 100. lowbit 4. 4 > 1. shrink to 1. -> 1.1.1.4/32.
        // Total: 1.1.1.1/32, 1.1.1.2/31, 1.1.1.4/32.
        // My manual trace above missed a step?
        // 1.1.1.1 -> step 1. Rem n=3.
        // 1.1.1.2 -> step 2. Rem n=1.
        // 1.1.1.4 -> step 1. Rem n=0.
    }
}
