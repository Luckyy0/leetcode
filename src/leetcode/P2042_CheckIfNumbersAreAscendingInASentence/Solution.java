package leetcode.P2042_CheckIfNumbersAreAscendingInASentence;

public class Solution {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int prev = -1;

        for (String t : tokens) {
            if (Character.isDigit(t.charAt(0))) {
                int curr = Integer.parseInt(t);
                if (curr <= prev)
                    return false;
                prev = curr;
            }
        }

        return true;
    }
}
