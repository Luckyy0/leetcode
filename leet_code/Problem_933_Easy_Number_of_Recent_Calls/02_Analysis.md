# Analysis for Number of Recent Calls
# *Phân tích cho bài toán Số cuộc gọi Gần đây*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count ping requests in the range `[t - 3000, t]`.
*Đếm số lần ping trong khoảng `[t - 3000, t]`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Since `t` is strictly increasing, older pings can be discarded once they are outside the `3000`ms window.
- This suggests a **Queue** data structure.
- When `ping(t)` comes:
  - Add `t` to the queue.
  - While `queue.peek() < t - 3000`, remove elements.
  - Return `queue.size()`.
*Vì `t` tăng dần nghiêm ngặt, các lần ping cũ có thể bị loại bỏ khi vượt quá cửa sổ `3000`ms. Sử dụng Queue. Thêm t, sau đó xoá các phần tử cũ. Trả về kích thước Queue.*

---

## 2. Strategy: Queue
## *2. Chiến lược: Hàng đợi*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `queue = new LinkedList`.
    *   **Khởi tạo:** `queue`.*

2.  **Ping(t):**
    - `queue.add(t)`.
    - While `queue.peek() < t - 3000`: `queue.poll()`.
    - Return `queue.size()`.
    *   **Ping(t):** Thêm t. Xóa phần tử cũ. Trả về kích thước.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ amortized. Each element is added once and removed once.
    *   **Độ phức tạp thời gian:** $O(1)$ trung bình.*
*   **Space Complexity:** $O(3000) \approx O(1)$. Queue size is bounded by max pings in 3 seconds.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple usage of Queue for sliding window of time.
*Sử dụng Queue đơn giản cho cửa sổ thời gian trượt.*
