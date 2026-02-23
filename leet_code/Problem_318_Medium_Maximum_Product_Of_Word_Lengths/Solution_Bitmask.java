package leet_code.Problem_318_Medium_Maximum_Product_Of_Word_Lengths;

public class Solution_Bitmask {

    /**
     * Finds max product of word lengths with no common letters.
     * Uses Bitmask to represent character sets.
     * Time: O(N*L + N^2), Space: O(N).
     * 
     * Tìm tích lớn nhất của độ dài từ không có ký tự chung.
     * Sử dụng Bitmask để biểu diễn tập ký tự.
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        // Precompute masks and lengths
        // Tính toán trước masks và độ dài
        for (int i = 0; i < n; i++) {
            String w = words[i];
            lens[i] = w.length();

            for (char c : w.toCharArray()) {
                masks[i] |= 1 << (c - 'a');
            }
        }

        int maxVal = 0;

        // Check all pairs
        // Kiểm tra tất cả các cặp
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If no common bits set, they share no characters
                // Nếu không có bit chung nào được đặt, chúng không chia sẻ ký tự
                if ((masks[i] & masks[j]) == 0) {
                    maxVal = Math.max(maxVal, lens[i] * lens[j]);
                }
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution_Bitmask solution = new Solution_Bitmask();

        // Test Case 1
        String[] w1 = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println("Max Product 1: " + solution.maxProduct(w1)); // 16 ("abcw", "xtfn")

        // Test Case 2
        String[] w2 = { "a", "ab", "abc", "d", "cd", "bcd", "abcd" };
        System.out.println("Max Product 2: " + solution.maxProduct(w2)); // 4 ("ab", "cd")
    }
}
