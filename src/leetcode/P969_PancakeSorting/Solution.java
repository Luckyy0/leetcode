package leetcode.P969_PancakeSorting;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int x = n; x > 0; x--) {
            int idx = find(arr, x);
            if (idx == x - 1)
                continue;

            // Flip to bring x to front
            if (idx != 0) {
                res.add(idx + 1);
                flip(arr, idx + 1);
            }
            // Flip to bring x to the end of unsorted part
            res.add(x);
            flip(arr, x);
        }
        return res;
    }

    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    private void flip(int[] arr, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
