# Analysis for Moving Stones Until Consecutive II
# *Phân tích bài toán Di chuyển Đá cho đến khi Liên tiếp II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We have an array of stones on a number line. At each step, we must pick an endpoint stone and place it strictly inside the array between other existing stones. The process ends when all `n` stones are entirely consecutive. Our goal is to find the minimum and maximum possible valid moves to reach this state.
*Chúng ta có một chuỗi các viên đá rải rác trên trục số. Ở mỗi bước, bắt buộc nhặt bốc một viên đá nằm ngoài rìa mút (đầu hoặc đuôi) và chèn ép nó vào một Hố Lõm Trống ở giữa cụm đá còn lại. Trò chơi kết thúc khi toàn bộ `n` viên đá dính khít liền mạch với nhau. Mục tiêu: Bòn rút ra số bước tối thiểu và tối đa có thể đánh ra.*

---

## 2. Strategy: Optimal (Sliding Window & Gap Math)
## *2. Chiến lược: Tối ưu (Cửa Sổ Trượt và Toán Học Rỗng)*

### Calculating Maximum Moves
### *Bòn Số Bước Đi Rùa Bò (Lớn Nhất)*

To maximize our moves, we essentially want to squeeze the stones inward as slowly as mathematically possible, crushing exactly 1 unit of empty space per move. The absolute maximum number of moves corresponds to the total number of empty spaces available between the stones.
*Muốn câu giờ kéo dài số bước đi dài tới lết bánh, ta chỉ việc nhích rùa bò từng viên đá mút chóp vào đúng cái Khẽ hở Trống Nhỏ Nhất cắm ngay vị trí kề nó. Tống hết tổng số Chỗ Rỗng trên trục số chính là Số Lượt đập đá Mãn Nhãn lớn nhất.*

However, the very **first move** is special. When we move the left endpoint `stones[0]`, we are forced to jump over `stones[1]`. Thus, we permanently lose all the empty spaces between `stones[0]` and `stones[1]`. Alternatively, if we move `stones[n-1]`, we abandon the gap between `stones[n-1]` and `stones[n-2]`.
*Tuy nhiên, cái Oái ăm của Nước Đi Đầu Tiên lật kèo toàn bộ. Khi bốc Đá đầu Mút trái `stones[0]`, luật bắt cắm vào "Khoảng Không Bên Trong", ép bạn phải nhảy Cóc Vượt Qua Đầu Thằng Kế Cận `stones[1]`. Hậu quả: Toàn bộ Lỗ Hổng bám khít giữa số `0` và số `1` sẽ LÃNG PHÍ BỊ VỨT BỎ MÃI MÃI! Nếu bốc Quả Phải `n-1` thì cũng mất trắng Quỹ Đất nứt giữa `n-1` và `n-2`.*

To maximize the remaining moves, we intelligently choose to abandon the smaller gap!
`MaxMoves = Total_Empty_Spots - min(Gap_Left, Gap_Right)`
*Thủ Khoa là đây: Ngu gì vứt mẩu Bánh To? Ta hi sinh bóc cục Rìa chứa Cái Lỗ Cạnh Nhỏ Hơn Vứt đi! Đất trống còn dư Tha Hồ Câu Giờ!*

### Calculating Minimum Moves
### *Chốt Sổ Quét Rác (Nhỏ Nhất)*

We want to find a sliding window of size `n` which ALREADY contains the maximum number of stones. Let's say this specific window naturally captures `count` stones. We efficiently only need `n - count` moves to pick up the outsider stones and drop them into the empty slots within this window!
*Cách gom đồ lười biếng nhất: Coi Trục Số như Bãi Cỏ. Ném một cái Khung Lưới Chài rộng đúng bằng Kích thước Cố định `n` trượt qua trượt lại trên bãi. Rà trúng vùng Khung lưới nào mà TRONG ĐÓ SẴN ĐÔNG ĐÁ NHẤT (`count` viên nấp sẵn), ta chỉ việc lấy cái Rổ nhặt số đá rơi rớt ở ngoài Cắm Ngập vào là Xong! (Cần `n - count` Lượt nhặt).*

