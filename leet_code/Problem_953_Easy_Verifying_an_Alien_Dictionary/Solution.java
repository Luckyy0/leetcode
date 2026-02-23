package leet_code.Problem_953_Easy_Verifying_an_Alien_Dictionary;

/**
 * Problem 953: Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class Solution {

    /**
     * Checks if the words are sorted lexicographically according to the alien
     * language order.
     * Strategy: Pairwise Comparison.
     * 
     * @param words Array of words.
     * @param order The alphabet order string.
     * @return true if sorted, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Tạo một mảng ánh xạ thứ tự của mỗi ký tự trong bảng chữ cái người
     *         ngoài hành tinh (`order`).
     *         `index[char - 'a'] = pos` sẽ cho biết vị trí (thứ hạng) của ký tự đó.
     *         2. Duyệt qua từng cặp từ liền kề trong danh sách `words` (so sánh từ
     *         `i` và `i+1`).
     *         3. Với mỗi cặp từ, so sánh từng ký tự tương ứng:
     *         - Nếu gặp ký tự khác nhau đầu tiên:
     *         - Nếu ký tự của từ trước có thứ hạng lớn hơn ký tự của từ sau -> Sai
     *         thứ tự, trả về `false`.
     *         - Nếu ký tự của từ trước có thứ hạng nhỏ hơn -> Cặp từ này đúng thứ
     *         tự, break vòng lặp so sánh ký tự để chuyển sang cặp từ tiếp theo.
     *         4. Trường hợp đặc biệt: Nếu so sánh hết độ dài của từ ngắn hơn mà
     *         không tìm thấy ký tự khác biệt (tức là một từ là tiền tố của từ kia):
     *         - Từ ngắn hơn phải đứng trước. Nếu từ trước dài hơn từ sau (ví dụ:
     *         "apple" và "app"), trả về `false`.
     *         5. Nếu duyệt hết tất cả các cặp từ mà không phát hiện lỗi nào, trả về
     *         `true`.
     */
    public boolean isAlienSorted(String[] words, String order) {
        // Map character to its rank/index in the alien alphabet
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        // Iterate through adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            boolean sorted = false;

            // Compare characters
            for (int k = 0; k < len; k++) {
                char c1 = w1.charAt(k);
                char c2 = w2.charAt(k);

                if (c1 != c2) {
                    // Start checking order on first difference
                    if (index[c1 - 'a'] > index[c2 - 'a']) {
                        return false; // w1 comes after w2, which is wrong
                    }
                    // Current pair is sorted correctly because c1 < c2
                    sorted = true;
                    break;
                }
            }

            // If no difference found, check if w1 is longer than w2 (e.g. "apple" > "app")
            // A shorter prefix should always come first.
            if (!sorted && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] w1 = { "hello", "leetcode" };
        String o1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println("Result: " + sol.isAlienSorted(w1, o1)); // true

        String[] w2 = { "word", "world", "row" };
        String o2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println("Result: " + sol.isAlienSorted(w2, o2)); // false ('d' comes after 'l')

        String[] w3 = { "apple", "app" };
        String o3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Result: " + sol.isAlienSorted(w3, o3)); // false
    }
}
