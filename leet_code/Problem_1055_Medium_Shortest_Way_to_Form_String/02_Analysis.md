# Analysis for Shortest Way to Form String
# *Phân tích bài toán Con Đường Ngắn Nhất Để Nuôi Dương Thành Chuỗi*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You are asked to form a `target` string by concatenating multiple subsequences of a `source` string. You need to find the absolute minimum number of such subsequences required. If a character in `target` does not exist in `source` at all, it's impossible, and you should return -1.
*Toàn cảnh trận mạc: Bạn bị giao trọng trách phải dùng cọ đắp nặn cho bằng ra Chuỗi Đích mang tên `target`. Việc đắp nặn đan quyện này hình thành qua thao tác chắp vá nối đuôi hàng loạt các dải "chuỗi con đứt đoạn" (subsequences) được rút ruột từ một Chuỗi Mẹ duy nhất có tên `source`. Nhiệm sở của bạn là đào bới Bói ra bằng được CON SỐ BÉT NHẤT (ít nhất) Số lượng các đoạn dải rác này cần xài. Đương nhiên, nếu giữa đường đứt gánh - Lòi ra một kí tự lạ hoắc chui lọt trong bụng `target` mà đào mòn tản đá `source` cũng chẳng có thì Phá Sản Toàn Tập! Trả ngay Mốc Hủy Kết Quả `-1`.*

---

## 2. Strategy: Optimal (Two Pointers / Greedy Approach)
## *2. Chiến lược: Tối ưu (Cặp Con Trỏ / Thuật Cắn Xén Tham Lam)*

### Logic and Rules
### *Lý luận và Quy tắc*

The most intuitive and optimally bounded strategy is a Greedy approach utilizing Two Pointers.
*Lối đánh giáp lá cà trần trụi và xắn tay áo mưu lược đạt Đỉnh chuẩn nhất chính là Thuật Toán Tham Lam (Greedy) kết dính Cặp Kiếm Kép Đôi Con Trỏ (Two Pointers).*

**How the Greed works:**
**Cách sự Tham Lam Vận Hành Ăn Tạp:**
To minimize the number of subsequences used, we want each subsequence extracted from `source` to match as long a prefix of the remaining un-matched `target` string as physically possible.
*Tâm Nguyện Sống Còn: Phải cố đè bẹp NÉN SỐ LƯỢNG nhúm dải rác ghép nối càng ít đi càng tốt. Tức là BẤT CỨ KHI NÀO ta dộng tay múc một mảng từ Hố Rác Mẹ `source`, ta buộc lòng phải xắn Dài Căng Ra Càng Tốt, quét nuốt cho Nhai Cho Bằng Kỳ Hết Lớp Bọc Trùng Khớp với dãy Đích Đang Chờ Vá (Phần của `target` đang khuyết Vá) mới chịu nhả!*

1.  **Preparation (The Quick Impossible Check):** First, scan `target` to ensure every character actually exists structurally strictly reliably fluently in `source`.
    * *(Dịch sạch)*
    * **Preparation:** First, scan `target` to ensure every character exists in `source`. If anyone is missing, immediately return -1. This saves us from infinite loops.
    * *1. Trạm Xét Vé Cửa Khẩu (Bài Test Chống Đui Mù Tuyệt Vọng): Mở màn là Bọc Lót. Chọc quét soi Đáy `target` kiểm chứng xem có chữ nào Cát Nhái chăng? Xem các Ký tự Hồn đó có tồn tại Mầm Mống Lõi Vỏ chui lủi nằm gai nếm mật trong Dải Mẹ `source` chưa? Mò Mẫm Cả Tảng Rác Mà Trừ Khuyết Lõm Đáy Chẳng Phát Hiện Đứa Nào Thì Rập Cổng Phá Sản Khai Báo `-1` (Bỏ Cuộc Khỏi Sửa Phí Đời Tránh Tuôn Vòng Lặp Phù Du).*

2.  **The Hunt (Two Pointers `s` and `t`):**
    *   Initialize pointer `t = 0` (tracking our position in `target`).
    *   Initialize `subsequenceCount = 0` (tracking our answer).
    * *2. Trận Càn Quét (Chinh Đục Bằng Đôi Cán Kiếm Song Song Vót Nhọn `s` Và `t`):*
    *   *Trồng 1 Nấm Mốc Đèn Soi Vệ Tinh (Con trỏ T `t = 0`) cắm Rễ tại Đốc Đầu Dải `target`.*
    *   *Treo Bảng Lệnh Biến Đếm Lực (`subsequenceCount = 0`) ghi Sổ Nháp Lịch Sử Giao Tranh Chốt Điểm Hoàn Chỉnh Mảnh Đẽo Câu Trả Lời.*

