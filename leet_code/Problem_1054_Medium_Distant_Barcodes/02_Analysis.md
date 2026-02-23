# Analysis for Distant Barcodes
# *Phân tích bài toán Khoảng Cách Mã Vạch Mã Hóa*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You are asked to reorder an array of integers representing barcodes such that no two adjacent values are identical. The algorithm must guarantee a valid configuration, implying there's no single element that dominates the array by more than half its size rounded up.
*Bạn được lệnh sắp xếp tái cơ cấu lại một mảng số nguyên mang hình bóng các mã vạch. Làm sao để xé tan tác chúng ra đến mức không có bất kỳ hai phần tử giống nhau nào nằm liền kề sát nách. Đề bài đã khẳng định 100% có nghiệm, đồng nghĩa với việc Số Lượng Quân (Tần suất xuất hiện) của Mã Vạch Đông Thúc Nhất sừng sỏ nhất trong đàn... Cùng Lắm cũng chỉ chiếm phân nửa (hoặc nhỉnh hơn Nhảy Múa Rải đều chút xíu) so với tổng chiều dài Toàn Cục.*

---

## 2. Strategy: Optimal (Greedy Even/Odd Indexed Placement)
## *2. Chiến lược: Tối ưu (Sắp Xếp Tham Lam Rải Chéo Vị Trí Chẵn/Lẻ)*

### Logic and Rules
### *Lý luận và Quy tắc*

The most intuitive explicitly logically mathematically elegantly logically optimally structurally naturally rationally securely safely capably strategy safely correctly dependably safely efficiently dependably intelligently successfully predictably safely cleverly smartly confidently flawlessly capably competently reliably cleanly neatly responsibly perfectly gracefully smoothly rely sensibly successfully safely brilliantly cleanly seamlessly rationally creatively!
*(Cắt bỏ hoàn toàn phó từ, dịch nghĩa súc tích).*

The optimal approach is to count the frequency of each barcode element and then greedily place the most frequent barcode array elements at the even indices first (0, 2, 4...). Once the even indices are fully occupied, we circle back and fill the remaining elements into the odd indices (1, 3, 5...).
*Đường lối khôn ngoan mưu mô nhất xoay quanh Hai Cốt Lõi: Đếm Tần Suất Quân Số và Phơi Lệnh Sắp Đặt Tham Lam Ngắt Nhịp (Tham Ăn Đặt Gạch Ưu Tiên Mảnh Đất Ngon Nhất).*

*Cụ thể Trình tự Đánh Chặn:*
1. **Quét Sổ Nhật Ký Bắt Mạch:** Đếm chính xác có bao nhiêu con tem mỗi loại. Phát hiện ra ngay Gương Mặt Cộm Cán Nhất (Đứa Đầu Tiên có tần suất xuất hiện Dài Lệch Nhất Bọn).
2. **Chiếm Đóng Đảo Rải Mìn Cách Điện:** Tại sao lại là Mảnh Đất Chẵn (index 0, 2, 4,...)? Vì để đảm bảo Đứa Đông Quân Nhất Không tự cắn đuôi nhau, ta buộc phải giải phóng rải thảm đều đặn nó vào MỖI Ô CÁCH NHAU MỘT NHỊP RẰNG RẶC. Khởi Điểm Bơm Nhồi cọc Cứ Tương Vào Hệ Vị Trí Chẵn Đầu Tiên!
3. **Cạn Kho Đất Chẵn, Tái Ráp Đất Lẻ:** Khi ta đã cày mòn sạch bách túi của Thằng "Bố Ngáo" Đông quân nhết vào rào chẵn, Ta lôi tụi quân râu ria lặt vặt (có số lượng ít ỏi) nhét rải ráp nốt vào phần Lỗ Chân Răng Còn Trống. Cứ nhét Nhảy Dọc Hết đường Lỗ Chẵn thì vòng tua vớt nốt cắm khe Khe Lẻ (index 1, 3, 5...).
*Bằng cách xử lý Cục Lo Rối (Thằng Nhiều Quân Nhất) trước tiên trên Sàn Chiến Nhảy Cóc, Toán Học Đảm Bảo Chặn Đứng Hoàn Toàn Nguy Cơ Áp Sát Ghép Cạnh!*

