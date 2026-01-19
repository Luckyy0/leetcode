package leetcode.P249_GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 249: Group Shifted Strings
     * Approach: HashMap with Canonical Key (Shift to start with 'a')
     * 
     * Theoretical Basis:
     * - Shift every string so its first character becomes 'a'.
     * - Strings in the same group will result in identical shifted strings.
     * 
     * Time Complexity: O(N * K)
     * Space Complexity: O(N * K)
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = generateKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String generateKey(String s) {
        if (s.length() == 0)
            return "";

        char[] chars = s.toCharArray();
        int offset = chars[0] - 'a';

        for (int i = 0; i < chars.length; i++) {
            // (char - offset + 26) % 26 ensures wrap around and positive result
            // 'a' = 0 ... 'z' = 25
            int originalVal = chars[i] - 'a';
            int shiftedVal = (originalVal - offset + 26) % 26;
            chars[i] = (char) (shiftedVal + 'a');
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["abc","bcd","acef","xyz","az","ba","a","z"]
        String[] input = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
        List<List<String>> result = solution.groupStrings(input);

        System.out.println("Input: " + java.util.Arrays.toString(input));
        System.out.println("Result: " + result);
        // Expected groups (order can vary):
        // ["abc","bcd","xyz"]
        // ["az","ba"]
        // ["acef"]
        // ["a","z"]
    }
}
