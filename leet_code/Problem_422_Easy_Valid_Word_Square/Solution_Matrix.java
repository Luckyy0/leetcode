package leet_code.Problem_422_Easy_Valid_Word_Square;

import java.util.List;

public class Solution_Matrix {

    /**
     * Checks if a sequence of strings forms a valid word square.
     * Logic: char at row i, col j must equal char at row j, col i.
     * Time: O(Total Chars), Space: O(1).
     * 
     * Kiểm tra xem một dãy chuỗi có tạo thành hình vuông từ vựng hợp lệ không.
     * Logic: ký tự tại hàng i, cột j phải bằng ký tự tại hàng j, cột i.
     */
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.isEmpty())
            return true;

        int n = words.size();
        for (int i = 0; i < n; i++) {
            String rowWord = words.get(i);
            for (int j = 0; j < rowWord.length(); j++) {
                // Check if the corresponding mirror character exists and matches
                // Kiểm tra xem ký tự đối xứng tương ứng có tồn tại và khớp không

                // 1. Check if row j exists
                if (j >= n)
                    return false;

                // 2. Check if word at row j has character i
                if (i >= words.get(j).length())
                    return false;

                // 3. Compare characters
                if (rowWord.charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Matrix solution = new Solution_Matrix();

        // Test Case 1: true
        List<String> words1 = List.of("abcd", "bnrt", "crmy", "dtye");
        System.out.println("Result 1: " + solution.validWordSquare(words1));

        // Test Case 2: true (irregular shape)
        List<String> words2 = List.of("abcd", "bnrt", "crm", "dt");
        System.out.println("Result 2: " + solution.validWordSquare(words2));

        // Test Case 3: false
        List<String> words3 = List.of("ball", "area", "read", "lady");
        System.out.println("Result 3: " + solution.validWordSquare(words3));
    }
}
