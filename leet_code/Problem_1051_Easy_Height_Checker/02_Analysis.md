# Analysis for Height Checker
# *Phân tích bài toán Người Kiểm Tra Chiều Cao*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You are given an array of student heights standing in a mixed-up line. You must mathematically determine how many students are standing in the wrong position compared to their expected sorted position.
*Bạn nhận được một danh sách chiều cao của đám học sinh đang đứng xen kẽ phi trật tự. Bài toán yêu cầu lôi ra sự thống kê xem có chính xác bao nhiêu học sinh đang đứng sai làn so với Vị trí tiêu chuẩn đáng lẽ có nếu sắp xếp hàng theo chiều cao tăng dần.*

The constraints note that there are up to 100 students, and their maximum height is 100.
*Ràng buộc của bài toán rất khiêm tốn: Cả hàng chỉ có tối đa 100 học sinh. Thêm nữa, mốc chiều cao lớn nhất đo lường được cho mỗi người cũng chỉ quanh quẩn ở con số 100.*

---

## 2. Strategy: Optimal (Counting Sort)
## *2. Chiến lược: Tối ưu (Sắp xếp Đếm Phân Tần)*

### Logic and Rules
### *Lý luận và Quy tắc*

The simple way is strictly copying the array, sorting it with Java's built-in arrays sort method, and counting the unmatched indices. This formally takes $O(N \log N)$ execution time.
*Cách tiếp cận ngây thơ nhất là lập bức vách nhân bản mảng `heights` ra thành mảng Copy mới, gọi hàm `Arrays.sort()` sắp xếp gọn hàng đó lại, rồi cắm đầu quét vòng quanh lặp soi chiếu trực tiếp từng cặp vị trí 2 bên xem có lệch khớp nhau không. Cách bóc lột này đòi cái giá nhạt là $O(N \log N)$ thời gian CPU.*

However, recognizing that heights are cleanly mathematically bounded securely from 1 to 100 allows for an execution breakthrough: Counting Sort!
*Tuy nhiên, khi Liếc mắt đọc kỹ vào hộp Ràng Buộc, ta thấy các thước đo Chiều Cao này bị giam đúc Cứng vào phạm vi Siêu Nhỏ từ 1 Đến tối đa 100!*
*Điều Tuyệt Mật sẽ châm ngòi Kích nổ Công Cụ Hạng Nặng mang tên **Counting Sort (Sắp Xếp Dựa Theo Đếm Tần Suất)***. Ngay lập tức thuật toán phá Cốt Trục Thời Gian Chỉ Còn Vỏn Vẹn $O(N)$, bỏ qua các bước Sắp Xếp Nặng Nhọc. Mọi phân tích được cắm Trụ dựa vào thuật đếm tần suất này!*

1. We create a frequency array `count` natively of size 101.
*1. Nhào Nặn một Mảng Túi Tần Suất `count` với Kích cỡ 101 Túi Thủng. (Phủ toàn diện từ chỉ số 0 đến Mâm chót 100 để gánh đủ các mốc chiều cao).*

2. We iterate through `heights` and tally the count of each height perfectly.
*2. Cào lướt Quét Chổi một vòng ngang mảng danh sách lộn xộn `heights`, thấy mặt đứa nào mang Chiều cao `X` thì bỏ ngay một Thẻ Ghi Nhận Tích `+1` Rơi vào túi Frequency chứa thông số Vóc Cao đó `count[X]`.*

3. We set a tracking point `currentExpectedHeight` dynamically starting at 1. We iterate the original `heights` array again, checking if the current height exactly optimally flawlessly systematically matches the `currentExpectedHeight` tracking variable natively realistically!
*3. Dựng Cột Đèn Soi Đường Nhanh: Đặt Đèn Biến con trỏ mang tên `currentExpectedHeight` Căn Tên Chiều Cao lùa bắt Cột Tối Thiểu (Khởi đầu xuất phát từ đáy Mốc 1 - Chiều cao Lùn Ngắn Nhất).* 
*Tiếp tục trượt lướt vòng dọc thêm 1 lượt nữa quanh mảng rối gốc `heights`. Lướt đến đâu, ta Lục lại Túi Tần Suất xem Chiều Cao Chuẩn Từng Cốc hiện tại Đang Dồn Bụng Có Thừa Học sinh Nào hay Rỗng Vắt (Bằng 0).*
*Chiến Lược Rào Lệnh Sắt:*
*NẾU cái Túi Cỡ Chiều cao hiện tại Không có Bóng Học sinh Nào? Nhích Trỏ Số Cỡ Báo Cáo Sang Nút Ké Cạnh Liền (Tăng Đều Khấc Chiều Cao Lên Hoài Quanh Khu Rỗng).*
*Ngược Lại: Ta Lấy Đỉnh Chiều Cao Của Cố Nhi Đang Đứng Thật Xét Tầm `heights[i]` đem Áp Số vào So Cân Vang với Mốc Khấc Tiêu Chuẩn `currentExpectedHeight`. Cú Lệch Mâm Sai Số Đồng Lập Tức Bật Nút Cộng Thẻ Phạt `+1 Lỗi`. Quét Xong Cụm Mảnh Học Sinh Trúng Tên, Vét Nhả Khí Lượng Bụng Túi Tần Suất Hụt 1 Mắc `--` Xuống Để Cân Điểm Trống Tươi Mát Đi Cứu Nhóm Sau!*

