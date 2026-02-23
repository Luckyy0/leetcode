package leet_code.Problem_409_Easy_Longest_Palindrome;

public class Solution_Greedy {

    /**
     * Calculates the length of the longest palindrome.
     * Use greedy approach with frequency counts.
     * Time: O(N), Space: O(1).
     * 
     * Tính toán độ dài của chuỗi đối xứng dài nhất.
     * Sử dụng phương pháp tham lam với việc đếm tần suất.
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        for (int v : count) {
            // Add the largest even part of each count
            // Cộng thêm phần chẵn lớn nhất của mỗi tần suất
            length += (v / 2) * 2;
        }

        // If there's at least one odd count, we can add 1 for the middle
        // Nếu có ít nhất một tần suất lẻ, ta có thể cộng thêm 1 cho vị trí giữa
        if (length < s.length()) {
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: "abccccdd" -> 7
        System.out.println("Result 1: " + solution.longestPalindrome("abccccdd"));

        // Test Case 2: "a" -> 1
        System.out.println("Result 2: " + solution.longestPalindrome("a"));
    }
}
