package leetcode.P941_ValidMountainArray;

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3)
            return false;

        int i = 0;
        // Ascent
        while (i + 1 < n && arr[i] < arr[i + 1])
            i++;

        // Peak check
        if (i == 0 || i == n - 1)
            return false;

        // Descent
        while (i + 1 < n && arr[i] > arr[i + 1])
            i++;

        return i == n - 1;
    }
}
