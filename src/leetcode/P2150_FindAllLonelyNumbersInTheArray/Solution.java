package leetcode.P2150_FindAllLonelyNumbersInTheArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums)
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            if (freq.get(x) == 1 && !freq.containsKey(x - 1) && !freq.containsKey(x + 1)) {
                res.add(x);
            }
        }
        return res;
    }
}
