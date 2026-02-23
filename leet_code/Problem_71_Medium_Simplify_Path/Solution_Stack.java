package leet_code.Problem_71_Medium_Simplify_Path;

import java.util.*;

public class Solution_Stack {

    /**
     * Simplifies a Unix-style absolute path.
     * Uses a Deque (acting as a stack) to manage directory levels.
     * Rút gọn đường dẫn tuyệt đối kiểu Unix.
     * Sử dụng Deque (đóng vai trò như một ngăn xếp) để quản lý các cấp độ thư mục.
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                // Return to parent directory if possible
                // Trở về thư mục cha nếu có thể
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                // Add directory name to stack
                // Thêm tên thư mục vào ngăn xếp
                stack.push(component);
            }
        }

        // Construct the result path
        // Xây dựng đường dẫn kết quả
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        // UseDescendingIterator because we pushed into the stack (LIFO)
        // Using descendingIterator to get items in FIFO order for the path
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append("/").append(it.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.simplifyPath("/home/"));
        // Expected: "/home"

        // Test Case 2
        System.out.println("Test Case 2: " + solution.simplifyPath("/../"));
        // Expected: "/"

        // Test Case 3
        System.out.println("Test Case 3: " + solution.simplifyPath("/home//foo/"));
        // Expected: "/home/foo"

        // Test Case 4
        System.out.println("Test Case 4: " + solution.simplifyPath("/a/./b/../../c/"));
        // Expected: "/c"
    }
}
