package leetcode.P527_WordAbbreviation;

import java.util.*;

class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        int n = words.size();
        String[] ans = new String[n];
        int[] prefix = new int[n];

        // Initial abbreviation with prefix length 1
        // Viết tắt ban đầu với độ dài tiền tố 1
        for (int i = 0; i < n; i++) {
            prefix[i] = 1;
            ans[i] = makeAbbr(words.get(i), 1);
        }

        // Loop until there are no duplicates
        // Lặp cho đến khi không còn trùng lặp
        for (int i = 0; i < n; i++) {
            while (true) {
                Set<Integer> duplicates = new HashSet<>();
                // Check all other words for collision with word i
                // Kiểm tra tất cả các từ khác có va chạm với từ i không
                for (int j = i + 1; j < n; j++) {
                    if (ans[i].equals(ans[j])) {
                        duplicates.add(j);
                    }
                }

                // If no duplicates, break
                // Nếu không có trùng lặp, thoát vòng lặp
                if (duplicates.isEmpty())
                    break;

                // Solve collision by increasing prefix length
                // Giải quyết va chạm bằng cách tăng độ dài tiền tố
                duplicates.add(i);
                for (int k : duplicates) {
                    prefix[k]++;
                    ans[k] = makeAbbr(words.get(k), prefix[k]);
                }
            }
        }

        return Arrays.asList(ans);
    }

    // Helper to generate abbreviation
    // Hàm phụ trợ để tạo từ viết tắt
    private String makeAbbr(String s, int k) {
        if (k >= s.length() - 2) {
            return s;
        }
        return s.substring(0, k) + (s.length() - 1 - k) + s.charAt(s.length() - 1);
    }
}
