# Analysis for Max Consecutive Ones II
# *Phân tích cho bài toán Chuỗi số 1 Liên tiếp Dài nhất II*

## 1. Problem Essence & Sliding Window (k=1)
## *1. Bản chất vấn đề & Cửa sổ Trượt (k=1)*

### The Challenge
### *Thách thức*
Finding the longest subarray containing at most one zero. This is effectively finding the longest window where sum of zeros $\le 1$.

### Strategy: Sliding Window (Two Pointers)
### *Chiến lược: Cửa sổ Trượt (Hai con trỏ)*

1.  **Iterate `right`:** Expand the window by moving `right`.
2.  **Count Zeros:** If `nums[right] == 0`, increment `zeros`.
3.  **Shrink `left`:** While `zeros > 1`, check `nums[left]`. If `nums[left] == 0`, decrement `zeros`. Increment `left`.
4.  **Update Max:** `maxLen = max(maxLen, right - left + 1)`.

### Follow up: Infinite Stream (Data Processing)
### *Mở rộng: Luồng vô hạn (Xử lý Dữ liệu)*
If we cannot store the array, we stream data.
- We need to know where the *previous* zero was seen to know where to jump `left` to.
- Store `lastZeroIndex`. If we see a new zero, we know the new window must start after the old `lastZeroIndex`.
- For `k=1`, we only need to store **one** index (or index relative to current stream position, essentially a queue of size 1).

---

## 2. Approach: Sliding Window
## *2. Hướng tiếp cận: Cửa sổ Trượt*

### Logic
### *Logic*
(See above). Standard template.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Each element visited twice at most.
    *Thời gian O(N): Mỗi phần tử được thăm tối đa hai lần.*
*   **O(1) Space:** Only store indices/counters.
    *Không gian O(1): Chỉ lưu chỉ mục/bộ đếm.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 0, 1, 1, 0]`
1. `r=0 (1)`: zeros=0. Len=1.
2. `r=1 (0)`: zeros=1. Len=2.
3. `r=2 (1)`: zeros=1. Len=3.
4. `r=3 (1)`: zeros=1. Len=4.
5. `r=4 (0)`: zeros=2.
   - Shrink loop:
     - `l=0 (1)`.
     - `l=1 (0)`: zeros $\to$ 1. inc `l` to 2.
   - Window `[2..4]`: Len 3.
Max was 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sliding window maintaining zero count. For stream, use a `Queue` to store zero indices.
*Cửa sổ trượt duy trì số lượng số 0. Đối với luồng dữ liệu, sử dụng Hàng đợi để lưu chỉ mục số 0.*
---
*Sai lầm (zero) là điều không thể tránh khỏi, nhưng cách ta xử lý nó mới định hình nên độ dài của thành công (max consecutive ones). Nếu ta cho phép mình được sửa sai một lần (flip at most one), ta có thể nối liền những đoạn ngắt quãng thành một chuỗi liên tục dài hơn. Nhưng để làm được điều đó, ta phải biết buông bỏ quá khứ (sliding window left) ngay khi sai lầm thứ hai xuất hiện.*
Mistakes (Zero) are inevitable, but how we handle it shapes the length of success (Max Consecutive Ones). If we allow ourselves to correct a deviation (Flip at Most One), we can connect the interruptions into a longer continuous sequence. But to do that, we must know how to let go of the past (Sliding Window Left) as soon as the second mistake appears.
