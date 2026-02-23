# Analysis for Max Consecutive Ones
# *Phân tích cho bài toán Chuỗi số 1 Liên tiếp Dài nhất*

## 1. Problem Essence & Linear Scan
## *1. Bản chất vấn đề & Duyệt Tuyến tính*

### The Challenge
### *Thách thức*
Counting the longest streak of 1s. Simple iteration.

### Strategy: Counter Reset
### *Chiến lược: Đặt lại Bộ đếm*

1.  Initialize `maxCount = 0`, `currentCount = 0`.
2.  Iterate `num` in `nums`:
    - If `num == 1`: `currentCount++`.
    - If `num == 0`: `maxCount = max(maxCount, currentCount)`, then `currentCount = 0`.
3.  Final Check: `maxCount = max(maxCount, currentCount)` (for trailing 1s).

---

## 2. Approach: Single Loop
## *2. Hướng tiếp cận: Vòng lặp đơn*

### Logic
### *Logic*
(See above). Extremely straightforward.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** One pass.
    *Thời gian O(N): Một lần duyệt.*
*   **O(1) Space:** No extra storage.
    *Không gian O(1): Không tốn bộ nhớ thêm.*

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

**Input:** `[1, 1, 0, 1, 1, 1]`
1. `1`: cur=1.
2. `1`: cur=2.
3. `0`: max=2, cur=0.
4. `1`: cur=1.
5. `1`: cur=2.
6. `1`: cur=3.
End: max = max(2, 3) = 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Single loop with counter.
*Vòng lặp đơn với bộ đếm.*
---
*Sự kiên trì (consecutive) là chìa khóa của thành công. Mỗi bước tiến (1) đều được ghi nhận (count), nhưng chỉ khi bị gián đoạn (0) ta mới thực sự đánh giá được nỗ lực vừa qua. Đừng quên ghi nhận những bước cuối cùng (trailing ones), vì đôi khi đỉnh cao nằm ở ngay vạch đích.*
Perseverance (consecutive) is the key to success. Each step (1) is recorded (Count), but only when interrupted (0) can we truly evaluate the past effort. Don't forget to recognize the last steps (trailing ones), because sometimes the peak is right at the finish line.
