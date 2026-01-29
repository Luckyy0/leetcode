package leetcode.P1122_RelativeSortArray;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int x : arr1) {
            count[x]++;
        }

        int[] res = new int[arr1.length];
        int idx = 0;

        // Add elements from arr2
        for (int x : arr2) {
            while (count[x] > 0) {
                res[idx++] = x;
                count[x]--;
            }
        }

        // Add remaining elements in ascending order
        for (int i = 0; i < 1001; i++) {
            while (count[i] > 0) {
                res[idx++] = i;
                count[i]--;
            }
        }

        return res;
    }
}
