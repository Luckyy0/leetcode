package leetcode.P1832_CheckIfTheSentenceIsPangram;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> seen = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            seen.add(c);
        }
        return seen.size() == 26;
    }
}
