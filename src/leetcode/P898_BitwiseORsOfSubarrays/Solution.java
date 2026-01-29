package leetcode.P898_BitwiseORsOfSubarrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for (int y : cur) {
                next.add(x | y);
            }
            cur = next;
            ans.addAll(cur);
        }
        return ans.size();
    }
}
