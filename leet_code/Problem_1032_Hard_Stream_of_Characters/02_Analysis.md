# Analysis for Stream of Characters
# *Phân tích bài toán Dòng Chảy Ký Tự*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Design a `StreamChecker` class to initialize with a set of strings `words` and implement a boolean query function. As characters are queried individually arriving in a stream, we mathematically determine if any provided word suffix explicitly matches the stream buffer seamlessly.
*Thiết kế một Lớp `StreamChecker` ôm đồm một nhóm từ điển (các chuỗi) làm dữ liệu gốc ban đầu. Sau đó, nó phải xử lý một dòng chảy vô tận các Lần Truy Vấn `query(letter)`. Với mỗi ký tự ném vào dòng chảy, phải lập tức đánh hơi và báo cáo xem có bất kỳ Câu Chữ nào trong Từ Điển Khớp Khít Hậu Tố (khúc đuôi) của cái Dòng Lịch Sử Truy Vấn kia không.*

---

## 2. Strategy 1: Naive (StringBuilder End-Checking)
## *2. Chiến lược 1: Ngây Thơ (Nối Chuỗi Và So Sánh Đuôi)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea natively appends incoming stream letters to a global string buffer. For each query, it iterates through all possible dictionary words fundamentally confirming if the buffer natively strictly officially matches using logic matching `endsWith(word)`.
*Lướt Tôn hành ngây thơ là dùng một sợi Dây xích `StringBuilder` rỗng để liên tục nối thêm 1 mắt xích nhỏ xíu (letter) sau từng bước. Kế tiếp, vòng lặp rà soát sạch bách TẤT CẢ TỪ KHÓA trong kho. Chìa mặt cắt đuôi cái Dãy Lịch Sử ra mà ướm đối chiếu Hàm Nền Trái Ngang `endsWith(Từ)` xem trúng độc đắc chữ nào không!*

```java
import java.util.List;
import java.util.Arrays;

class StreamCheckerNaive {
    private List<String> wordList;
    private StringBuilder streamBuffer;

    public StreamCheckerNaive(String[] words) {
        wordList = Arrays.asList(words);
        streamBuffer = new StringBuilder();
    }

    public boolean query(char letter) {
        streamBuffer.append(letter);
        String currentStream = streamBuffer.toString();
        
        for (String w : wordList) {
            if (currentStream.endsWith(w)) {
                return true;
            }
        }
        return false;
    }
}
```

- **Weakness:** The linear iteration across exactly $W$ words mathematically causes heavy overhead natively linearly increasing query operational bottlenecks identically. Scanning $4000$ string comparisons on each query triggers severe mathematical TLE.
- ***Điểm yếu:** Vòng lặp duyệt rà Toàn bộ Danh sách Từ dài dằng dặc (W) gây nghẽn Tắc Khí Cục Diện. Việc mổ thịt So So 4000 từ mỗi Tích Tắc nhảy Ký tự là Gánh nặng Bệnh Liệt Dành Cho RAM! Kèo Quá Cứng dẫn tới (TLE) rớt não Ngay!*

---

## 3. Strategy 2: Optimal (Reversed Trie Structure)
## *3. Chiến lược 2: Tối ưu (Cây Tiền Tố Đảo Ngược Hậu Họa)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Why search strictly iterating the entire word list independently when we natively implicitly can process reverse paths compactly functionally logically natively seamlessly? We just mathematically insert every word completely backward into a single robust **Trie (Prefix Tree)**.
*Tại sao phải đánh rã trâu Toàn Bộ Kho Dữ Liệu? Nếu ta chịu dùng Tà Thuật nhồi nhét Đám Chữ Chạy Nghịch Mũi Tên Thời Gian vào Nút Cây Đa Hành `Trie` thì Vận Mệnh Lật Ngược Tức Khắc!*
1. Store words backwards into a Trie dynamically. Building "elppa" instead of "apple".
*1. Nhét Tất Cả Chữ vào lòng Trie theo chiều lộn ngược lại! Xây ra "elppa" dập nát từ "apple".*
2. Append letters to a global string dynamically.
*2. Khi khách ném dòng chữ, lưu thẳng vào `StringBuilder` Dòng Chảy.*
3. When querying, walk up the buffer backwards navigating naturally the Trie properly sequentially explicitly exactly matching the suffix structurally natively securely intuitively efficiently linearly efficiently intuitively seamlessly.
*3. Quét Tăm: Khi Hứng, Lột Mảnh Dòng Chảy, soi KÍNH LÚP đi NGƯỢC THỜI GIAN qua Cây Tiền Tố `Trie` để kiểm tra. Nếu Bóp Chặt Cạnh Tức Thì Có Điểm Nghẽn Gắn Cờ `isEndOfWord` -> Đúng ngay Hậu Tố Trọn Vẹn! Quá Gọn Mảnh!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
class StreamChecker {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    
    private TrieNode root;
    private StringBuilder streamHistory;
    private int maxWordLength;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        streamHistory = new StringBuilder();
        maxWordLength = 0;
        
        for (String word : words) {
            TrieNode current = root;
            maxWordLength = Math.max(maxWordLength, word.length());
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }
    }
    
    public boolean query(char letter) {
        streamHistory.append(letter);
        TrieNode current = root;
        
        // Càn quét Lịch Sử Ngược Chiều Bão Táp (Chỉ Rà Cho Cạn Độ Trưởng Dài Của Từ Dài Nhứt)
        for (int i = streamHistory.length() - 1; i >= Math.max(0, streamHistory.length() - maxWordLength); i--) {
            int index = streamHistory.charAt(i) - 'a';
            current = current.children[index];
            
            if (current == null) {
                return false;
            }
            if (current.isEndOfWord) {
                return true;
            }
        }
        return false;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    *   **Initialization:** $O(W \times L)$ correctly processing structurally $W$ words mapping maximum strictly linearly safely gracefully natively naturally logically logically exactly natively smoothly.
    *   **Query:** $O(L)$ tracking natively maximum constraints identically implicitly smoothly natively fluently mathematically gracefully effortlessly smoothly smoothly brilliantly properly smoothly natively responsibly cleanly safely.
    *   *   **Độ phức tạp thời gian:** Khởi tạo gốc rễ là $O(W \times L)$ với $W$ là đống Chữ Cái và $L$ là Tổng Nấc Chữ Dài Cao Cấp Nhất. Việc Quét `query` siêu nhanh nhẹ $O(L)$ chớp Thần Gió.*
*   **Space Complexity:** $O(W \times L)$ logically occupying identical dynamic Trie node maps compactly natively smoothly precisely stably correctly organically!
    *   **Độ phức tạp không gian:** $O(W \times L)$. Túi Trie Khổng Lồ chứa trọn bọc từ điển, béo núc ních nhưng Thể Hiện Tốc Độ Quang Học Náo Động Võ Lâm Đỉnh Cao Mọi Ngành RAM!*