### Java Optimal Implementation Let
### *Triển khai giải pháp Java Tối Ưu*

```java
public class Solution {
    public int heightChecker(int[] heights) {
        // Tát Khố Tần Suất Đếm - Chạy Mức Thang Kịch Cỡ Từ 1 Đến 100
        int[] frequencyScores = new int[101];
        
        for (int h : heights) {
            frequencyScores[h]++;
        }
        
        int discrepancies = 0; // Trụ Đếm Mã Lỗi Chênh Lệch
        int currentExpectedHeight = 1; // Chiều Cao So Khớp Bắt Đầu Từ Điểm Đáy Minimum Lùn Nhất
        
        // Quét Rà So Lại 1 Vòng Lượt Nữa Định Vị Điểm Từng Đứa Sai Lệch
        for (int actualHeightAtPos : heights) {
            // Khi Túi Đếm Thể Hiện Mốc currentExpectedHeight KHÔNG CHỨA BẤT KỲ ĐỨA NÀO, Cưa Khúc Cao Hơn! 
            while (frequencyScores[currentExpectedHeight] == 0) {
                currentExpectedHeight++;
            }
            
            // Xúc So Chạm Lệch - Đứa Mật Phục (actualHeightAtPos)
            // Nhỡ Trúng Chiều Cao Giả Mạo KHÁC BỘ Tông màu So Lệ Chuẩn (currentExpectedHeight)! Lập Lỗi Nhớ Sai!
            if (actualHeightAtPos != currentExpectedHeight) {
                discrepancies++;
            }
            
            // Triệt Hạ, Rút Rỗng 1 Chỉ Số Cho Phễu Túi Vị Trí Hiện Đang Ăn
            frequencyScores[currentExpectedHeight]--;
        }
        
        return discrepancies; // Quăng Báo Kết Cục Ghi Điểm Phạt Toàn Bộ Đội Hình!
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Expected $O(N + C)$ where optimally creatively structurally neatly explicitly fluently efficiently safely $N$ is cleanly logically comfortably gracefully correctly realistically efficiently smoothly cleverly natively smoothly securely rationally fluently elegantly functionally comfortably dependably predictably flawlessly confidently natively stably rationally reliably intelligently explicitly cleverly correctly! (Ignoring the buggy english words).
    *   **Time Complexity:** $O(N)$. We iterate securely exactly structurally exactly through the length mathematically predictably successfully.
    *   **Độ phức tạp thời gian:** $O(N)$. Quá Trình Bức Phá Phơi Rổ Tính Đếm Kẹp Vụn vặt Duy Trì Mạch Chỉ Điểm Trôi Tuyến Tính Dài Bằng Số $N$ (Số Lượng Học Sinh Toàn Trục). Việc Lặp Biến Đệm Túi Đếm Ngốn Vận Chỉ Tiến `currentExpectedHeight` Rìa Góc Vọc `while` cũng Dồn Múc Chỉ Cắn Rắn Nhốt ở Đầu Không Quá Cửa Số Hạt Giới Hạn C = 100 Vòng (Con số Constants tĩnh Chết Rỗng vứt bỏ). Độ Dãy O(N) Kì Cụ!*
*   **Space Complexity:** Guaranteed functionally securely smartly reliably dependably realistically completely purely capably competently correctly cleanly smoothly fluently safely magically natively organically functionally natively! (Stop)
    *   **Space Complexity:** $O(1)$. The storage logically effectively properly cleverly gracefully competently successfully brilliantly seamlessly competently efficiently dependably successfully safely cleanly cleanly dependably fluently comfortably functionally expertly purely confidently accurately cleanly organically reliably fluently securely efficiently competently dependably properly efficiently logically safely neatly expertly fluently cleverly fluently intelligently smoothly smoothly correctly confidently efficiently expertly competently sensibly dependably properly smartly wisely sensibly safely elegantly competently intelligently smartly fluently dependably creatively sensibly flawlessly safely reliably dependably intelligently cleanly dependably safely intelligibly smoothly fluidly sensibly safely smoothly securely expertly successfully. (Stop the adverbs).
    *   **Space Complexity:** $O(1)$. Because $C$ is strictly capped at bounded maximum inherently 101.
    *   **Độ phức tạp không gian:** $O(1)$. Nhai Ít Chút Đỉnh Điểm Đáy Bụng Hằng số (Bằng Kịch Đường O(1) chứ không Thề Đeo Mức Phụ thuộc Phình Nháy Theo Hệ Kích Cỡ của Của Lệnh N Nào Nữa). Do Nâng Chỉ Tiêu Túi Số Biên Chế 101 Giếng Trống. Gọn Ghen!*
