package leet_code.Problem_557_Easy_Reverse_Words_in_a_String_III;

public class Solution_Linear {

    /**
     * Reverses each word in a string.
     * Strategy: Identify word boundaries and reverse in-place in a char array.
     * Time: O(N), Space: O(N).
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0;

        while (i < n) {
            int start = i;
            // Find end of current word
            while (i < n && chars[i] != ' ') {
                i++;
            }
            // Reverse current word
            reverse(chars, start, i - 1);
            // Skip the space
            i++;
        }

        return new String(chars);
    }

    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution_Linear solution = new Solution_Linear();
        System.out.println("Result: " + solution.reverseWords("Let's take LeetCode contest"));
        // "s'teL ekat edoCteeL tsetnoc"
    }
}
