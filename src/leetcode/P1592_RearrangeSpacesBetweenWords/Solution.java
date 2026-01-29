package leetcode.P1592_RearrangeSpacesBetweenWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ')
                spaceCount++;
        }

        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(c);
            }
        }
        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        int n = words.size();
        StringBuilder sb = new StringBuilder();

        if (n == 1) {
            sb.append(words.get(0));
            for (int i = 0; i < spaceCount; i++)
                sb.append(' ');
            return sb.toString();
        }

        int gaps = n - 1;
        int spacesPerGap = spaceCount / gaps;
        int extraSpaces = spaceCount % gaps;

        for (int i = 0; i < n; i++) {
            sb.append(words.get(i));
            if (i < n - 1) {
                for (int k = 0; k < spacesPerGap; k++)
                    sb.append(' ');
            }
        }

        for (int k = 0; k < extraSpaces; k++)
            sb.append(' ');

        return sb.toString();
    }
}
