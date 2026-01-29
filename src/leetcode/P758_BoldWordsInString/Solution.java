package leetcode.P758_BoldWordsInString;

class Solution {
    public String boldWords(String[] words, String s) {
        boolean[] bold = new boolean[s.length()];

        for (String word : words) {
            int index = s.indexOf(word, 0);
            while (index != -1) {
                for (int i = index; i < index + word.length(); i++) {
                    bold[i] = true;
                }
                index = s.indexOf(word, index + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && (i == 0 || !bold[i - 1]))
                sb.append("<b>");
            sb.append(s.charAt(i));
            if (bold[i] && (i == s.length() - 1 || !bold[i + 1]))
                sb.append("</b>");
        }

        return sb.toString();
    }
}
