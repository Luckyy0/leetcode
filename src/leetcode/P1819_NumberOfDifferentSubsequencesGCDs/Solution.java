package leetcode.P1819_NumberOfDifferentSubsequencesGCDs;

public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        boolean[] present = new boolean[max + 1];
        for (int x : nums)
            present[x] = true;

        int count = 0;

        for (int g = 1; g <= max; g++) {
            int currentGcd = 0;
            for (int multiple = g; multiple <= max; multiple += g) {
                if (present[multiple]) {
                    if (currentGcd == 0) {
                        currentGcd = multiple;
                    } else {
                        currentGcd = gcd(currentGcd, multiple);
                    }
                    if (currentGcd == g)
                        break; // Optimization
                }
            }
            if (currentGcd == g)
                count++;
        }

        return count;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
