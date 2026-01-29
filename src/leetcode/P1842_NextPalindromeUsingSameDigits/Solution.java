package leetcode.P1842_NextPalindromeUsingSameDigits;

public class Solution {
    public String nextPalindrome(String num) {
        int n = num.length();
        int halfLen = n / 2;
        char[] half = num.substring(0, halfLen).toCharArray();

        if (!nextPermutation(half)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(half);
        if (n % 2 != 0) {
            sb.append(num.charAt(halfLen));
        }
        sb.append(new StringBuilder(new String(half)).reverse().toString());

        return sb.toString();
    }

    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0)
            return false;

        int j = arr.length - 1;
        while (j >= 0 && arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        return true;
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
}
