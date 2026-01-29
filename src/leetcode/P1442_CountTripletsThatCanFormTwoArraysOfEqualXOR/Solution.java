package leetcode.P1442_CountTripletsThatCanFormTwoArraysOfEqualXOR;

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] P = new int[n + 1];
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k <= n; k++) {
                if (P[i] == P[k]) {
                    count += (k - i - 1);
                }
            }
        }

        return count;
    }
}
