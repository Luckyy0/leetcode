package leet_code.Problem_68_Hard_Text_Justification;

import java.util.*;

public class Solution_Simulation {

    /**
     * Formats text into fully justified lines.
     * Uses simulation and greedy word packing.
     * Định dạng văn bản thành các dòng căn lề đều.
     * Sử dụng mô phỏng và đóng gói từ tham lam.
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0;

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            res.add(justify(left, right, words, maxWidth));
            left = right;
        }

        return res;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        // words[right] + 1 space
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        return right;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 1)
            return padRight(words[left], maxWidth);

        boolean isLastLine = (right == words.length);
        int numWords = right - left;
        int numSpaces = numWords - 1;

        StringBuilder sb = new StringBuilder();

        if (isLastLine) {
            for (int i = left; i < right; i++) {
                sb.append(words[i]);
                if (i < right - 1)
                    sb.append(" ");
            }
            return padRight(sb.toString(), maxWidth);
        }

        int totalCharLen = 0;
        for (int i = left; i < right; i++)
            totalCharLen += words[i].length();

        int totalSpaces = maxWidth - totalCharLen;
        int spacesBetween = totalSpaces / numSpaces;
        int extraSpaces = totalSpaces % numSpaces;

        for (int i = left; i < right; i++) {
            sb.append(words[i]);
            if (i < right - 1) {
                int s = spacesBetween + (i - left < extraSpaces ? 1 : 0);
                for (int m = 0; m < s; m++)
                    sb.append(" ");
            }
        }

        return sb.toString();
    }

    private String padRight(String s, int maxWidth) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < maxWidth)
            sb.append(" ");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();

        // Test Case 1
        String[] w1 = { "This", "is", "an", "example", "of", "text", "justification." };
        List<String> r1 = solution.fullJustify(w1, 16);
        System.out.println("Test Case 1:");
        for (String s : r1)
            System.out.println("\"" + s + "\"");

        // Test Case 2
        String[] w2 = { "What", "must", "be", "acknowledgment", "shall", "be" };
        List<String> r2 = solution.fullJustify(w2, 12);
        System.out.println("\nTest Case 2:");
        for (String s : r2)
            System.out.println("\"" + s + "\"");
    }
}
