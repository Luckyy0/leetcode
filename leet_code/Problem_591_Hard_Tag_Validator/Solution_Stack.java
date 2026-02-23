package leet_code.Problem_591_Hard_Tag_Validator;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Validates a code snippet against tag and CDATA rules.
     * Strategy: Manual parsing with a Stack for nested tags.
     * Time: O(N), Space: O(N).
     */
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;

        while (i < code.length()) {
            // Case: Potential Tag or CDATA
            if (code.startsWith("<![CDATA[", i)) {
                // CDATA must be inside a tag
                if (stack.isEmpty())
                    return false;

                int end = code.indexOf("]]>", i + 9);
                if (end == -1)
                    return false;
                i = end + 3;
            } else if (code.startsWith("</", i)) {
                // Closing Tag
                int end = code.indexOf(">", i + 2);
                if (end == -1)
                    return false;

                String tagName = code.substring(i + 2, end);
                if (stack.isEmpty() || !stack.pop().equals(tagName))
                    return false;

                i = end + 1;
                // Rule: If stack is empty, it must be the end of the entire code
                if (stack.isEmpty() && i < code.length())
                    return false;
            } else if (code.startsWith("<", i)) {
                // Opening Tag
                int end = code.indexOf(">", i + 1);
                if (end == -1)
                    return false;

                String tagName = code.substring(i + 1, end);
                if (!isValidTagName(tagName))
                    return false;

                stack.push(tagName);
                i = end + 1;
            } else {
                // Content (Text)
                if (stack.isEmpty())
                    return false;
                i++;
            }
        }

        return stack.isEmpty();
    }

    private boolean isValidTagName(String tag) {
        if (tag.length() < 1 || tag.length() > 9)
            return false;
        for (char c : tag.toCharArray()) {
            if (!Character.isUpperCase(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();
        String code1 = "<DIV>This is the first line <![CDATA[<div>]]><BR/></DIV>";
        System.out.println("Code 1: " + solution.isValid(code1)); // true

        String code2 = "<A><![CDATA[</A>]]>abc</A>";
        System.out.println("Code 2: " + solution.isValid(code2)); // false (abc after root closure if handled
                                                                  // incorrectly)
    }
}