**Warning - The Edge Case (Bẫy Rập Rìa):**
If a window naturally holds exactly `n-1` stones, and they are mathematically perfectly consecutive (`1, 2, 3, 4`), but the last stone is aggressively far away (e.g., `10`).
*Bạn bắt được mẻ lưới có 4 viên đá Nằm Khít Dính Xếp Hàng `(1, 2, 3, 4)`. Còn viên thứ 5 Văng Mạng Tuốt Tọa Độ `10`. Áp Dụng Công Thức: Còn Sót 1 viên, ném 1 bước là nhét vô khung lưới! $\to$ LỆNH CẤM DO SAI LUẬT!*
If you drop `10` right next to `4` (at position `5`), it instantly mathematically becomes a new endpoint! The rules strongly forbid turning an active endpoint into a completely new isolated endpoint! You MUST physically jump the other end first (e.g., move `1` to `6`), and logically follow up moving `10` to `5`. This specifically demands strictly **2 moves**.
*Cầm đá 10 ném xuống số `5`, Đá Nhảy Trúng Vị Trí BIÊN! Luật CẤM tuyệt đối không được bốc Rìa rồi Lại Quăng Ra Chỗ Rìa Khác! Bạn ÉP BUỘC phải dập nát Trận Đồ: Bốc Vỡ số 1 ném qua Rìa 6. Ráp 10 Nhảy vòng trượt xuống số 5! Mất tốn Tổng Đúng Kịch 2 Nháy!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.Arrays;

public class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        
        // Max Moves = Total Gaps - Cắt lỗ khe Trống Nhỏ Hơn ở Rìa.
        int gap1 = stones[n - 2] - stones[0] - (n - 2); 
        int gap2 = stones[n - 1] - stones[1] - (n - 2); 
        int maxMoves = Math.max(gap1, gap2);
        
        // Trượt Lưới Sliding Window Bắt Cá tìm Min
        int minMoves = n;
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            // Khung lưới Size cố định = n. Bức Tường rách màng, đẩy Mút i Lên
            while (stones[j] - stones[i] + 1 > n) {
                i++;
            }
            
            int countInWindow = j - i + 1;
            
            // Xử lý Lỗi Tình thế Oái Oăm: Cỗ máy Dính Bẫy Liên Tiếp Khít Rịt ở 1 cọc Biên Kéo n-1
            if (countInWindow == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                minMoves = Math.min(minMoves, 2); // Nã Cầm Chừng Buộc Vượt 2 Bước
            } else {
                // Công thức Trượt Vét Min Kinh Điển
                minMoves = Math.min(minMoves, n - countInWindow);
            }
        }
        
        return new int[]{minMoves, maxMoves};
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$. Bottlenecked completely strictly by the underlying initial array sorting functionality. The linear sliding loop safely elegantly completes within pure constant limits.
    *   **Độ phức tạp thời gian:** $O(N \log N)$. Cú ngáng chân chí mạng gây cấn Cốt Lõi Nặng Não chỉ nằm chỏng chơ Dãy Kính Sort Mảng Lúc Khởi Đầu. Vòng lặp Rượt Bắt Trượt Lưới Min chạy Trơn Tụt Dốc Băng $O(N)$ Không Hắt Xì Hơi.*
*   **Space Complexity:** $O(1)$ nominally natively gracefully intelligently properly processed seamlessly explicitly smoothly natively intuitively securely rationally securely. Note that the internal sorting mechanism potentially scales bounds logistically linearly.
    *   **Độ phức tạp không gian:** $O(1)$. Hệ số Phụ trợ Biến Tạm Trôi Lửng lơ vài mẩu Con Trỏ `i`, `j`, không thâm thủng Tràn Lan RAM. Nếu khắt khe Soi Kỹ Lên Thớt Sorting Tiền Trạm Máy Ảo Java thì Ngậm Rễ ở Cành $O(N \log N)$ Nhẹ Kéo (Space Complexity of Quick/Merge Sort). Bất Biến!*
