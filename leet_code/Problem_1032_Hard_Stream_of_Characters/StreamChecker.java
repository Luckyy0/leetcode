package leet_code.Problem_1032_Hard_Stream_of_Characters;

/**
 * Problem 1032: Stream of Characters
 * https://leetcode.com/problems/stream-of-characters/
 */
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false; // Đánh dấu điểm kết thúc của 1 từ vựng Lật ngược
}

public class StreamChecker {
    private TrieNode root;
    private StringBuilder streamHistory;

    // Đặc tả Độ Dài Khủng Bố Nhất của Từ Vựng Mẫu để Làm Phanh Hãm TLE tối đa
    private int maxWordLength = 0;

    /**
     * Khởi tạo Cây Tiền Tố (Trie) Đột Biến Ngược.
     * Strategy: Ngọn Nước Trie Cắm Ngược Rễ (Trie from End to Start).
     * 
     * Tóm tắt chiến lược:
     * 1. Nỗi đau Dò Hậu Tố: Lắm chữ nghĩa nhét vào, Bắt Xét xem CÁI ĐUÔI VỪA RÓT
     * có bằng 1 Từ trong Danh bạ (Ví dụ đuôi "xyz" sinh lốc Lịch sử "axx_xyz")?
     * -> Tính Nắm Đuôi So Đít là Trọng Tội TLE, cực kì Nặng Bộ Nhớt (JVM String).
     * 2. Giải Pháp Hoang Tưởng: SÁNG TẠO LỘN NGƯỢC!
     * - Mình đem Cắm Lộn Đầu cái Danh bạ Mẫu: Từ "xyz" lật thành "zyx" và Nhét vào
     * Trie.
     * - Khi Có Từ "c" Mới Rót vô Lịch sử: Mình cứ móc Bọn Lịch Sử từ Mông Lôi Nắm
     * Ngược Lên Trên! => Việc Dò Đuôi (Suffix) đã HÓA THÀNH Dò Ngọn (Prefix) Cực
     * Nhanh!
     * 3. Cơ Chế Trie Lật Ngược Huyền Thoại:
     * - Trie được đúc cắm Dạng Lá Toa Tỏa 26 Cành Chữ Cái.
     * - Mỗi Hạt Mầm có Biển Cắm Cờ (isWord).
     * - Ta vuốt dọc Cuộn Lịch Sử Bị Trào Xoay Lộn Vụt Lên... Lách Trúng Biển Cắm Cờ
     * LÀ TUYÊN BỐ THẮNG LỢI: YES!!
     * - Ép Thẻ Phanh Gắt (maxWordLength): Thay vì trượt lết tới đáy 40.000 lịch sử
     * rót
     * tuột quần, Ranh Giới Gắn Phanh chỉ giới hạn lùng đúng Tọa Độ Vết Cắm Từ Điển
     * Dày Nhất (VD: Chữ béo nhất danh bạ chỉ có 200 chữ, Mày chạy quá 200 kí tự là
     * Thằng Hâm, phanh lại Ngay!).
     */
    public StreamChecker(String[] words) {
        root = new TrieNode();
        streamHistory = new StringBuilder();

        for (String word : words) {
            maxWordLength = Math.max(maxWordLength, word.length()); // Trị cốt lót đệm Dừng Mù
            TrieNode node = root;

            // Ép Hạt Dựng Cây: Đi Lùi Từ Mông Cột ("xyz" -> 'z' trước xong 'y', 'x')
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index]; // Móc Nhấn Thụt Kẽ Đá Trôi Xuống Lõi
            }
            node.isWord = true; // Yểm Bùa Báo Thắng Trận (Đây là Cái Đích Nghĩa Cuối Cùng Của Mật Nhánh)
        }
    }

    /**
     * Bơm Nước Chữ Letter Nhỏ Giọt vào Luồng và Báo Cáo Liệu Nó Có Vẩy Trúng Vệt
     * Lịch Sử Kết Tủa Nào Không.
     */
    public boolean query(char letter) {
        streamHistory.append(letter); // Nhẹ Dán Keo Dính Cọng Lát Hạt Tiêu (Luôn Dán Ở Cuối)
        TrieNode node = root;
        int n = streamHistory.length();

        // Quét Nhện Đuổi Xác (Scan Từ Đáy Lịch Sử Rút Băng Ngược Lên!)
        // Phanh Gấp Khẩn Cấp (i >= 0 && n - i <= maxWordLength): Mày chạy đến Mức Giới
        // đỉnh dài nhất mảng danh bạ thì Cút Ngay, tốn CPU!
        for (int i = n - 1; i >= 0 && n - i <= maxWordLength; i--) {
            char c = streamHistory.charAt(i);
            int index = c - 'a';

            // Chệch Đường Ray? Đâm Đầu Vào Xô Rác Hẻm Cụt -> Biến Mất Cửa Sống (False)
            if (node.children[index] == null) {
                return false;
            }
            // Vẫn Càng Lên Sâu Chui Đúng Cửa Ray Lệ!
            node = node.children[index];

            // Khớp Ngàm? Rớt Trúng Quả Sủng Mật Đỉnh isWord Cờ Đỏ Gào Thét? Lụm Chóp Thành
            // Công!
            if (node.isWord) {
                return true;
            }
        }

        return false;
    }

    /*
     * Dàn Test Lính Tập (Vô Cực Output Stream)
     */
    public static void main(String[] args) {
        String[] words = { "cd", "f", "kl" };
        StreamChecker streamChecker = new StreamChecker(words);

        System.out.println("Query 'a': " + streamChecker.query('a')); // false
        System.out.println("Query 'b': " + streamChecker.query('b')); // false
        System.out.println("Query 'c': " + streamChecker.query('c')); // false
        System.out.println("Query 'd': " + streamChecker.query('d')); // true ("cd" match)
        System.out.println("Query 'e': " + streamChecker.query('e')); // false
        System.out.println("Query 'f': " + streamChecker.query('f')); // true ("f" match)
        System.out.println("Query 'g': " + streamChecker.query('g')); // false
        System.out.println("Query 'h': " + streamChecker.query('h')); // false
        System.out.println("Query 'i': " + streamChecker.query('i')); // false
        System.out.println("Query 'j': " + streamChecker.query('j')); // false
        System.out.println("Query 'k': " + streamChecker.query('k')); // false
        System.out.println("Query 'l': " + streamChecker.query('l')); // true ("kl" match)
    }
}
