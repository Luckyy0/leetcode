package Problem_1048_Medium_Longest_String_Chain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. Longest String Chain
 * 
 * You are given an array of words where each word consists of lowercase English
 * letters.
 * wordA is a predecessor of wordB if and only if we can insert exactly one
 * letter anywhere in wordA
 * without changing the order of the other characters to make it equal to wordB.
 * 
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >=
 * 1,
 * where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3,
 * and so on.
 * 
 * Return the length of the longest possible word chain with words chosen from
 * the given list of words.
 */
public class Solution {

    /**
     * Dùng Quy Hoạch Động (Dynamic Programming) kết hợp Bản đồ Băm (HashMap).
     * 
     * @param words Mảng chứa các chuỗi con gốc
     * @return Chiều dài chuỗi nối ghép Tiền Hậu Dài Kỷ Lục Nhất
     */
    public int longestStrChain(String[] words) {
        // 1. Sắp xếp bộ danh sách từ theo Tăng Dần Chiều Dài
        // Vì "Kẻ Khổng Lồ" đứng phía sau chỉ có thể Nhận "Kẻ Lùn Hơn Đúng 1 Khúc" đứng
        // phía trước làm Tiền Bối
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        // Túi Thần Kỳ Memoization: Ghi nhớ Điểm Số Max Kết Thúc Tại Từng Cục Chữ Cái cụ
        // thể
        Map<String, Integer> dp = new HashMap<>();
        int absoluteMaxLength = 1; // Chiều dài tối thiểu chắc chắn luôn có nếu mảng không rỗng (Là Chính Bản Thân
                                   // Từng Kẻ Mảng)

        // 2. Xét Lướt Từng Thành viên Trong Đội Hình
        for (String currentWord : words) {
            int currentBest = 1; // Khởi xướng Điểm Kỷ Lục cho thân phận Kẻ Này Luôn Lót Tính Mốc 1

            // 3. Phẫu Thuật Rạch Cắt Thử Bỏ Đi MỘT Chữ Cái Ở Bất Cứ Đâu Trong Thân Hiện Tại
            // Để truy ngược Xem Con Thằng Nào Sẽ Thành Tiền Bối!
            for (int i = 0; i < currentWord.length(); i++) {
                // Rạch 1 nếp dao: Cắt Bỏ Mẩu [i], Dính [0...i-1] Với [i+1...Hết]
                String predecessorCandidate = currentWord.substring(0, i) + currentWord.substring(i + 1);

                // Mở Cuốn DP Quét Tìm Ống Cắm Kí Tự - Nó có thực sự nằm sẵn trong Hệ Thống
                // Không?
                if (dp.containsKey(predecessorCandidate)) {
                    // Cú Chót Lọt Nạp Bài! Thằng Tiền Bối Này Đã Từng Ráp Sẵn Gắn Với Chuỗi Kỷ Lục!
                    // Ta cướp lấy Kỷ Lục Của Chóp Tiền Bối (dp.get) Cộng Đuôi Nhồi Vào Lệnh Mình
                    // (+1)
                    currentBest = Math.max(currentBest, dp.get(predecessorCandidate) + 1);
                }
            }

            // Xăm Chốt Lại Thành Quả Khung Kỷ Lục Của "Ông Nhanh Nhất" Đợt Xác Nhập Bảng
            dp.put(currentWord, currentBest);

            // Thấm Chạm Thắt Chéo Dây Chuyền Có Độ Khúc Kỷ Lục Toàn Cuộc Chưa
            absoluteMaxLength = Math.max(absoluteMaxLength, currentBest);
        }

        return absoluteMaxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words1 = { "a", "b", "ba", "bca", "bda", "bdca" };
        System.out.println("Test 1: " + sol.longestStrChain(words1)); // Expected: 4

        String[] words2 = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
        System.out.println("Test 2: " + sol.longestStrChain(words2)); // Expected: 5

        String[] words3 = { "abcd", "dbqca" };
        System.out.println("Test 3: " + sol.longestStrChain(words3)); // Expected: 1
    }
}
