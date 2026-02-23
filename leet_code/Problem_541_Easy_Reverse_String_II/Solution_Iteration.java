package leet_code.Problem_541_Easy_Reverse_String_II;

public class Solution_Iteration {

    /**
     * Reverses first k chars for every 2k chars.
     * Strategy: Iterate with step 2k, swap range [i, min(i+k-1, n-1)].
     * Time: O(N), Space: O(N) (for char array conversion).
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution_Iteration solution = new Solution_Iteration();
        System.out.println("Result: " + solution.reverseStr("abcdefg", 2)); // "bacdfeg"
    }
}
