package leetcode.P955_DeleteColumnsToMakeSortedII;

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int res = 0;
        boolean[] sorted = new boolean[n - 1];

        for (int j = 0; j < len; j++) {
            int i;
            for (i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            if (i < n - 1)
                continue; // Deleted column

            // Not deleted, update sorted array
            for (i = 0; i < n - 1; i++) {
                if (strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                    sorted[i] = true;
                }
            }
        }
        return res;
    }
}
