package leetcode.P1286_IteratorForCombination;

import java.util.ArrayList;
import java.util.List;

class CombinationIterator {
    private List<String> combinations;
    private int curr;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        backtrack(characters, combinationLength, 0, new StringBuilder());
        curr = 0;
    }

    private void backtrack(String s, int k, int start, StringBuilder sb) {
        if (sb.length() == k) {
            combinations.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // Need (k - sb.length()) more chars.
            // Remaining chars: s.length() - i.
            // If remaining < needed, pruning
            if (s.length() - i < k - sb.length())
                break;

            sb.append(s.charAt(i));
            backtrack(s, k, i + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    public String next() {
        return combinations.get(curr++);
    }

    public boolean hasNext() {
        return curr < combinations.size();
    }
}
