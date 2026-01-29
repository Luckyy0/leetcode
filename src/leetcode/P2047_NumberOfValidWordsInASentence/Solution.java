package leetcode.P2047_NumberOfValidWordsInASentence;

public class Solution {
    public int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split("\\s+");
        int count = 0;

        for (String t : tokens) {
            if (isValid(t))
                count++;
        }
        return count;
    }

    private boolean isValid(String s) {
        if (s.isEmpty())
            return false;
        int n = s.length();
        int hyphens = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                return false;

            if (c == '-') {
                hyphens++;
                if (hyphens > 1)
                    return false;
                // Hyphen must be surrounded by letters
                if (i == 0 || i == n - 1)
                    return false;
                if (!Character.isLowerCase(s.charAt(i - 1)) || !Character.isLowerCase(s.charAt(i + 1)))
                    return false;
            } else if (c == '!' || c == '.' || c == ',') {
                // Punctuation must be at the end
                if (i != n - 1)
                    return false;
            } else if (!Character.isLowerCase(c)) {
                // Invalid character (should not happen based on problem desc 'lowercase
                // letters, hyphens, punctuation' but safety check)
                return false;
            }
        }

        return true;
    }
}
