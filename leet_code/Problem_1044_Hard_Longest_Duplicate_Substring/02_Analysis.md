# Analysis for Longest Duplicate Substring
# *Phân tích bài toán Chuỗi Con Lặp Lại Dài Nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a highly long string `s` of up to $3 \times 10^4$ characters, find a contiguous substring that appears at least twice in `s` and has the maximum possible length. Returning a brute-force comparison of all substrings leads to $O(N^3)$ operations, resulting instantly in Time Limit Exceeded (TLE).
*Từ một chuỗi ký tự `s` dằng dặc cực kỳ dài lên tới 30.000 ký tự, hãy bới ra một chuỗi con liền mạch nào đó xuất hiện ít nhất 2 lần và chiếm độ dài vô địch lớn nhất có thể. Hành vi "trâu cày" so sánh thủ công mọi mẩu chuỗi con sẽ đẩy hệ số thời gian trượt thẳng xuống $O(N^3)$, dẫn tới án tử Time Limit Exceeded (Quá hạn thời gian).*

---

## 2. Strategy: Optimal (Binary Search + Rolling Hash / Rabin-Karp)
## *2. Chiến lược: Tối ưu (Tìm Kiếm Nhị Phân Lồng với Băm Cuốn Rabin-Karp)*

### Logic and Rules
### *Lý luận và Quy tắc*

The problem exhibits exactly a "Monotonic Property" mathematically. If a duplicated substring of length $L$ exists securely somewhere, then naturally a duplicated substring of length $L - 1$ must absolutely exist! Because if "ana" repeats, implicitly "an" perfectly repeats too!
*Điều cốt lõi của bài toán này nằm ở Đặc Tượng Đơn Điệu Cột Mốc: Nếu có một khúc chuỗi trùng nhau dài tới mức $L$, thì Lô-gic tất yếu là khúc chuỗi rút ngắn đi 1 tấc ($L - 1$) NÓ SẼ BẬT NHIÊN PHẢI TRÙNG NHAU! (Ví dụ: Từ `ana` lặp lại 2 lần, thì 100% cái mẩu đuôi `an` của nó cũng phải bị lặp lại).*

If length $L$ fails to have a duplicate, NO lengths greater than $L$ can possibly have a duplicate. Thus, instead of testing all possible substrings, we can simply apply **Binary Search** smoothly on the length integer `L` (bound actively between $1$ and $N-1$).
*Ngược lại, Nếu mò ra độ dài $L$ không hề có lấy một bản sao, thì Đừng Hòng những độ dài khổng lồ hơn lại nảy nở phép màu nhân đôi! Cứng Cáp kết luận: Thay vì cào đất dò từng ô, chúng ta Tung Lưới Nhị Phân (Binary Search) chẻ đôi Trục Chiều Dài `$L$` của chuỗi cần tìm (từ min $1$ cho đến max $N-1$).*

Once the length $L$ is fixed, we quickly verify if any substring of exactly this length repeats. We use the **Rabin-Karp Rolling Hash algorithm**, which calculates explicit integer hash codes dynamically efficiently without computing from scratch. It simply subtracts the outgoing character and adds the newly incoming character in steady $O(1)$ time.
*Khi chốt kích thước cắt chuỗi là độ dài `$L$` (do Nhị phân cấp báo), ta lấy rập khuôn đó dò tìm có 2 dải L liền kề nào trùng khớp hay không. Thuật toán Trượt Khung Vuông kết hợp mã Băm Cuốn (Rabin-Karp Rolling Hash) cho phép dịch khung cửa sổ khổng lồ dài L này MÀ KHÔNG PHẢI MẤT CÔNG TÍNH LẠI HASH CODE bằng vòng for. Nó chỉ cần Hút Trừ Cái Chữ Lọt Rìa Cuối Cửa Sổ và Bơm Nạp Cái Chữ Mới Vào Đầu Cửa Sổ tốn chuẩn 1 Lệnh (Time $O(1)$).*

By storing these rolling hash codes securely in a HashSet, we can instantly detect if a hash code repeats, signaling a fully identically copied substring block!
*Mã Hash mã hóa hệ số 26 đẩy biến đổi thành hệ số `long`. Khi cuốn cửa sổ Hash, cất tạm những con số Mã Hash này vào Set. Nếu gặp lại cục Mã Hash y xì và độ dài khớp, Ta đã ăn trúng Độc Đắc bản Mảng Copy Nhau!*

