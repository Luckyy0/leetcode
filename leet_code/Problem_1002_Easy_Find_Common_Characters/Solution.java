package leet_code.Problem_1002_Easy_Find_Common_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 1002: Find Common Characters
 * https://leetcode.com/problems/find-common-characters/
 */
public class Solution {

    /**
     * Finds common characters appearing in all given words.
     * Strategy: Minimum Frequency Array.
     * 
     * @param words Array of strings.
     * @return List of common characters, including duplicates.
     * 
     *         Tóm tắt chiến lược:
     *         1. Để một ký tự xuất hiện trong TẤT CẢ các chuỗi, ta cần theo dõi tần
     *         suất xuất hiện Nhỏ Nhất (Minimum Frequency) của nó trên toàn bộ mảng
     *         các từ `words`.
     *         2. Ta chỉ có 26 chữ cái in thường (a-z), thay vì dùng HashMaps, ta
     *         dùng 1 mảng tĩnh độ dài 26 phần tử (từ 0-25) để đếm, cực kỳ hiệu quả
     *         về tốc độ và bộ nhớ.
     *         3. Khởi tạo mảng `minFreq` với chỉ số tối đa (Integer.MAX_VALUE) để
     *         quá trình đè Min không bị lỗi.
     *         4. Lặp qua từng `word` trong `words`:
     *         - Tạo một mảng đếm tần suất CỤC BỘ tên là `currentFreq[26]` và đếm số
     *         lượng ký tự của từ đó.
     *         - Sau khi đếm xong một từ, ta cập nhật lại mảng TOÀN CỤC `minFreq`
     *         bằng cách lấy giá trị nhỏ nhất giữa nó và `currentFreq`:
     *         `minFreq[i] = Math.min(minFreq[i], currentFreq[i])`.
     *         5. Khi lặp xong toàn bộ mảng `words`, mảng `minFreq` sẽ chứa tần suất
     *         chung nhỏ nhất của từng ký tự.
     *         6. Lặp từ 0 đến 25, với mỗi chỉ số `i`, nếu giá trị `minFreq[i] > 0`,
     *         ta đắp bấy nhiêu chữ cái tương ứng (`(char) (i + 'a')`) vào mảng kết
     *         quả trả về `result`.
     */
    public List<String> commonChars(String[] words) {
        // Master frequency array to keep track of the minimum frequencies
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        // Loop over each word
        for (String word : words) {
            // Local frequency array for the current word
            int[] currentFreq = new int[26];
            for (char c : word.toCharArray()) {
                currentFreq[c - 'a']++;
            }

            // Update the master minimum frequency array
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], currentFreq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        // Convert the frequencies back to strings
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words1 = { "bella", "label", "roller" };
        System.out.println("Result 1: " + sol.commonChars(words1)); // [e, l, l]

        String[] words2 = { "cool", "lock", "cook" };
        System.out.println("Result 2: " + sol.commonChars(words2)); // [c, o]
    }
}
