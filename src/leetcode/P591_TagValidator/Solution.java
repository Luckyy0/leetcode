package leetcode.P591_TagValidator;

import java.util.Stack;

class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < code.length();) {
            // If accumulated content is out of a tag (stack empty) and it's not the start
            // Nếu nội dung tích lũy nằm ngoài thẻ (ngăn xếp rỗng) và nó không phải là bắt
            // đầu
            if (i > 0 && stack.isEmpty())
                return false;

            // Check for CDATA
            // Kiểm tra CDATA
            if (code.startsWith("<![CDATA[", i)) {
                int next = code.indexOf("]]>", i + 9);
                if (next == -1)
                    return false;
                i = next + 3;
            }
            // Check for End Tag </TAG>
            // Kiểm tra Thẻ Kết Thúc </TAG>
            else if (code.startsWith("</", i)) {
                int end = code.indexOf(">", i + 2);
                if (end == -1)
                    return false;

                String tag = code.substring(i + 2, end);
                if (stack.isEmpty() || !stack.pop().equals(tag))
                    return false;

                i = end + 1;
                // If stack becomes empty, we must be at the end of code
                // Nếu ngăn xếp trở nên rỗng, chúng ta phải ở cuối mã
                if (stack.isEmpty() && i < code.length())
                    return false;
            }
            // Check for Start Tag <TAG>
            // Kiểm tra Thẻ Bắt Đầu <TAG>
            else if (code.startsWith("<", i)) {
                int end = code.indexOf(">", i + 1);
                if (end == -1)
                    return false;

                String tag = code.substring(i + 1, end);
                if (!isValidTagName(tag))
                    return false;

                stack.push(tag);
                i = end + 1;
            }
            // Regular Text
            // Văn bản Thường
            else {
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
}
