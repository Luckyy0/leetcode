package leetcode.P1331_RankTransformOfAnArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int x : sorted) {
            if (!rankMap.containsKey(x)) {
                rankMap.put(x, rank++);
            }
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = rankMap.get(arr[i]);
        }

        return res;
    }
}