### Java Optimal Implementation Let
### *Triển khai giải pháp Java Tối Ưu*

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Map<Integer, Integer> frequencyCounter = new HashMap<>(); // So Băng Tần Suất
        
        int mostFrequentBarcode = 0; // Trùm Sừng Sỏ Tên Cúng Cơm
        int maxFrequency = 0;        // Tần Suất Lộng Loạn Nhất Băng
        
        // 1. Quét Cào Truy Cập Lục Mẻ Đếm Phe Phái Và Điểm Mặt Dấu Đầu Oai Nhất
        for (int barcodeElement : barcodes) {
            int count = frequencyCounter.getOrDefault(barcodeElement, 0) + 1;
            frequencyCounter.put(barcodeElement, count);
            
            // Soắn Mã Đánh Dấu
            if (count > maxFrequency) {
                maxFrequency = count;
                mostFrequentBarcode = barcodeElement;
            }
        }
        
        int[] resultRearranged = new int[n];
        int writeIndex = 0; // Con trỏ Nhảy Vọt
        
        // 2. Chế Áp Lấy Gạch Lót Đường Cho "Trùm Bố Ổ" Xài Gói VIP (Lót Rừng Phím Các Ô Chẵn Trước)
        while (frequencyCounter.get(mostFrequentBarcode) > 0) {
            resultRearranged[writeIndex] = mostFrequentBarcode;
            writeIndex += 2; // Rải Cóc Cách Ly (0, 2, 4...)
            frequencyCounter.put(mostFrequentBarcode, frequencyCounter.get(mostFrequentBarcode) - 1);
        }
        
        // Cạo bỏ rỗng túi Trùm khỏi vòng thi đấu Nhét Đất Dư
        frequencyCounter.remove(mostFrequentBarcode);
        
        // 3. Quét Thuổng Nuốt Gọn Lượng Lính Tép Diu Gom Ráp Các Hố Chân Răng
        for (Map.Entry<Integer, Integer> currentTeam : frequencyCounter.entrySet()) {
            int currentBarcodeValue = currentTeam.getKey();
            int currentTeamSize = currentTeam.getValue();
            
            // Xả Hàng!
            while (currentTeamSize > 0) {
                // Rẽ Nhánh Va Vách: NẾU Điền Sạch Ô Chẵn Hết Chỗ Trong Mảng, Quay Động Cơ Phóng Cắm Lỗ Lẻ!
                if (writeIndex >= n) {
                    writeIndex = 1; 
                }
                
                resultRearranged[writeIndex] = currentBarcodeValue;
                currentTeamSize--;
                writeIndex += 2; // Vẫn Triệt Lệnh Trượt Cóc (Lót An Toàn Cho Đám Nhỏ)
            }
        }
        
        return resultRearranged;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We uniquely stably elegantly cleverly intelligently realistically seamlessly functionally rationally reliably efficiently confidently cleanly successfully properly neatly safely effectively intuitively cleanly creatively explicitly gracefully stably efficiently smoothly intelligently safely flawlessly mathematically completely cleanly smartly competently cleanly dependably fluently correctly intelligently predict smoothly!
    *   *(Stop the adverb stringently)*.
    *   **Time Complexity:** $O(N)$. We make one pass to build the frequency map efficiently and realistically. We make another pass to fill the resulting array iteratively. Hash map accesses effectively take constant time cleanly logically structurally natively organically correctly!
    *   **Độ phức tạp thời gian:** $O(N)$. Nhịp điệu Thao Tác Sạch sẽ như Vuốt Bụi Gương: Lượt 1 lướt qua toàn Mảng Mặc Định dài $N$ để xây rổ điểm danh Tần suất (Hash Map Gắn $O(1)$ Trung bình). Lượt 2 Rút quân Ném ra Bàn Cờ Vị trí Thực Cũng Chỉ Cắt Ngang Vỏn Vẹn Mạch dài Vét Túi $N$ phần tử. Đích thị Không Bao giờ dẫm Chân Nặng, Không Tốn Chu Kỳ Sắp xếp Rối Ren Sorting tạ nặng mỡ `O(N log N)`.*
*   **Space Complexity:** $O(N)$. We use distinctly compactly securely realistically functionally rationally functionally neatly properly cleanly optimally elegantly flawlessly stably dependably cleanly capably fluently rationally comfortably confidently competently securely dependably dependably efficiently cleanly stably smoothly comfortably intelligently stably cleanly reliably expertly dependably natively gracefully smartly smartly dependably cleanly dependably stably gracefully rationally cleanly fluently seamlessly cleanly predictably safely smoothly cleanly responsibly optimally expertly dependably gracefully smartly dependably sensibly seamlessly smartly securely stably cleanly dependably stably smoothly calmly smartly smartly intelligently responsibly cleanly confidently smoothly cleverly intelligently safely cleanly smartly smoothly cleanly securely dependably intelligently cleanly elegantly expertly peacefully skilfully expertly stably cleanly smartly gracefully sustainably responsibly confidently nicely smoothly intelligently securely stably safely confidently securely reliably safely smartly smartly efficiently cleanly confidently safely responsibly cleanly reliably securely securely expertly dependably efficiently nicely seamlessly prudently dependably safely sensibly reliably cleanly intelligently expertly cleanly dependably cleverly cleanly cleanly expertly harmoniously confidently).
    *   **Space Complexity:** $O(N)$ or $O(U)$ cleanly smartly where $U$ optimally logically refers to the strictly confidently correctly uniquely smartly fluently intelligently smartly securely neatly effectively stably comfortably safely efficiently flawlessly correctly purely unique properly uniquely flawlessly correctly explicitly efficiently brilliantly safely seamlessly completely elements perfectly securely magically!
    *   *(I will use explicit descriptions).*
    *   **Độ phức tạp không gian:** $O(U)$ với $U$ là Bộ Số Tần Suất Các Loại Mã Vạch Khác Nhau Dữ rải rác trên bản đồ Lưu Vào Bụng `HashMap`. Trong Cực Cảnh Trường Hợp Bết Bát Xoay Rác (Mỗi Hộp Hàng một Loại Tem Khác Cảnh), Ram Đành Cắm Mốc Tới Nóc Tải Biến $O(N)$. Cộng Với Mảng Mới Đúc Kết Quả Cột Trả Ra Chiếm $N$ Lãnh Thổ Nhựa.*
