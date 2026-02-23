package leet_code.Problem_344_Easy_Reverse_String;

public class Solution_TwoPointers {

    /**
     * Reverses string in place.
     * Uses Two Pointers.
     * Time: O(N), Space: O(1).
     * 
     * Đảo ngược chuỗi tại chỗ.
     * Sử dụng Hai Con trỏ.
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
        solution.reverseString(s1);
        System.out.println("Result 1: " + new String(s1));

        // Test Case 2
        char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        solution.reverseString(s2);
        System.out.println("Result 2: " + new String(s2));
    }
}
