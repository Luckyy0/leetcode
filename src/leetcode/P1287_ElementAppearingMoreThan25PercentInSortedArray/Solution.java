package leetcode.P1287_ElementAppearingMoreThan25PercentInSortedArray;

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int t = n / 4;

        int[] candidates = { arr[n / 4], arr[n / 2], arr[3 * n / 4] };

        for (int x : candidates) {
            int first = findFirst(arr, x);
            int last = findLast(arr, x);
            if (last - first + 1 > t)
                return x;
        }

        return arr[0]; // Should not reach
    }

    private int findFirst(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return arr[l] == target ? l : -1;
    }

    private int findLast(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2; // ceil
            if (arr[m] > target)
                r = m - 1;
            else
                l = m;
        }
        return arr[l] == target ? l : -1;
    }
}
