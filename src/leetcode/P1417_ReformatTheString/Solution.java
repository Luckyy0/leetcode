package leetcode.P1417_ReformatTheString;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                digits.add(c);
            else
                letters.add(c);
        }

        if (Math.abs(letters.size() - digits.size()) > 1)
            return "";

        boolean digitFirst = digits.size() >= letters.size();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < digits.size() || j < letters.size()) {
            if (digitFirst) {
                if (i < digits.size())
                    sb.append(digits.get(i++));
                if (j < letters.size())
                    sb.append(letters.get(j++));
            } else {
                if (j < letters.size())
                    sb.append(letters.get(j++));
                if (i < digits.size())
                    sb.append(digits.get(i++));
            }
        }

        return sb.toString();
    }
}
