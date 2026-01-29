package leetcode.P1643_KthSmallestInstructions;

public class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int v = destination[0];
        int h = destination[1];
        StringBuilder sb = new StringBuilder();

        while (h > 0 && v > 0) {
            // Calculate ways if we choose H first
            // Remaining: h-1 H's, v V's. Total len = h+v-1.
            // Ways = (h+v-1) C (v)
            int combinations = combinations(h + v - 1, v);

            if (k <= combinations) {
                sb.append('H');
                h--;
            } else {
                sb.append('V');
                v--;
                k -= combinations;
            }
        }

        // Append remaining
        while (h > 0) {
            sb.append('H');
            h--;
        }
        while (v > 0) {
            sb.append('V');
            v--;
        }

        return sb.toString();
    }

    // Simple iterative nCr
    private int combinations(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        if (r == 0 || r == n)
            return 1;
        if (r > n / 2)
            r = n - r;

        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }
        return (int) res;
    }
}
