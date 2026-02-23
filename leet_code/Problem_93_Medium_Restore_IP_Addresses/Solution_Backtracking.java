package leet_code.Problem_93_Medium_Restore_IP_Addresses;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Restores valid IP addresses from a string of digits.
     * Uses backtracking to try all possible dot placements.
     * Khôi phục các địa chỉ IP hợp lệ từ một chuỗi các chữ số.
     * Sử dụng quay lui để thử tất cả các cách đặt dấu chấm có thể.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return res;
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> current, List<String> res) {
        // Base case: 4 segments found
        // Trường hợp cơ sở: tìm thấy 4 phân đoạn
        if (current.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", current));
            }
            return;
        }

        // Optimization: if too few or too many characters left
        // Tối ưu hóa: nếu còn quá ít hoặc quá nhiều ký tự
        int remainingChars = s.length() - start;
        int remainingSegments = 4 - current.size();
        if (remainingChars < remainingSegments || remainingChars > remainingSegments * 3) {
            return;
        }

        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String segment = s.substring(start, start + len);

            // Validate segment
            // Kiểm tra phân đoạn
            if (isValid(segment)) {
                current.add(segment);
                backtrack(s, start + len, current, res);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        // Leading zero only allowed for "0"
        // Số 0 ở đầu chỉ được chấp nhận cho "0"
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "25525511135"
        System.out.println("Test Case 1: " + solution.restoreIpAddresses("25525511135"));
        // Expected: [255.255.11.135, 255.255.111.35]

        // Test Case 2: "0000"
        System.out.println("Test Case 2: " + solution.restoreIpAddresses("0000"));
        // Expected: [0.0.0.0]

        // Test Case 3: "101023"
        System.out.println("Test Case 3: " + solution.restoreIpAddresses("101023"));
        // Expected: [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
    }
}
