package leet_code.Problem_667_Medium_Beautiful_Arrangement_II;

import java.util.*;

public class Solution {

    /**
     * Constructs an array from 1 to n with exactly k distinct absolute differences.
     * Strategy: Linear sequence for difference=1, followed by zigzag for k-1 more
     * differences.
     * Time: O(n), Space: O(n) for result.
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        // Step 1: Fill n-k elements linearly (produces 1 distinct difference)
        for (int i = 0; i < n - k; i++) {
            res[i] = i + 1;
        }

        // Step 2: Fill remaining k spaces using zigzag to get k-1 more differences
        // Remaining values are from n-k+1 up to n
        int low = n - k + 1;
        int high = n;

        // The first element of zigzag starts at index n-k
        for (int i = n - k; i < n; i++) {
            // (i - (n - k)) is the relative index starting from 0
            if ((i - (n - k)) % 2 == 0) {
                // Alternately pick from high
                res[i] = high--;
            } else {
                // Alternately pick from low
                res[i] = low++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("n=5, k=3: " + Arrays.toString(sol.constructArray(5, 3))); // e.g. [1, 2, 5, 3, 4]
        System.out.println("n=3, k=2: " + Arrays.toString(sol.constructArray(3, 2))); // [1, 3, 2]
    }
}
