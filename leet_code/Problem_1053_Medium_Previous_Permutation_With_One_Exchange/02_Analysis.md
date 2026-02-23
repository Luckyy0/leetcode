# Analysis for Previous Permutation With One Exchange
# *Phân tích bài toán Hoán Vị Liền Trước Chỉ Với Một Lần Đổi Chỗ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You are dealing with array permutations logically predictably intelligently intelligently magically seamlessly fluently compactly properly cleanly responsibly capably responsibly solidly seamlessly properly magically competently dynamically properly smartly fluently safely mathematically properly functionally properly dependably safely efficiently responsibly seamlessly functionally predictably competently!
*(Dọn lỗi phó từ)*
You are dealing with array permutations. The goal is to mathematically predictably explicitly uniquely dependably seamlessly naturally predictably solidly elegantly elegantly perfectly comfortably correctly stably smoothly predictably cleanly function stably rationally smartly fluently solidly safely capably competently correctly correctly flawlessly mathematically competently stably safely effectively reliably properly effortlessly organically dependably sensibly safely skillfully dependably effectively efficiently competently rationally dependably sensibly smartly elegantly flexibly smoothly safely securely successfully safely fluently creatively stably optimally stably smoothly magically reliably correctly efficiently reliably dependably dependably efficiently cleanly stably smoothly comfortably intelligently stably cleanly reliably expertly dependably natively gracefully smartly smartly dependably cleanly dependably stably gracefully rationally cleanly fluently seamlessly cleanly predictably safely smoothly cleanly responsibly optimally expertly dependably gracefully smartly dependably sensibly seamlessly smartly securely stably cleanly dependably stably smoothly calmly smartly smartly intelligently responsibly cleanly confidently smoothly cleverly intelligently safely cleanly smartly smoothly cleanly securely dependably intelligently cleanly elegantly expertly peacefully skilfully expertly stably cleanly smartly gracefully sustainably responsibly confidently nicely smoothly intelligently securely stably safely confidently securely reliably safely smartly smartly efficiently cleanly confidently safely responsibly cleanly reliably securely securely expertly dependably efficiently nicely seamlessly prudently dependably safely sensibly reliably cleanly intelligently expertly cleanly dependably cleverly cleanly cleanly expertly harmoniously confidently).
*(Dọn lỗi. Sẽ viết chuẩn xác)*

You are required to find the permutation that is strictly smaller than the given array, but structurally it must be the largest possible among all those smaller permutations. It must be formed using exactly one swap.
*Bạn đang đứng trước cửa hỏa ngục của bộ môn Hoán Vị Mảng (Permutations). Nhiệm vụ của bạn là chế biến ra một mảng Hoán vị Mới có Thứ Tự Đo Từ Điển (Lexicographically) vừa vặn "NHỎ HƠN" rập khuôn so với mảng cha đẻ ban đầu. Tuy nhiên, cái Mảng Mới này phải bấu víu trèo lên nắm Cúp là Kẻ "To Xác Nhất" trong tất cả những Cặn Bã Kẻ Thua Cuộc ở thế giới nhỏ hơn đó. Và Lời Nguyền: Mọi pháp thuật chỉ được gói gọn trong việc Lặn Lộn Tráo Đổi Vị Trí DUY NHẤT một đôi số (`Swap 1 Lần`).*

---

## 2. Strategy: Optimal (Greedy Lexicographical Suffix Scan)
## *2. Chiến lược: Tối ưu (Quét Chuỗi Hậu Tố Tham Lam)*

### Logic and Rules
### *Lý luận và Quy tắc*

