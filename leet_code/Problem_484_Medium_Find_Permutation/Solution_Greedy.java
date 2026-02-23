package leet_code.Problem_484_Medium_Find_Permutation;

public class Solution_Greedy {

    /**
     * Finds the lexicographically smallest permutation matching pattern s.
     * Strategy: Start with 1..n+1. Reverse subarrays corresponding to 'D'
     * sequences.
     * Time: O(N), Space: O(N).
     */
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n + 1];

        // Initialize with 1, 2, ..., n + 1
        for (int i = 0; i <= n; i++) {
            res[i] = i + 1;
        }

        // Iterate through string s to handle 'D' sequences
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                // Find length of consecutive D's
                int start = i;
                while (i < n && s.charAt(i) == 'D') {
                    i++;
                }
                // Reverse the segment [start, i]
                reverse(res, start, i);
            }
        }

        return res;
    }

    // Reverse array range inclusive
    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] res = solution.findPermutation("DI");
        // Expected: [2, 1, 3]
        System.out.print("Result: ");
        for (int num : res)
            System.out.print(num + " ");
        System.out.println();
    }
}
