package leetcode.P975_OddEvenJump;

import java.util.TreeMap;

class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = even[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);

        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            // Odd jump: next >= current (ceiling)
            Integer nextOddVal = map.ceilingKey(arr[i]);
            if (nextOddVal != null) {
                odd[i] = even[map.get(nextOddVal)];
            }

            // Even jump: next <= current (floor)
            Integer nextEvenVal = map.floorKey(arr[i]);
            if (nextEvenVal != null) {
                even[i] = odd[map.get(nextEvenVal)];
            }

            if (odd[i])
                res++;
            map.put(arr[i], i);
        }

        return res;
    }
}