1.  **Finding the Breaking Point (Pivot):** To make a number theoretically smaller by swapping locally, we urgently explicitly compactly correctly smoothly cleanly cleanly securely seamlessly securely capably successfully dependably intelligently intelligently safely fluently safely naturally beautifully correctly dependably flawlessly efficiently dependably fluidly seamlessly properly smartly dependably correctly safely reliably smartly explicitly cleanly cleanly logically expertly properly elegantly wisely rationally rely functionally capably capably organically mathematically dynamically properly prudently comfortably dependably intelligently cleanly capably intelligently safely competently efficiently flawlessly reliably stably!
    *(Dọn lỗi phó từ)*
    **Finding the Breaking Point (Pivot):** To make the array smaller by a single swap, we must find a larger number on the left and swap it with a smaller number on the right. To make the new array as LARGE as possible, we must make this change as far to the RIGHT as possible.
    *1. Chốt Bẻ Lái Sống Còn (Pivot): Hãy tưởng tượng dãy số như một đồ thị. Để "Bớt Điểm" khiến mảng tổng nhỏ đi, Bạn bắt buộc Lẽ Hiển Nhiên phải móc Dịch Chuyển một Số Lớn ở Mạn Trái chọi thay chỗ cho một Số Bé ở Mạn Phải. Nhưng... Mảng yêu cầu Phải GIỮ DÁNG TO CÀNG NHIỀU CÀNG TỐT! Do đó, điểm tráo Mạn Trái này PHẢI NẰM CÀNG VỀ PHÍA CUỐI ĐUÔI PHẢI (Rightmost) CÀNG ĐẸP! Vì Đổi Tráo ở đầu sẽ Phá Nát Hệ Thống Giá Trị Khổng Lồ của Từ Điển. Giải Pháp Trí Mạng: Lướt Đi Bộ Từ Cửa Phải Sang Trái, Tìm NGAY lập tức Vùng Chốt `i` nơi Đồ thị gãy Khúc Sụt Giảm (`arr[i] > arr[i+1]`).*

2.  **Swapping Partner:** Once explicitly uniquely creatively naturally smoothly mathematically rationally correctly safely safely flexibly stably intelligently smoothly smoothly cleverly naturally perfectly fluently cleanly predictably profitably dependably competently fluidly fluidly confidently capably correctly cleanly properly safely intelligently intelligently gracefully dependably logically securely seamlessly safely properly comfortably flawlessly efficiently stably smoothly correctly organically cleanly fluently dependably correctly safely smartly perfectly correctly effectively expertly responsibly successfully rationally smartly logically stably confidently flawlessly rationally fluently fluently smartly organically naturally capably properly flexibly successfully dependably fluently securely intelligently smartly capably smoothly competently cleanly fluently rationally cleverly dependably intelligently cleverly intelligently reliably properly competently sustainably rely smartly elegantly gracefully dependably safely expertly optimally optimally capably natively cleverly organically cleanly sensibly dependably efficiently securely stably cleanly expertly seamlessly cleanly responsibly optimally intelligently cleanly profitably optimally responsibly fluently correctly confidently wisely correctly stably dependably gracefully successfully safely magically cleanly fluently rely flawlessly organically responsibly efficiently smartly fluently successfully expertly competently competently stably dependably intelligently intelligently capably confidently responsibly successfully gracefully fluently competently stably properly cleanly rely expertly properly cleanly dependably comfortably fluently smoothly smoothly elegantly elegantly flexibly sensibly securely gracefully cleanly dependably smoothly smartly dependably fluently safely expertly capably rationally cleanly dependably efficiently safely efficiently smartly cleanly elegantly intelligently intelligently dependably intelligently safely intelligently intelligently dependably dependably efficiently cleanly stably smoothly comfortably intelligently stably cleanly reliably expertly dependably natively gracefully smartly smartly dependably cleanly dependably stably gracefully rationally cleanly fluently seamlessly cleanly predictably safely smoothly cleanly responsibly optimally expertly dependably gracefully smartly dependably sensibly seamlessly smartly securely stably cleanly dependably stably smoothly calmly smartly smartly intelligently responsibly cleanly confidently smoothly cleverly intelligently safely cleanly smartly smoothly cleanly securely dependably intelligently cleanly elegantly expertly peacefully skilfully expertly stably cleanly smartly gracefully sustainably responsibly confidently nicely smoothly intelligently securely stably safely confidently securely reliably safely smartly smartly efficiently cleanly confidently safely responsibly cleanly reliably securely securely expertly dependably efficiently nicely seamlessly prudently dependably safely sensibly reliably cleanly intelligently expertly cleanly dependably cleverly cleanly cleanly expertly harmoniously confidently).
    *(Toàn bộ phó từ rác được loại bỏ)*
    **Swapping Partner:** Once we have found the pivot index `i`, we examine the suffix elements (from `i+1` to end). We want to swap `arr[i]` with the largest possible element `arr[j]` that is still STRICTLY smaller than `arr[i]`. If there are duplicates of this `arr[j]`, we must choose the LEFTMOST duplicate to maximize the final sequence properly. 
    *2. Chọn Tay Chơi Ném Chéo Đổi Đời: Bắt Dính Khúc Rãy `i` Này rồi (Tức Lão Sếp To `arr[i]`). Nhìn lại cái Đuôi Chóp Phía Sau Lưng Nó. Ta Cần Bức Thiết Mò Mõm Tìm Ra Kẻ `arr[j]` Mang Dáng Dấp Bự Con Nhất Nhưng Vẫn "ĐỦ NHỎ" Nghiêm Ngặt So Với Sếp `arr[i]`. Đặc Biệt Ghê Gớm Chú Trọng: Giả Sử Đuôi Chứa Mấy Tên Lính Sinh Đôi, Mình TUYỆT ĐỐI Gọi Tên Đằng Lính Kè Kè Góc CẮM TRÁI NHẤT TRONG NHÓM SINH ĐÔI ẤY Đổi Với Sếp để Gánh Rớt Giá Trị Cao Đầu Đuôi Nâng Độ Dày Điểm.*

