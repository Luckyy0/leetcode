package leet_code.Problem_389_Easy_Find_The_Difference;

public class Solution_Bitwise {

    /**
     * Finds the added letter.
     * Use XOR bitwise logic.
     * Time: O(N), Space: O(1).
     * 
     * Tìm chữ cái được thêm vào.
     * Sử dụng logic bitwise XOR.
     */
    public char findTheDifference(String s, String t) {
        char res = 0;

        // XOR all characters in string s
        // XOR tất cả các ký tự trong chuỗi s
        for (char c : s.toCharArray()) {
            res ^= c;
        }

        // XOR all characters in string t
        // XOR tất cả các ký tự trong chuỗi t
        for (char c : t.toCharArray()) {
            res ^= c;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: "abcd", "abcde" -> 'e'
        System.out.println("Result 1: " + solution.findTheDifference("abcd", "abcde"));

        // Test Case 2: "", "y" -> 'y'
        System.out.println("Result 2: " + solution.findTheDifference("", "y"));
    }
}
