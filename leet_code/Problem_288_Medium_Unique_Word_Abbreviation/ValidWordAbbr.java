package leet_code.Problem_288_Medium_Unique_Word_Abbreviation;

import java.util.HashMap;
import java.util.Map;

public class ValidWordAbbr {

    private final Map<String, String> map;

    /**
     * Initializes the ValidWordAbbr with a dictionary.
     * Uses HashMap to store abbreviation -> word mapping.
     * Handles collisions by marking them.
     * Time: O(N*L), Space: O(N*L).
     * 
     * Khởi tạo ValidWordAbbr với một từ điển.
     * Sử dụng HashMap để lưu ánh xạ từ viết tắt -> từ.
     * Xử lý va chạm bằng cách đánh dấu chúng.
     */
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = getAbbreviation(s);
            if (map.containsKey(abbr)) {
                // If collision with a DIFFERENT word, mark as invalid ""
                // Nếu va chạm với một từ KHÁC, đánh dấu là không hợp lệ ""
                if (!map.get(abbr).equals(s)) {
                    map.put(abbr, "");
                }
                // If collision with SAME word, do nothing (it's fine)
                // Nếu va chạm với CÙNG một từ, không làm gì cả (vẫn ổn)
            } else {
                map.put(abbr, s);
            }
        }
    }

    /**
     * Checks if the word's abbreviation is unique.
     * Kiểm tra xem từ viết tắt của từ có là duy nhất không.
     */
    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        // Case 1: Abbreviation not in dictionary -> Unique
        // Trường hợp 1: Từ viết tắt không có trong từ điển -> Duy nhất
        if (!map.containsKey(abbr)) {
            return true;
        }
        // Case 2: Abbreviation in dictionary AND associated strictly with this word
        // Trường hợp 2: Từ viết tắt có trong từ điển VÀ liên kết chặt chẽ với từ này
        return map.get(abbr).equals(word);
    }

    private String getAbbreviation(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
    }

    public static void main(String[] args) {
        String[] dictionary = { "deer", "door", "cake", "card" };
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);

        System.out.println("isUnique(dear): " + validWordAbbr.isUnique("dear")); // false
        System.out.println("isUnique(cart): " + validWordAbbr.isUnique("cart")); // true
        System.out.println("isUnique(cake): " + validWordAbbr.isUnique("cake")); // true
    }
}