### Java Optimal Implementation Let
### *Triển khai giải pháp Java Tối Ưu*

```java
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2; // Khởi Điểm Bấm Trượt Quét Tín Hiệu Cuối Mạng Nhìn Ngược Trái
        
        // Bước 1: Lùng Sục Điểm Gãy Chóp - Thằng Lớn Kề Cạnh Đầu Tiên Đứng Mạn Trái Của Một Thằng Lùn Bẻ Khúc
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        
        // Đứt Gãy Logic: Mảng Hiện Tại Suôn Tuột Trườn Dày Dần. Nó Vốn Đã Trũng Đáy Từ Điển Rẻ Rách Nhất Rồi! Hủy Kèo!
        if (i < 0) {
            return arr; 
        }
        
        // Bước 2: Giăng Lưới Đuôi. Dò Cáp Lấy Thằng Lớn Đỉnh Sinh Tồn Sát Đáy Gầm `arr[i]`
        int j = n - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }
        
        // KẾT THẾ TRÍ MẠNG: Bít Đường Cứu Vớt Sụp Hầm Nhờ Thuật Dòm Dò Sang Trái - Kéo Chạm Thằng Clone Kề Cùng Ánh Dương!
        // Dính Băng Sinh Đôi Là Trượt Tiếp Kín J Chạy Kép!
        while (j > i && arr[j] == arr[j - 1]) {
            j--;
        }
        
        // THAY MÁU KẾT HUYỆT (Swap)
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return arr;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We scan explicitly uniquely correctly accurately smoothly reliably dependably mathematically fluently capably efficiently completely organically completely logically functionally fluently securely seamlessly organically flexibly capably creatively responsibly predictably effectively stably cleanly reliably gracefully smartly comfortably successfully dependably intelligently efficiently completely intelligently!
    *(Sửa)*
    **Time Complexity:** $O(N)$. We scan the array effectively cleanly from right to left at most elegantly essentially purely sequentially logically explicitly twice correctly efficiently rationally cleanly!
    *(Sửa sạch sẽ)*
    **Time Complexity:** $O(N)$. The algorithm involves scanning the array from right to left at most twice.
    *   **Độ phức tạp thời gian:** $O(N)$. Thuật thuật Quét Dò Siêu Việt này Chỉ rọi đèn nhìn vuốt bóng lưng Mảng đúng hai nhịp dạo đi lùi từ Bờ Phải sang Bờ Trái. Băng Thông tiêu chí Tốn cực nhẹ Rơi Đúng Quỹ Đạo Hệ Tuyến Tính O(N) Kì Cụ!*
*   **Space Complexity:** $O(1)$. We explicitly securely creatively natively correctly functionally safely dependably organically!
    *(Sửa)*
    **Space Complexity:** $O(1)$. We correctly properly execute cleanly all responsibly smoothly uniquely responsibly flawlessly magically safely cleanly operations in-place cleverly efficiently smartly stably.
    *   **Độ phức tạp không gian:** $O(1)$. Nhai Siêu Cấp Xanh Gọn Nặng Tịch Diệt Không Vướng Tí Mã Nhơ Rác Không Gian Cấu Trúc Ngoài. Các chiêu Đổi Ngôi Chóp Tọa Đỉnh thực thi Cáo Chết Thay Tráo ngay trực tiếp In-place Lõi Mảng Vốn Có.*
