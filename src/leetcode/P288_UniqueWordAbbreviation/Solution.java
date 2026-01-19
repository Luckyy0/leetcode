package leetcode.P288_UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 288: Unique Word Abbreviation
     * Approach: HashMap
     * 
     * Theoretical Basis:
     * - Map<Abbr, Word>.
     * - Handle collision by marking invalid.
     * 
     * Time Complexity: O(N) init, O(1) query
     * Space Complexity: O(N)
     */
    public static class ValidWordAbbr {

        private Map<String, String> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String s : dictionary) {
                String a = getAbbr(s);
                if (map.containsKey(a)) {
                    // If contains key, check if same word
                    if (!map.get(a).equals(s)) {
                        // Collision (different words, same abbr)
                        // Mark as empty string (assuming empty string not in dict or handled)
                        // Dictionary words are non-empty usually? Constraint says len >= 1.
                        // But words consist of lowercase English letters. So "" is safe.
                        map.put(a, "");
                    }
                } else {
                    map.put(a, s);
                }
            }
        }

        public boolean isUnique(String word) {
            String a = getAbbr(word);
            String val = map.get(a);

            // 1. Abbr not in dict -> Unique
            // 2. Abbr in dict, and maps to THIS word (and only this word) -> Unique
            return val == null || val.equals(word);
        }

        private String getAbbr(String s) {
            if (s.length() <= 2)
                return s;
            return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] dict = { "deer", "door", "cake", "card" };
        ValidWordAbbr vwa = new ValidWordAbbr(dict);

        // "dear" -> "d2r". Dict: "deer" ("d2r"). "door" ("d2r"). Collision -> "". "" !=
        // "dear". -> False.
        // Wait, "deer" and "door" are in dict. Collision check logic:
        // Key "d2r" -> initially "deer". Next "door" -> "d2r". "door" != "deer" -> "".
        // map.get("d2r") is "".
        // isUnique("dear") -> val="" != "dear" -> False. Correct.
        runTest(vwa, "dear", false);

        // "cart" -> "c2t". Not in dict. -> True.
        runTest(vwa, "cart", true);

        // "cane" -> "c2e". Dict has "cake" ("c2e"). val="cake" != "cane". -> False.
        runTest(vwa, "cane", false);

        // "make" -> "m2e". Not in dict. -> True.
        runTest(vwa, "make", true);

        // "cake" -> "c2e". Dict has "cake". val="cake" == "cake". -> True.
        runTest(vwa, "cake", true);
    }

    private static void runTest(ValidWordAbbr vwa, String word, boolean expected) {
        boolean result = vwa.isUnique(word);
        System.out.println("Word: " + word + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
