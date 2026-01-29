package leetcode.P842_SplitArrayIntoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        backtrack(num, 0, res);
        return res;
    }

    private boolean backtrack(String s, int idx, List<Integer> res) {
        if (idx == s.length() && res.size() >= 3)
            return true;

        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx)
                break; // Leading zero

            long val = Long.parseLong(s.substring(idx, i + 1));
            if (val > Integer.MAX_VALUE)
                break;

            int size = res.size();
            if (size >= 2 && val > (long) res.get(size - 1) + res.get(size - 2))
                break;

            if (size < 2 || val == (long) res.get(size - 1) + res.get(size - 2)) {
                res.add((int) val);
                if (backtrack(s, i + 1, res))
                    return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
