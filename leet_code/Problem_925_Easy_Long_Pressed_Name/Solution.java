package leet_code.Problem_925_Easy_Long_Pressed_Name;

/**
 * Problem 925: Long Pressed Name
 * https://leetcode.com/problems/long-pressed-name/
 */
public class Solution {

    /**
     * Checks if typed string can be a long-pressed version of name.
     * Strategy: Two Pointers.
     * 
     * @param name  The original name.
     * @param typed The possibly long-pressed typed string.
     * @return True if valid, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng hai con trỏ `i` (cho `name`) và `j` (cho `typed`).
     *         2. Duyệt qua chuỗi `typed`:
     *         - Nếu ký tự `name[i]` khớp với `typed[j]`, thì cả hai cùng tiến
     *         (`i++`, `j++`).
     *         - Nếu không khớp, nhưng `typed[j]` giống với ký tự trước đó
     *         `typed[j-1]`
     *         (tức là bị nhấn lâu), thì chỉ `j` tiến (`j++`).
     *         - Nếu không khớp và cũng không phải nhấn lâu (hoặc là ký tự đầu
     *         tiên), trả về false.
     *         3. Cuối cùng, kiểm tra xem đã duyệt hết tất cả các ký tự của `name`
     *         chưa (`i == name.length`).
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        int m = name.length();
        int n = typed.length();

        while (j < n) {
            if (i < m && name.charAt(i) == typed.charAt(j)) {
                // If characters match, move both pointers
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // If typed char is a repeat of previous, it's a long press
                j++;
            } else {
                // Mismatch and not a long press
                return false;
            }
        }

        // Ensure all characters in name were matched
        return i == m;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.isLongPressedName("alex", "aaleex")); // true
        System.out.println("Result: " + sol.isLongPressedName("saeed", "ssaaedd")); // false
    }
}
