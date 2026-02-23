# Analysis for Increasing Triplet Subsequence
# *Phân tích cho bài toán Chuỗi con Bộ ba Tăng dần*

## 1. Problem Essence & Greedy Candidates
## *1. Bản chất vấn đề & Ứng viên Tham lam*

### The Challenge
### *Thách thức*
Find existence of `n1 < n2 < n3` with indices `i < j < k`.
`O(N)` time, `O(1)` space.

### Strategy: Two Thresholds
### *Chiến lược: Hai Ngưỡng*
We maintain two variables: `first` and `second`.
- `first`: the smallest number seen so far.
- `second`: the smallest number seen so far *that lies after some `first` < `second`*.
Logic flow for each number `n`:
1.  If `n <= first`: Check if we can start a better sequence. Update `first = n`.
    Note: Updating `first` here doesn't invalidate the existing `second`. `second` was established with *some previous* `first` that was smaller than it. Even if we find a *better* (smaller) `first` now, the old `second` is still a valid candidate for the second element of a triplet. And if we find a `first` that is even smaller, it just opens up more possibilities for a future `second`.
2.  Else If `n <= second`: We found a number bigger than `first` but smaller than `second`. It's a better candidate for the second position. Update `second = n`.
3.  Else (`n > second`): We found a number bigger than `second`. Since `second` implies there exists a `first` before it, we satisfy `first < second < n`. Return true.

### Correctness of "Updating First"
### *Tính đúng đắn của "Cập nhật First"*
Example: `[3, 5, 1, 6]`.
- 3: `first=3`.
- 5: `> first`. `second=5`. (Seq: 3, 5).
- 1: `<= first`. `first=1`. `second` is still 5. (Seq concept: `1` is single, `?, 5` exists).
  Does `second=5` rely on `first=1`? No. It relies on `first=3`.
  But if we find `6`: `6 > second (5)`. So `?, 5, 6` exists. Valid.
  If we had `[3, 5, 1, 4]`?
  1: `first=1`.
  4: `> first` but `<= second`. Update `second=4`. `first=1`.
  Now we search for `>4`.
  Is this correct? Yes. `1, 4` is better than `3, 5` because `4 < 5`.

---

## 2. Approach: Greedy Scan
## *2. Hướng tiếp cận: Quét Tham lam*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Space:** only 2 variables.
*   **Logical Decoupling:** `second` remembers that *something* smaller came before it, even if we overwrite `first`.
    *Không gian O(1): chỉ 2 biến. Sự tách biệt Logic: `second` nhớ rằng *cái gì đó* nhỏ hơn đã đến trước nó, ngay cả khi ta ghi đè `first`.*

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

**Input:** `[2, 1, 5, 0, 4, 6]`
- 2: `first=2`.
- 1: `1 < 2`. `first=1`.
- 5: `5 > 1`. `second=5`. (Candidates: `1, 5`).
- 0: `0 < 1`. `first=0`. (Candidates: `0`, `?, 5`).
- 4: `4 > 0` but `4 < 5`. `second=4`. (Candidates: `0, 4`).
- 6: `6 > 4`. Return True. (Seq: `0, 4, 6` or `2, 4, 6`? implicitly `0` came before `4`).
Wait, `0` at index 3. `4` at index 4. `6` at index 5. Valid.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic "Smallest Candidates" pattern.
*Mẫu "Ứng viên Nhỏ nhất" kinh điển.*
---
*Chúng ta không cần nhớ chính xác quá khứ (past values), chỉ cần biết rằng hiện tại (second) đã đủ tốt để làm bàn đạp cho tương lai (third).*
We don't need to remember the past (past values) exactly, just know that the present (second) is good enough to be a stepping stone for the future (third).
