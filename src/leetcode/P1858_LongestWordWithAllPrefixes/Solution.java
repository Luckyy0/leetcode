package leetcode.P1858_LongestWordWithAllPrefixes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words); // Sort lexicographically first
        Set<String> valid = new HashSet<>();
        valid.add("");

        String longest = "";

        for (String word : words) {
            if (valid.contains(word.substring(0, word.length() - 1))) {
                valid.add(word);
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length()) {
                    // Since sorted lexicographically, first one found is best?
                    // Wait. Arrays.sort gives a, ab, abc.
                    // Iterating: a valid. ab valid. abc valid.
                    // b, ba...
                    // Loop order: a, aa, ab ...
                    // If we update only on strict length > longest, we keep the lexicographically
                    // first one seen.
                    // Yes, Arrays.sort puts "apple" before "apply".
                    // So if lengths equal, first one is cleaner.
                    // Wait, logic: if (len > max) update.
                    // What if we see 'a' then 'b' (len 1). 'a' is kept.
                    // What if we see 'ba' (len 2) then 'ab' (len 2)?
                    // 'ab' comes before 'ba' in sort. Processed first. kept.
                    // So condition: `word.length() > longest.length()` is sufficient.
                }
            }
        }

        return longest;
    }
}
