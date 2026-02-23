package leet_code.Problem_843_Hard_Guess_the_Word;

import java.util.*;

/**
 * Interface provided by LeetCode.
 */
interface Master {
    public int guess(String word);
}

/**
 * Problem 843: Guess the Word
 * https://leetcode.com/problems/guess-the-word/
 */
public class Solution {

    /**
     * Finds the secret word in at most 10 guesses.
     * Strategy: Refine the candidate list by filtering out words that
     * don't have the same number of matches with the current guess.
     * 
     * @param wordlist List of unique 6-letter strings.
     * @param master   The interface to call guess().
     * 
     *                 Tóm tắt chiến lược:
     *                 1. Duy trì một danh sách các từ có khả năng là từ bí mật.
     *                 2. Chọn một từ bất kỳ từ danh sách (nên chọn ngẫu nhiên để
     *                 tránh trường hợp xấu nhất).
     *                 3. Gọi hàm master.guess(word) và nhận kết quả là số lượng ký
     *                 tự khớp 'n'.
     *                 4. Lọc danh sách: Chỉ giữ lại các từ có đúng 'n' ký tự khớp
     *                 với từ vừa đoán.
     *                 Vì từ bí mật thực sự chắc chắn phải đáp ứng điều kiện này.
     *                 5. Lặp lại cho đến khi tìm được từ bí mật (khớp 6 ký tự) hoặc
     *                 hết số lượt đoán.
     */
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> candidates = new ArrayList<>(Arrays.asList(wordlist));
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            // Pick a random word from the current candidate list
            String guessWord = candidates.get(rand.nextInt(candidates.size()));
            int matches = master.guess(guessWord);

            // Found the secret word
            if (matches == 6)
                return;

            // Refine the candidate list
            List<String> nextCandidates = new ArrayList<>();
            for (String w : candidates) {
                if (getMatches(w, guessWord) == matches) {
                    nextCandidates.add(w);
                }
            }
            candidates = nextCandidates;
        }
    }

    /**
     * Calculates exact character matches between two strings.
     */
    private int getMatches(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                count++;
        }
        return count;
    }

    // Main method for testing logic is omitted due to the Master interface
    // being internal to the platform.
}
