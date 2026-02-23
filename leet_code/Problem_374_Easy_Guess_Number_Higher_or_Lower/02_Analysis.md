# Analysis for Guess Number Higher or Lower
# *Phân tích cho bài toán Đoán số Cao hơn hay Thấp hơn*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm Nhị phân*

### The Challenge
### *Thách thức*
Finding a specific value in a sorted range $[1, n]$ using feedback.

### Strategy: Binary Search
### *Chiến lược: Tìm kiếm Nhị phân*
Standard binary search approach:
1.  Initialize `low = 1`, `high = n`.
2.  While `low <= high`:
    - Calculate `mid = low + (high - low) / 2`.
    - Call `guess(mid)`.
    - If result is `0`: Return `mid`.
    - If result is `-1`: Guess is too high, set `high = mid - 1`.
    - If result is `1`: Guess is too low, set `low = mid + 1`.

---

## 2. Approach: Standard Binary Search
## *2. Hướng tiếp cận: Tìm kiếm Nhị phân Tiêu chuẩn*

### Logic
### *Logic*
(See above). We use `low + (high - low) / 2` to avoid integer overflow when $n$ is near $2^{31}-1$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Efficiency:** Takes at most 31 guesses for any number up to $2^{31}$.
    *Hiệu quả logarit: Tối đa 31 lần đoán cho bất kỳ số nào lên tới $2^{31}$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *Độ phức tạp thời gian: $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n=10, pick=6`
1. `low=1, high=10`. `mid=5`. `guess(5)` returns `1` (pick > 5).
2. `low=6, high=10`. `mid=8`. `guess(8)` returns `-1` (pick < 8).
3. `low=6, high=7`. `mid=6`. `guess(6)` returns `0`.
Result: 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic Binary Search.
*Tìm kiếm Nhị phân cổ điển.*
---
*Đôi khi câu trả lời đúng (pick) nằm ở đâu đó giữa những thái cực (low/high). Bằng cách lắng nghe phản hồi (feedback) và thu hẹp dần phạm vi tìm kiếm (halving the space), ta sẽ luôn tìm thấy sự thật trong thời gian ngắn nhất.*
Sometimes the right answer (pick) lies somewhere between extremes (low/high). By listening to feedback and gradually narrowing the search space (halving the space), we will always find the truth in the shortest time.
