package leetcode.P1850_MinimumAdjacentSwapsToReachTheKthSmallestNumber;

public class Solution {
    public int getMinSwaps(String num, int k) {
        char[] original = num.toCharArray();
        char[] target = num.toCharArray();

        for (int i = 0; i < k; i++) {
            nextPermutation(target);
        }

        // Calculate min swaps
        return countSwaps(original, target);
    }

    private void nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private int countSwaps(char[] s1, char[] s2) {
        int n = s1.length;
        int count = 0;
        // s1 is current state (mutable), s2 is target
        // We match s2[i]

        for (int i = 0; i < n; i++) {
            char t = s2[i];
            if (s1[i] != t) {
                int j = i + 1;
                while (j < n && s1[j] != t) {
                    j++;
                }

                // Found at j, bubble to i
                while (j > i) {
                    swap(s1, j, j - 1);
                    count++;
                    j--;
                }
            }
        }
        return count;
    }
}
