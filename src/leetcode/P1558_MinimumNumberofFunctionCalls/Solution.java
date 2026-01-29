package leetcode.P1558_MinimumNumberofFunctionCalls;

public class Solution {
    public int minOperations(int[] nums) {
        int totalIncrements = 0;
        int maxDoubles = 0;

        for (int num : nums) {
            if (num == 0)
                continue;

            int currentDoubles = 0;
            // Count set bits and find the highest set bit position
            // Integer.bitCount(num) gives the number of increments needed
            totalIncrements += Integer.bitCount(num);

            // Calculate how many doublings this specific number needs
            // This is equivalent to finding the most significant bit position
            // We can just loop or use Integer.numberOfLeadingZeros
            // 31 - Integer.numberOfLeadingZeros(num) gives index of MSB (0-indexed)
            // Example: 1 (1) -> MSB 0 (0 doublings? No, 1 is 2^0. Wait.
            // Operations: 0 -> 1 needs 1 increment via modify. No doubles.
            // 2 (10) -> 0 -> 1 -> (*2) -> 2. 1 incr, 1 double.
            // 3 (11) -> 0 -> 1 -> (*2) -> 2 -> 3. 2 incr, 1 double.
            // 4 (100) -> 0 -> 1 -> 2 -> 4. 1 incr, 2 doubles.
            // So doubles = MSB index.

            int doubles = 0;
            if (num > 0) {
                doubles = 31 - Integer.numberOfLeadingZeros(num);
            }
            maxDoubles = Math.max(maxDoubles, doubles);
        }

        return totalIncrements + maxDoubles;
    }
}