### Java Optimal Implementation
### *Triển khai giải pháp Java*

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Thuật băm sử dụng Số nguyên tố để đỡ móp vạ lây Hệ Số (Collision)
    private static final long MOD = 1_000_000_000_000_007L; 

    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1;         // Độ dài min lặp ngắn nhất tìm
        int right = n - 1;    // Độ dài max lặp lại
        int startPos = -1;    // Kỷ lục Chân Trụ Lịch sử lặp Đỉnh nhất
        int maxLength = 0;    // Độ dài kỉ lục
        
        while (left <= right) {
            int midLength = left + (right - left) / 2; // Cưa Cục Độ Dài ra nửa Vạch Test
            int startIndexOfDuplicate = searchDuplicateWithLength(s, midLength);
            
            if (startIndexOfDuplicate != -1) {
                // Nhá ra Bọt Sóng Báo Hiệu Đã Cắn Mồi Trùng Nhau Độ Dài MID. Sẽ Mài Đòi Tăng Dài Thêm Nữa
                maxLength = midLength;
                startPos = startIndexOfDuplicate;
                left = midLength + 1;
            } else {
                // Sập Họng! Ở nấc kéo Dài Cổ Khúc Này Sạch Bóng Bản Sao. Phải Cưa Ngắn Kích Thước Lại
                right = midLength - 1;
            }
        }
        
        return startPos != -1 ? s.substring(startPos, startPos + maxLength) : "";
    }
    
    // Thuật Sóng Trượt Rabin-Karp Rolling Hash Cỡ Cực Lớn Chống Trượt Va Đập
    private int searchDuplicateWithLength(String s, int L) {
        long hashValue = 0;
        long base = 26;
        long aL = 1; // Chiết suất Nguồn của Khúc bị xả Rớt đuôi
        
        // Vét Máng Tính Độ Cong Hash Nền Điểm Gốc L Tiền Vệ Đầu Tiên
        for (int i = 0; i < L; i++) {
            hashValue = (hashValue * base + (s.charAt(i) - 'a')) % MOD;
            aL = (aL * base) % MOD;
        }
        
        Set<Long> visitedHashes = new HashSet<>();
        visitedHashes.add(hashValue);
        
        // Rút Ống Trượt Cuộn Cuộn Bơm Dịch Cửa Sổ Về Sau...
        for (int i = 1; i <= s.length() - L; i++) {
            // Loại Gãy Thải Cột Rìa Cũ, Nạp Xi Lanh Kí Tự Mới Vào Cửa
            hashValue = (hashValue * base - (s.charAt(i - 1) - 'a') * aL % MOD + MOD) % MOD; 
            hashValue = (hashValue + (s.charAt(i + L - 1) - 'a')) % MOD;
            
            // Xúc chạm Lưới Hash Cổ Vật Cũ Trùng? Rơi Mạng
            if (visitedHashes.contains(hashValue)) {
                return i;
            }
            visitedHashes.add(hashValue);
        }
        
        return -1; // Vén Kịch Không Có Gì
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$. Operations consist of Binary Search log iterations bounding the length, and inside each iteration, the Rolling hash sliding window takes a completely linear $O(N)$ execution span. Total rounds amount to $N \log N$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$. Cú Chẻ Nhị Phân lấy độ dài L bóc túi $O(\log N)$ mạng. Trong mỗi một Chặng Vồ này, Chạy Thuật Toán Cưa Ống Lồng Kính Rolling Hash Xuyên Mảng Lọc Tốn Chính Xác Độ Rớt Tuyến Tính Cố định $O(N)$. Tích Nhân Lại Trượt Nhẹ Lướt Thả Cửa $O(N \log N)$.*
*   **Space Complexity:** $O(N)$. At each search iteration, we track up to $N$ structural hashes securely inside a localized `HashSet` storage structure.
    *   **Độ phức tạp không gian:** $O(N)$. Sổ Bộ Nhớ Tĩnh Khúc Nén Hash Rỗng kẹp `HashSet`. Có Nhiều Nhất $N$ Mắt Hash Vỡ Rụng vào đây, Khứa RAM Vừa Vặn Nhỏ Gọn Giữ vững $O(N)$.*
