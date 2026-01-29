package leetcode.P760_FindAnagramMappings;

import java.util.*;

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.computeIfAbsent(nums2[i], k -> new Stack<>()).push(i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]).pop();
        }

        return res;
    }
}
