# Analysis for Design Hit Counter
# *Phân tích cho bài toán Thiết kế Bộ đếm Truy cập*

## 1. Problem Essence & Circular Buffer
## *1. Bản chất vấn đề & Bộ đệm Vòng*

### The Challenge
### *Thách thức*
Counting occurrences over a sliding window of 300 seconds. If millions of hits occur at the same second, storing each timestamp individually in a queue becomes memory-intensive and slow to prune.

### Strategy: Buckets (Bucketing by Second)
### *Chiến lược: Phân nhóm (Theo từng Giây)*
Since we only care about the last 300 seconds, we can use an array of size 300 to represent a circular buffer.
1.  `times[300]`: Stores the timestamp associated with each bucket.
2.  `hits[300]`: Stores the count of hits for that timestamp.

### Logic:
### *Logic:*
-   `hit(timestamp)`:
    -   Find index: `idx = timestamp % 300`.
    -   If `times[idx] != timestamp`: It's a new timestamp for this bucket. Reset `times[idx] = timestamp` and `hits[idx] = 1`.
    -   If `times[idx] == timestamp`: Increment `hits[idx]`.
-   `getHits(timestamp)`:
    -   Iterate through all 300 buckets.
    -   If `timestamp - times[i] < 300`, add `hits[i]` to total.

---

## 2. Approach: Circular Array
## *2. Hướng tiếp cận: Mảng Vòng*

### Logic
### *Logic*
(See Strategy above). This approach handles massive hits per second efficiently because it aggregates by second.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Scalability:** Independent of the absolute number of hits. Memory is fixed ($O(300)$).
    *Khả năng mở rộng: Không phụ thuộc vào số lượng truy cập tuyệt đối. Bộ nhớ cố định.*
*   **O(1) Hit:** Updating a bucket is an $O(1)$ operation.
    *Hit O(1): Cập nhật một thùng là O(1).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `hit`: $O(1)$.
    - `getHits`: $O(W)$ where $W = 300$.
    *Độ phức tạp thời gian: O(1) cho hit, O(300) cho getHits.*
*   **Space Complexity:** $O(W)$.
    *Độ phức tạp không gian: $O(300)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Operation:** `hit(301)`
1. `idx = 301 % 300 = 1`.
2. Check `times[1]`. If it was `1` (from 5 mins ago), it's now stale.
3. Update `times[1] = 301`, `hits[1] = 1`.
**Operation:** `getHits(301)`
- Loop 0..299.
- If `301 - times[i] < 300`, sum `hits[i]`.
- `times[1]` (301) is valid. `times[0]` (300) is valid. `times[2]` (2) is STALE.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Circular Buffer/Buckets for scalability.
*Bộ đệm Vòng/Thùng để đạt khả năng mở rộng.*

---

## 7. Deep Dive: Why Circular Buffer?
## *7. Thảo luận chuyên sâu: Tại sao dùng Bộ đệm vòng?*

### Scaling with High Traffic
### *Mở rộng với lưu lượng truy cập cao*
In a real-world system, hits could reach millions per second. A simple `Queue<Integer>` would store each hit as a separate object, leading to massive memory consumption and $O(N)$ removal time.
*Trong một hệ thống thực tế, số lượt truy cập có thể lên tới hàng triệu mỗi giây. Một hàng đợi `Queue<Integer>` đơn giản sẽ lưu trữ mỗi lượt truy cập như một đối tượng riêng biệt, dẫn đến tiêu tốn bộ nhớ khổng lồ và thời gian xóa O(N).*

The circular buffer approach aggregates hits:
- **Memory Efficiency:** Constant space $O(300)$ regardless of hit volume.
- **Speed:** $O(1)$ `hit()` operation (just an array increment).
- **Graceful Expiration:** Older hits are automatically "overwritten" when the timestamp cycles back, avoiding complex cleanup logic.
*Cách tiếp cận bộ đệm vòng gộp các lượt truy cập:*
- *Hiệu quả bộ nhớ: Không gian cố định $O(300)$ bất kể khối lượng truy cập.*
- *Tốc độ: Thao tác `hit()` O(1) (chỉ là tăng giá trị mảng).*
- *Hết hạn tự nhiên: Các lượt truy cập cũ sẽ tự động bị "ghi đè" khi dấu thời gian quay vòng lại, tránh logic dọn dẹp phức tạp.*
---
*Thời gian trôi đi (timestamps), nhưng những dấu ấn ý nghĩa nhất (hits) thường nằm ở những khoảnh khắc gần đây (window 300s). Biết cách "dọn dẹp" những gì đã cũ (circular buffer) giúp hệ thống của chúng ta luôn nhẹ nhàng và hiệu quả.*
Time passes (timestamps), but the most meaningful imprints (hits) often lie in recent moments (300s window). Knowing how to "clean up" what is old (circular buffer) helps our system stay lightweight and efficient.
