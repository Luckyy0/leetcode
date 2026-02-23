# Analysis for Longest String Chain
# *Phân tích bài toán Chuỗi Ký Tự Nối Tiếp Dài Nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an array of words, find the length of the longest possible word chain where each successive word is formed by adding exactly one character to the previous word.
*Cho một mảng các từ ngữ, bài toán yêu cầu tìm ra chiều dài tối đa của một Chuỗi Kết Nối. Một Chuỗi Kết Nối được định nghĩa là chuỗi mà phần tử đi ngay phía sau phải được tạo thành bằng cách chèn ĐÚNG DUY NHẤT một chữ cái vào phần tử đứng ngay phía trước nó.*

---

## 2. Strategy: Optimal (Dynamic Programming with Hashing)
## *2. Chiến lược: Tối ưu (Quy Hoạch Động kết hợp Hàm Băm)*

### Logic and Rules
### *Lý luận và Quy tắc*

A natural approach to this problem relies on sorting the words by their length first. By establishing length order, we guarantee that when examining the possible chains for any given word, we have already fully evaluated all its shorter, potential predecessor words.
*Hướng tiếp cận cốt lõi của bài toán này nằm ở việc sắp xếp các từ trong mảng gốc THEO CHIỀU DÀI TĂNG DẦN TỪ BÉ ĐẾN LỚN. Nhờ việc sắp xếp này, ta tạo ra một quy tắc bất di bất dịch: Khi xét đến một Kẻ Đi Sau (Từ Dài), ta CHẮC CHẮN 100% đã tính toán và ghi nhớ trọn vẹn điểm số Kỷ lục Chuỗi của mọi Kẻ Tiền Bối (Từ Ngắn Hơn) có thể liên kết với nó.*

After sorting, we can iterate through each word and dynamically build a dictionary (Hash Map) to store `word -> longest_chain_length_ending_at_this_word`.
*Sau khi đội hình đã xếp ngắn đến dài, ta quét qua từng từ một và dùng từ điển Ánh xạ (HashMap) để lưu trữ cấu trúc Quy hoạch Động: `Chìa_khóa_từ_ngữ -> Kỷ_lục_chiều_dài_chuỗi_kết_thúc_tại_đó`.*

For each word:
1. Initialize the default chain length for this word to 1 (itself).
*1. Gắn Kỷ lục nòng cốt cho chính bản thân từ này mặc định là 1 (Chỉ có nó đứng một mình đội sổ).*
2. Systematically slice out exactly one character from the word at every possible index to generate all theoretical predecessor "candidates".
*2. Từng bước một: Cứa đứt cắt bỏ ĐÚNG DUY NHẤT MỘT CHỮ CÁI ở mọi khe chữ nằm trong Từ đó. Hành động này sẽ tạo ra toàn bộ những Mầm Mống Tiền Bối (Predecessors) giả định khả thi có khả năng liên kết.*
3. If any generated candidate exists in our DP Hash Map, it securely means we can successfully extend the candidate's established chain unconditionally! Therefore, `current_length = max(current_length, candidate_length + 1)`.
*3. Mang cái Mẩu Chữ bị cắt (Mầm Tiền Bối giả định) đó đi đối chiếu trong Từ Điển Ánh Xạ DP. NẾU NÓ THỰC SỰ TỒN TẠI (Tức là mảng đầu vào có chứa ông Tiền Bối này), Thì Lấy Kỷ Lục Dài Của Ông Tiền Bối đó CỘNG THÊM 1 BẬC (Để tính luôn chữ hiện tại). Ghi nhận Kỷ Lục Lớn Nhất! `current_length = max(current_length, Lịch_Sử_Ông_Tiền_Bối + 1)`.*
4. Update the global max chain length tracked so far.
*4. Lưu Điểm Sáng Kỷ lục Tổng Thể lên Bảng Vàng tính tới thời điểm hiện tại.*

### Java Optimal Implementation
### *Triển khai giải pháp Java Tối Ưu*

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestStrChain(String[] words) {
        // Sắp xếp quân Cờ: Từ nào có chữ cộc Ngắn hơn Đứng Trước, Thằng To Nằm Sau 
        // -> Đảm bảo Tính Tính Trước Của Quy Hoạch Động Bọt Biển.
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // Túi Thần Kỳ Memoization: Ghi nhớ Điểm Số Max Kết Thúc Tại Từng Cục Chữ Cái
        Map<String, Integer> dp = new HashMap<>();
        int absoluteMaxLength = 0;
        
        // Dò Tìm Trượt Qua Khắp Khúc Từ Ngữ Từ Bé Tới Lớn Cỡ
        for (String currentWord : words) {
            int currentBest = 1; // Thấp Kém Mâm Bụng Là 1
            
            // Lôi Cuốc Đào Dỡ: Cắt từng Chữ Cái Mẩy Cạo Đi Hỏi Thăm Sổ
            for (int i = 0; i < currentWord.length(); i++) {
                // Rách Vỏ 1 Kí Tự Tại Lề Ranh i
                String predecessorCandidate = currentWord.substring(0, i) + currentWord.substring(i + 1);
                
                // Mở Cuốn DP Rò Số Tiền Bối Đã Mượn Đóng Sổ
                if (dp.containsKey(predecessorCandidate)) {
                    // Trúng Xổ Số Khâu Ráp Nhau Rồi! Nhồi Cực Mác Tích Lũy Vào Thôi!
                    currentBest = Math.max(currentBest, dp.get(predecessorCandidate) + 1);
                }
            }
            
            // Úp Thẻ Ráp Bài Của Từ Gốc Cố Định Vào Bản Đồ Từ Điển DP
            dp.put(currentWord, currentBest);
            // Siết Đồng Hồ Vàng Cho Trận Tuyến Dài Kỉ Lục Của Toàn Mảng
            absoluteMaxLength = Math.max(absoluteMaxLength, currentBest);
        }
        
        return absoluteMaxLength;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N + N \times L^2)$. Sorting the $N$ words takes $O(N \log N)$ time. Iterating through $N$ words and systematically extracting string slices of maximum length $L$ logically causes inner loops costing $L$ operations on a string computationally taking $O(L^2)$ time.
    *   **Độ phức tạp thời gian:** $O(N \log N + N \times L^2)$. Bước sắp xếp Đội Hình đòi Thuế $O(N \log N)$. Khi Lục Qua Danh Sách $N$ Từ, Khóa phẫu mảnh Tách phạt tốn Cước Vòng Lặp Trích Cáp (`substring()`) mang Hệ Số Chạy độ dài $L$, Mà Phải Làm Lặp Đi Lại Cứa trong $L$ Lần $\rightarrow O(L^2)$ cho mỗi đoạn. Dồn Kết Trục Tổng Toán!*
*   **Space Complexity:** $O(N \times L)$. Creating uniquely the hashmap dynamically consumes local memory securely capturing element attributes explicitly reliably.
    *   **Độ phức tạp không gian:** $O(N \times L)$. Mức Độ Tổn Hao RAM Khi Phải Nhét Đóng Trọn Gói Sổ Phích Hash Map Chiếm Cáp $N$ Cụm Chữ Cái Vựng Bọc Nguyện Thể. Mỗi Từ Trượt Bán Kính $L$ Khoảng Tượng Nhựa Tiêu Thụ Tĩnh Trụ!*
