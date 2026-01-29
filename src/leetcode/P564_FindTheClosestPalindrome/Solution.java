package leetcode.P564_FindTheClosestPalindrome;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        List<Long> candidates = new ArrayList<>();

        // Edge cases like 999...9 or 100...01
        // Các trường hợp biên như 999...9 hoặc 100...01
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);

        // Generate palindromes by mirroring the prefix
        // Tạo palindrome bằng cách đối xứng tiền tố
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            String p = String.valueOf(prefix + i);
            sb.append(p);

            // Mirror logic: if len is odd, exclude last char of prefix. If even, mirror
            // all.
            // Logic đối xứng: nếu len lẻ, loại trừ ký tự cuối của tiền tố. Nếu chẵn, đối
            // xứng tất cả.
            StringBuilder suffix = new StringBuilder(p).reverse();
            if (len % 2 != 0) {
                sb.append(suffix.substring(1));
            } else {
                sb.append(suffix);
            }

            candidates.add(Long.parseLong(sb.toString()));
        }

        long closest = -1;

        for (long cand : candidates) {
            if (cand == num)
                continue; // Exclude itself / Loại trừ chính nó

            if (closest == -1 ||
                    Math.abs(cand - num) < Math.abs(closest - num) ||
                    (Math.abs(cand - num) == Math.abs(closest - num) && cand < closest)) {
                closest = cand;
            }
        }

        return String.valueOf(closest);
    }
}