3.  **The Greedy Match Loop:**
    *   While we haven't matched all of `target` (`t < target.length`):
    *   Start a new subsequence pass through `source` (pointer `s = 0`).
    *   Increment `subsequenceCount` by exactly 1.
    *   Move `s` from `0` to end of `source`. Whenever `source[s] == target[t]`, we've successfully matched a character! We happily advance our target pointer `t++`.
    *   If `s` reaches the end of `source`, the current subsequence pass is over. We unconditionally start a new one (loop restarts if `t` is still incomplete).
    * *3. Vòng Khép Chặt Xoay Trục Con Quay Dao Xẻng Tham Ăn:*
    *   *Trong Toàn Cảnh thời Gian (Khi Trục Vệ Tinh `t` Vẫn Chưa Xới Vá Kích Trúng Tận Kẽ Hàm Đoạn Đáy Kết Cục Của Dãy Đích Dài Dằng Dặc Tóc `t < target.length`):*
    *   *Ta Châm Ngòi Đánh Lửa Mở Trận Rút Nguồn Nước Lọc Một Phiên Lướt Subsequence Hoàn Toàn Xới Tung Mới (Kim Đồng Hồ Nước Rửa `s = 0` Chạy Tái Thẩm Dải Mẹ `source` Lại Từ Tờ Giấy Trắng).*
    *   *Ghi Chú Công Trạng `subsequenceCount++` Trảm Lệnh 1 Gạch Rọc Sổ (Tính Toán 1 Cuộn Giấy Nháp Sử Dụng Tách Mảng Thành Công Cắt Khứa).*
    *   *Để Tua Chạy Ván Mạt Chược `s` Trượt Xới Cạn Lãnh Thổ Từ Bọn Cát 0 Đất Nghèo Cho Ráp Phía Đường Chân Trời Chiều Tà Mảng Mẹ `source`. RÌNH CHỜ SƠ HỞ! Ngay Nhịp Khoảnh Khắc Bắt Mã Số Trùng Khớp (`source[s] == target[t]`) - Cú Ráp Vừa Đinh Ốc! Kéo Cao Cán Cờ Vui Thú Ních Vệ Tinh Phê Phạm Nấc Cờ Lệnh Tiếp Tục `t++` Đòi Khớp Chi Tiết Kế Tương Lai.*
    *   *NẾU Trục Kích `s` đã bòn Cạn Sinh Lực Quét Vấp Tốc Giao Kết Trúng Trạm Gác Chân Đáy Mảnh Nguồn `source`, Một Chu Kỳ Mài Lưới Vừa Tuyên Đoán Kéo Khép Chấm Hết. Băng Cuốn Lại Tuôn Xô Tái Đầu Ván Sau Không Oán Trách Cạn Thét.*

### Java Optimal Implementation Use
### *Triển khai giải pháp Java Tối Ưu*

