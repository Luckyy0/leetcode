package leet_code.Problem_340_Medium_Longest_Substring_With_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution_SlidingWindow {

    /**
     * Finds longest substring with at most k distinct chars.
     * Uses Sliding Window.
     * Time: O(N), Space: O(K) or O(1) (charset).
     * 
     * Tìm chuỗi con dài nhất với tối đa k ký tự khác nhau.
     * Sử dụng Cửa sổ Trượt.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0)
            return 0;

        Map<Character, Integer> counts = new HashMap<>(); // Standard Map
        // Could use int[256] if only ASCII

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            counts.put(rChar, counts.getOrDefault(rChar, 0) + 1);

            while (counts.size() > k) {
                char lChar = s.charAt(left);
                counts.put(lChar, counts.get(lChar) - 1);
                if (counts.get(lChar) == 0) {
                    counts.remove(lChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1: "eceba", k=2 -> 3 ("ece")
        System.out.println("Result 1: " + solution.lengthOfLongestSubstringKDistinct("eceba", 2));

        // Test Case 2: "aa", k=1 -> 2 ("aa")
        System.out.println("Result 2: " + solution.lengthOfLongestSubstringKDistinct("aa", 1));
    }
}
