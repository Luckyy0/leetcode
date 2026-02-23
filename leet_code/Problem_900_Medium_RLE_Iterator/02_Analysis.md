# Analysis for RLE Iterator
# *Phân tích cho bài toán Trình lặp Mã hóa Độ dài Chạy*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Implement an iterator for a Run-Length Encoded array. The `next(n)` function consumes `n` elements and returns the value of the last consumed element.
*Triển khai một trình lặp cho một mảng RLE. Hàm `next(n)` tiêu thụ `n` phần tử và trả về giá trị của phần tử cuối cùng được tiêu thụ.*

### KEY LOGIC
### *Logic chính*
We need to maintain a pointer `idx` to the current position in the `encoding` array.
- `encoding[idx]` is the count of elements.
- `encoding[idx+1]` is the value of the elements.
When `next(n)` is called:
- We check if `n` is greater than the current count `encoding[idx]`.
- If `n > encoding[idx]`:
  - Subtract current count from `n`.
  - Move `idx` to the next pair (increment by 2).
  - Repeat until `n <= encoding[idx]` or we run out of elements.
- If `n <= encoding[idx]`:
  - Subtract `n` from `encoding[idx]` (updating the remaining count).
  - Return `encoding[idx+1]`.
*Chúng ta cần duy trì một con trỏ `idx` đến vị trí hiện tại trong mảng `encoding`. Khi `next(n)` được gọi: Kiểm tra nếu `n` lớn hơn số lượng hiện tại, trừ đi và chuyển sang cặp tiếp theo. Nếu `n` nhỏ hơn hoặc bằng, trừ đi `n` từ số lượng hiện tại và trả về giá trị của cặp đó.*

---

## 2. Strategy: Pointer Maintenance
## *2. Chiến lược: Duy trì Con trỏ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `idx = 0`, copy or reference `encoding` array.
    *   **Khởi tạo:** `idx = 0`, sao chép hoặc tham chiếu mảng `encoding`.*

2.  **Next(n):**
    - Loop while `idx < encoding.length`:
        - If `n > encoding[idx]`:
            - `n -= encoding[idx]`.
            - `idx += 2`.
        - Else:
            - `encoding[idx] -= n`.
            - Return `encoding[idx + 1]`.
    - If loop ends (exhausted array), return `-1`.
    *   **Next(n):** Lặp trong khi chưa hết mảng: Nếu `n` lớn hơn số lượng hiện tại, trừ `n` và nhảy sang cặp kế. Ngược lại, cập nhật số lượng và trả về giá trị. Nếu hết mảng, trả về -1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class RLEIterator {
    int[] encoding;
    int idx;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.idx = 0;
    }
    
    public int next(int n) {
        while (idx < encoding.length) {
            if (n > encoding[idx]) {
                n -= encoding[idx];
                idx += 2;
            } else {
                encoding[idx] -= n;
                return encoding[idx + 1];
            }
        }
        return -1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ effectively. Each element in `encoding` is visited and skipped once. Over `K` calls, total amortized time is proportional to `encoding` length + `K`.
    *   **Độ phức tạp thời gian:** $O(N)$ hiệu quả. Mỗi phần tử được thăm và bỏ qua tối đa một lần.*
*   **Space Complexity:** $O(1)$ auxiliary space (if modifying input array is allowed/expected).
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Modifying the `encoding` array in-place to track remaining counts is efficient and simplifies logic.
*Việc sửa đổi trực tiếp mảng `encoding` để theo dõi số lượng còn lại là hiệu quả và đơn giản hóa logic.*
