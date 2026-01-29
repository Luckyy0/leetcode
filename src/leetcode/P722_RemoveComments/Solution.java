package leetcode.P722_RemoveComments;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;

        for (String line : source) {
            if (!inBlock)
                sb = new StringBuilder();

            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!inBlock) {
                    if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                        inBlock = true;
                        i++; // Skip '*'
                    } else if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                        break; // Line comment, skip the rest of line
                    } else {
                        sb.append(chars[i]);
                    }
                } else {
                    if (i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                        inBlock = false;
                        i++; // Skip '/'
                    }
                }
            }

            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
            }
        }

        return res;
    }
}
