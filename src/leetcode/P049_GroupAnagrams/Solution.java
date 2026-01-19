package leetcode.P049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Solution {

    /**
     * Problem 49: Group Anagrams
     * Approach: Categorize by Sorted String
     * Time Complexity: O(N * K log K)
     * Space Complexity: O(N * K)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        runTest(solution, new String[] { "" });
        runTest(solution, new String[] { "a" });
    }

    private static void runTest(Solution s, String[] strs) {
        System.out.println("Input: " + Arrays.toString(strs));
        List<List<String>> result = s.groupAnagrams(strs);
        System.out.println("Output: " + result);

        // Basic check: total size
        int count = 0;
        for (List<String> list : result)
            count += list.size();

        if (count == strs.length) {
            System.out.println("PASS (Count check)");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
