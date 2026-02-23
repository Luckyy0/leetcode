package leet_code.Problem_282_Hard_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    /**
     * Finds all expressions that evaluate to target.
     * Uses Backtracking with on-the-fly evaluation and precedence handling.
     * Time: O(4^N), Space: O(N).
     * 
     * Tìm tất cả các biểu thức có kết quả bằng target.
     * Sử dụng Quay lui với đánh giá trực tiếp và xử lý thứ tự ưu tiên.
     */
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, num, target, "", 0, 0, 0);
        return result;
    }

    // path: mathematical expression built so far
    // pos: current index in num
    // eval: current evaluated value
    // multed: the last term added (with sign) to handle multiplication precedence
    // multed: số hạng cuối cùng được thêm vào (với dấu) để xử lý ưu tiên phép nhân
    private void backtrack(List<String> result, String num, int target, String path, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // Leading zero check: if current block starts with '0' but has length > 1,
            // invalid.
            // Kiểm tra số 0 ở đầu: nếu khối hiện tại bắt đầu bằng '0' nhưng có độ dài > 1,
            // không hợp lệ.
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            long curr = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0) {
                // First number, just pick it
                // Số đầu tiên, chỉ cần chọn nó
                backtrack(result, num, target, path + curr, i + 1, curr, curr);
            } else {
                // ADD: eval + curr
                backtrack(result, num, target, path + "+" + curr, i + 1, eval + curr, curr);

                // SUBTRACT: eval - curr. Note multed is -curr
                backtrack(result, num, target, path + "-" + curr, i + 1, eval - curr, -curr);

                // MULTIPLY: eval - multed + multed * curr. Order of ops correction.
                // Updated multed is multed * curr
                // NHÂN: eval - multed + multed * curr. Sửa thứ tự ưu tiên.
                // Multed cập nhật là multed * curr
                backtrack(result, num, target, path + "*" + curr, i + 1, eval - multed + multed * curr, multed * curr);
            }
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "123", 6 -> ["1*2*3","1+2+3"]
        System.out.println("Ops 1: " + solution.addOperators("123", 6));

        // Test Case 2: "232", 8 -> ["2*3+2", "2+3*2"]
        System.out.println("Ops 2: " + solution.addOperators("232", 8));
    }
}
