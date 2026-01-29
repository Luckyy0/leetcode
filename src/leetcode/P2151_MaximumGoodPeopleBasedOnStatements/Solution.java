package leetcode.P2151_MaximumGoodPeopleBasedOnStatements;

public class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int maxGood = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            int currentGoodCount = Integer.bitCount(mask);
            if (currentGoodCount <= maxGood)
                continue; // Optimization

            boolean valid = true;
            for (int i = 0; i < n; i++) {
                // If i is considered Good
                if (((mask >> i) & 1) == 1) {
                    // Validate i's statements
                    for (int j = 0; j < n; j++) {
                        int st = statements[i][j];
                        if (st == 2)
                            continue;

                        // Expected value for j based on mask
                        int expected = ((mask >> j) & 1);

                        if (st != expected) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (!valid)
                    break;
            }

            if (valid) {
                maxGood = currentGoodCount;
            }
        }

        return maxGood;
    }
}
