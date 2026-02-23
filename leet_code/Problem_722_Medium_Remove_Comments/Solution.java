package leet_code.Problem_722_Medium_Remove_Comments;

import java.util.*;

public class Solution {

    /**
     * Removes line and block comments from C++ source code.
     * Strategy: Character-by-character scan with a boolean "inBlock" state.
     * Time: O(S), Space: O(S).
     */
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;

        for (String line : source) {
            char[] chars = line.toCharArray();
            int i = 0;
            while (i < chars.length) {
                if (!inBlock) {
                    // Check for start of block comment
                    if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                        inBlock = true;
                        i++; // Skip both characters
                    }
                    // Check for start of line comment
                    else if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                        break; // Ignore rest of the line
                    }
                    // Regular character
                    else {
                        sb.append(chars[i]);
                    }
                } else {
                    // Current state is inside a block, check for ending
                    if (i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                        inBlock = false;
                        i++; // Skip both characters
                    }
                }
                i++;
            }

            // At the end of a line, if we are NOT in a block and have content, save it
            // This handles the case where multiple source lines are joined into one
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0); // Reset for next cohesive line
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] source = {
                "/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"
        };
        List<String> result = sol.removeComments(source);
        for (String s : result) {
            System.out.println("\"" + s + "\"");
        }
    }
}