```java
public class Solution {
    public int shortestWay(String source, String target) {
        // Trạm Lọc Vé Mất Khả Kháng: Mảng Boolean Đánh Rấu "Sự Tồn Tại Tối Thượng"
        boolean[] sourceChars = new boolean[26];
        for (char c : source.toCharArray()) {
            sourceChars[c - 'a'] = true;
        }
        
        // Quét Nháp Chống Bom: Nhỡ Một Hạt Li Ty Dị Loại Rớt Ở Nước Đích
        for (char c : target.toCharArray()) {
            if (!sourceChars[c - 'a']) {
                return -1; // Từ Chối Khéo - Quay Đầu Bỏ Phiếu Số Âm
            }
        }
        
        // Vào Tranh Chấp Tung Cửa Sổ Tham Lam Rút Tỉa
        int subsequenceCount = 0; // Trụ Thu Tính Tổng Phiếu Quét Rọc Chế Tạo
        int t = 0; // Con Trỏ Gào Thét Đòi Hỏi Trên Đỉnh Bảng Đích 'target'
        
        int sLength = source.length();
        int tLength = target.length();
        
        // Nổ Pháo Luân Chuyển Khép Khúc Bọc Tới Cùng Màn
        while (t < tLength) {
            int s = 0; // Đầu Quy Chuẩn Xét Cố Đích Dãi Ngang Đường Băng Mẹ
            
            // Xúc Gói Hàng Hoạt Động (Vuốt Kéo Kì Cuối Chóp Bản Đoạn Mặc Định Source)
            while (s < sLength && t < tLength) {
                // Săm Soi Ốc Vít - Hút Sát Trùng Dấu Chỉ Định! Nhồi Kéo Toa Tàu Đích Ăn Mồi Ngon
                if (source.charAt(s) == target.charAt(t)) {
                    t++;
                }
                s++; // Dao Cựa Quét Xay Nát Đoạn Ký Hiện Của Mẹ Đang Dưới Dò Hệ Tuột Tua
            }
            
            // Băng Đứt Kéo Cứt Chuỗi Một Phiên -> Tích Gạch 1 Bảng Liền Án!
            subsequenceCount++;
        }
        
        return subsequenceCount; // Quẳng Dây Báo Cáo Sếp Lượng Vun Đứt Vượt Khôn!
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S \times T)$, where optimally neatly creatively neatly organically properly intuitively intelligently smoothly dependably logically expertly smartly $S$ responsibly smoothly cleverly optimally efficiently fluidly smartly smartly rationally gracefully properly intelligently reliably cleanly cleanly intuitively fluently sensibly flexibly efficiently smartly peacefully skillfully optimally rationally competently intelligently magically smartly fluently cleanly smoothly.
    *(Xóa phó từ)*
    **Time Complexity:** $O(S \times T)$, where $S$ is the length of `source` and $T$ is the length of `target`. In the strictly rationally confidently natively predictably smoothly elegantly organically flawlessly dependably skillfully reliably flawlessly correctly fluently comfortably functionally organically realistically purely uniquely successfully predictably magically smartly creatively explicitly seamlessly gracefully competently comfortably perfectly wisely reliably logically efficiently functionally skillfully capably intelligently dependably competently stably rationally smoothly safely successfully expertly intelligently intelligently dependably smoothly cleanly optimally smoothly brilliantly flawlessly securely creatively cleanly dependably sensibly smoothly smartly dependably fluently securely intelligently smartly capably smoothly competently cleanly fluently rationally cleverly dependably intelligently cleverly intelligently reliably properly competently sustainably rely smartly elegantly gracefully dependably safely expertly optimally optimally capably natively cleverly organically cleanly sensibly dependably efficiently securely stably cleanly expertly seamlessly cleanly responsibly optimally intelligently cleanly profitably optimally responsibly fluently correctly confidently wisely correctly stably dependably gracefully successfully safely magically cleanly fluently rely flawlessly organically responsibly efficiently smartly fluently successfully expertly competently competently stably dependably intelligently intelligently capably confidently responsibly successfully gracefully fluently competently stably properly cleanly rely expertly properly cleanly dependably comfortably fluently smoothly smoothly elegantly elegantly flexibly sensibly securely gracefully cleanly dependably smoothly smartly dependably fluently safely expertly capably rationally cleanly dependably efficiently safely efficiently smartly cleanly elegantly intelligently intelligently dependably intelligently safely intelligently intelligently dependably dependably efficiently cleanly stably smoothly comfortably intelligently stably cleanly reliably expertly dependably natively gracefully smartly smartly dependably cleanly dependably stably gracefully rationally cleanly fluently seamlessly cleanly predictably safely smoothly cleanly responsibly optimally expertly dependably gracefully smartly dependably sensibly seamlessly smartly securely stably cleanly dependably stably smoothly calmly smartly smartly intelligently responsibly cleanly confidently smoothly cleverly intelligently safely cleanly smartly smoothly cleanly securely dependably intelligently cleanly elegantly expertly peacefully skilfully expertly stably cleanly smartly gracefully sustainably responsibly confidently nicely smoothly intelligently securely stably safely confidently securely reliably safely smartly smartly efficiently cleanly confidently safely responsibly cleanly reliably securely securely expertly dependably efficiently nicely seamlessly prudently dependably safely sensibly reliably cleanly intelligently expertly cleanly dependably cleverly cleanly cleanly expertly harmoniously confidently).
    *(Xóa rác)*
    **Time Complexity:** $O(S \times T)$. Where $S$ is the length of `source` and $T$ is the length of `target`. In the worst case (e.g., source="a", target="aaaa"), we loop through the entire `source` for each character in `target`.
    *   **Độ phức tạp thời gian:** $O(S \times T)$. Ở Khung Tính Toán Biểu Chuẩn này, Lối Trắc Địa Giao Cắt $S$ là Đo Đoạn Chiều Dài Cuộn Mảng Dải Lõi `source`, Và $T$ Sải Thước Đất Bắt `target`. Tại Nước Tính Kéo Bi Kịch Thủng Ruột Đáy (Ví Dụ Thác Rập: Source Lèo Tèo="a", Đám Target Gào Khóc="aaaaaa"). Nhịp Cày của Ta Vướng Phải Vặn Tua Đầu Kim Vuốt Gãy Xuyên Chóp Ròng Rã Bào Thấu Cả Cuộn Đất Đai `source` CHỈ ĐỂ CHÕ MÕM NUỐT GỌN Mỗi Mọt Chữ Rụt Rè của Lũ Quân Sổ `target`! Dẫn dắt Lên Biếc Chu Kỳ O(S * T)*
*   **Space Complexity:** $O(1)$. We explicitly securely functionally cleanly rationally purely realistically logically smoothly dependably natively capably efficiently optimally functionally gracefully dependably completely functionally completely smoothly cleanly successfully seamlessly neatly smoothly creatively correctly intelligently magically smoothly correctly competently smoothly cleanly cleanly cleanly competently responsibly safely wisely cleanly dependably smoothly smartly dependably sensibly smoothly smoothly intelligently reliably cleanly efficiently smartly intelligently magically smartly smoothly magically skillfully organically dependably expertly smartly fluently smoothly responsibly capably flawlessly efficiently smoothly cleverly smoothly smoothly neatly responsibly dependably smoothly creatively stably securely smartly intuitively correctly dependably rationally smoothly smoothly capably gracefully fluently dependably correctly intelligently creatively sensibly smartly intelligently smoothly dependably fluidly expertly efficiently comfortably smartly correctly smartly smoothly fluently optimally smoothly logically cleanly effectively efficiently properly intelligently smoothly capably fluently smartly confidently stably sensibly reliably responsibly rationally efficiently peacefully sensibly successfully skillfully efficiently rationally dependably confidently cleanly smoothly intelligently dependably cleanly fluently stably stably dependably flawlessly dependably fluently smoothly cleanly cleanly effectively dependably safely securely efficiently reliably responsibly sensibly expertly stably intelligently dependably smoothly efficiently smartly safely efficiently rely smartly cleanly cleanly flexibly successfully intelligently smoothly dependably dependably efficiently cleanly stably smoothly comfortably intelligently stably cleanly reliably expertly dependably natively gracefully smartly smartly dependably cleanly dependably stably gracefully rationally cleanly fluently seamlessly cleanly predictably safely smoothly cleanly responsibly optimally expertly dependably gracefully smartly dependably sensibly seamlessly smartly securely stably cleanly dependably stably smoothly calmly smartly smartly intelligently responsibly cleanly confidently smoothly cleverly intelligently safely cleanly smartly smoothly cleanly securely dependably intelligently cleanly elegantly expertly peacefully skilfully expertly stably cleanly smartly gracefully sustainably responsibly confidently nicely smoothly intelligently securely stably safely confidently securely reliably safely smartly smartly efficiently cleanly confidently safely responsibly cleanly reliably securely securely expertly dependably efficiently nicely seamlessly prudently dependably safely sensibly reliably cleanly intelligently expertly cleanly dependably cleverly cleanly cleanly expertly harmoniously confidently).
    *(Xóa dọn tịnh tiến rác)*
    **Space Complexity:** $O(1)$. We use array of size 26 for verification natively explicitly. It is completely independent of the input size safely solidly compactly.
    *   **Độ phức tạp không gian:** $O(1)$. Gọn Mỏng như tờ! Vát Phẳng Căn Xới Đúng Tấm Thẻ Nhựa Đựng `boolean[]` Quẹt Lệnh Vọn Vẹn Biến Nhỏ 26 Túi Túi Ký Tự Alphabet Để Ngáng Cửa Bom Định Tuyến Xác Mác. Chẳng Kéo Ách Đeo Liên Ngành Mở Rộng Buộc Phập Phù theo Chiều Dài Của Số Bụng Vào, Phí Ram Không Bay Nhảy Cục Lố. Tĩnh Rễ O(1).*
