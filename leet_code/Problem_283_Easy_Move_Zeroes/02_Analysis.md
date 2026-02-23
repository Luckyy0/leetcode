# Analysis for Move Zeroes
# *Phân tích cho bài toán Di chuyển Số không*

## 1. Problem Essence & Two Pointers
## *1. Bản chất vấn đề & Hai con trỏ*

### The Challenge
### *Thách thức*
Move non-zeroes to front. Fill remaining with zeros.
Maintain order. No extra copy.

### Strategy: Reader and Writer Pointers
### *Chiến lược: Con trỏ Đọc và Ghi*
`read` iterates through the array.
`write` points to the position where the next non-zero should go.
1.  If `nums[read] != 0`:
    - `nums[write] = nums[read]`
    - `write++`
2.  `read++`.

After iteration, all non-zeroes are compressed at start.
Fill `nums[write...end]` with 0.

### Optimization (Follow-up)
### *Tối ưu hóa (Câu hỏi mở rộng)*
Instead of overwriting and then filling, we can **swap**.
If `nums[read] != 0`:
    Swap `nums[read]` with `nums[write]`. `write++`.
    (If `read == write`, it's a self-swap, cheap).
This ensures that the "tail" is automatically filled with the zeros we swapped out.

---

## 2. Approach: Optimal Swapping
## *2. Hướng tiếp cận: Hoán đổi Tối ưu*

### Logic
### *Logic*
1.  `lastNonZeroFoundAt = 0`.
2.  Iterate `cur` from 0 to `n-1`.
3.  If `nums[cur] != 0`:
    - `swap(nums[lastNonZeroFoundAt++], nums[cur])`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **In-Place:** Uses only existing array.
*   **Minimized Writes:** By swapping, we avoid writing 0s explicitly at the end if the input has few 0s.
    *Tại chỗ: Chỉ dùng mảng hiện có. Giảm thiểu ghi: Bằng cách hoán đổi, tránh việc ghi số 0 từ minh vào cuối.*

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

**Input:** `[0, 1, 0, 3, 12]`
1.  `cur=0`, val=0. `last=0`.
2.  `cur=1`, val=1. Swap(0, 1). Array: `[1, 0, 0, 3, 12]`. `last=1`.
3.  `cur=2`, val=0.
4.  `cur=3`, val=3. Swap(1, 3). Array: `[1, 3, 0, 0, 12]`. `last=2`.
5.  `cur=4`, val=12. Swap(2, 4). Array: `[1, 3, 12, 0, 0]`. `last=3`.
Result: `[1, 3, 12, 0, 0]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic two-pointer pattern. "Snowball" effect method describes the zeros accumulating.
*Mẫu hai con trỏ kinh điển. Phương pháp hiệu ứng "Quả cầu tuyết" miêu tả các số 0 tích tụ.*
---
*Đừng để những khoảng trống (số 0) xen vào giữa giá trị thực sự. Hãy đẩy chúng ra sau để những gì quan trọng nhất được ưu tiên hàng đầu.*
Don't let value voids (zeros) intersperse with real worth. Push them to the back so that what matters most comes first.
