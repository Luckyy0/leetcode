package leet_code.Problem_49_Medium_Group_Anagrams;

import java.util.*;

public class Solution_HashMap {

    /**
     * Groups anagrams together.
     * Uses a HashMap with sorted string keys.
     * Nhóm các từ đảo chữ lại với nhau.
     * Sử dụng một HashMap với các khóa là chuỗi đã sắp xếp.
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

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1
        String[] s1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Test Case 1: " + solution.groupAnagrams(s1));
        // Expected: [["bat"],["nat","tan"],["ate","eat","tea"]] (any order)

        // Test Case 2
        String[] s2 = { "" };
        System.out.println("Test Case 2: " + solution.groupAnagrams(s2));
        // Expected: [[""]]
    }
}
