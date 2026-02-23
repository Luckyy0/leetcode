# Analysis for Implement Stack using Queues
# *Phân tích cho bài toán Triển khai Stack bằng Queue*

## 1. Problem Essence & Data Structure Limits
## *1. Bản chất vấn đề & Giới hạn cấu trúc dữ liệu*

### Queue vs Stack
### *Hàng đợi vs Ngăn xếp*
- **Queue:** FIFO (First In First Out). Add to Back, Remove from Front.
- **Stack:** LIFO (Last In First Out). Add to Back, Remove from Back.
The challenge is to simulate "Remove from Back" using only "Add to Back" and "Remove from Front".
*Hàng đợi: FIFO. Ngăn xếp: LIFO. Thách thức là mô phỏng "Lấy từ Cuối" chỉ bằng "Thêm vào Cuối" và "Lấy từ Đầu".*

---

## 2. Approach 1: Two Queues
## *2. Hướng tiếp cận 1: Hai hàng đợi*

### Logic
### *Logic*
To `pop`, moves `n-1` elements from Q1 to Q2, leaving the last element. Pop it. Then swap Q1 and Q2.
Or make `push` costly: Add to Q2. Move all elements from Q1 to Q2. Swap names.
*Để `pop`, di chuyển `n-1` phần tử. Hoặc làm `push` đắt đỏ: Thêm vào Q2, chuyển hết Q1 sang Q2.*

---

## 3. Approach 2: One Queue (The Follow-up)
## *3. Hướng tiếp cận 2: Một hàng đợi (Câu hỏi mở rộng)*

### Logic
### *Logic*
1.  **Push(x):**
    - Add `x` to the queue.
    - Since `x` is now at the back but needs to be at the front (for LIFO), we can **rotate** the queue.
    - `size = queue.size()`.
    - Loop `size - 1` times: `queue.add(queue.poll())`.
    - Now `x` is at the front!
2.  **Pop():**
    - `queue.poll()`. (Since top is at front). $O(1)$.
3.  **Top():**
    - `queue.peek()`. $O(1)$.

Cost: `Push` takes $O(N)$ because rotation. `Pop` takes $O(1)$.
*Push: Thêm x, sau đó xoay vòng `n-1` phần tử đầu tiên ra sau. X sẽ lên đầu. Tốn O(N). Pop trở thành O(1).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - Push: $O(N)$.
    - Pop: $O(1)$.
    *Độ phức tạp thời gian: Push $O(N)$, Pop $O(1)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Queue:** `[]`
**Push 1:** Add 1. `[1]`. Rotate 0 times. `[1]`.
**Push 2:** Add 2. `[1, 2]`. Rotate 1 time (size-1).
    - Poll 1, Add 1.
    - Queue becomes `[2, 1]`.
**Push 3:** Add 3. `[2, 1, 3]`. Rotate 2 times.
    - Poll 2, Add 2 -> `[1, 3, 2]`
    - Poll 1, Add 1 -> `[3, 2, 1]`
    - Top is 3. Correct.
**Pop:** Remove 3. `[2, 1]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The "One Queue" approach is clever and preferred in interviews. It relies on the circular nature of rotating elements.
*Cách tiếp cận "Một hàng đợi" rất thông minh và được ưa thích trong phỏng vấn.*
---
*Đôi khi để vươn lên đứng đầu (Stack top), bạn phải chấp nhận đi một vòng tròn lớn (Queue rotation).*
Sometimes to get to the top (Stack top), you have to accept going in a big circle (Queue rotation).
