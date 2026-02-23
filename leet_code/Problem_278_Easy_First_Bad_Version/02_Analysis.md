# Analysis for First Bad Version
# *Phân tích cho bài toán Phiên bản Lỗi đầu tiên*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm nhị phân*

### The Pattern
### *Mẫu*
Input: `G G G G B B B B` (Good, Bad).
We need the first `B`.
Property: Monotonic. Once it turns Bad, it stays Bad.
This is exactly **Binary Search**.

### Strategy
### *Chiến lược*
Range `[1, n]`.
`mid = low + (high - low) / 2`.
If `isBadVersion(mid)`:
- Found a Bad version. Could be the first, or there are earlier ones.
- Record `mid` (or just set `high = mid`), try left.
If `!isBadVersion(mid)`:
- Version is Good. First Bad must be after `mid`.
- `low = mid + 1`.

Converge when `low == high`.

---

## 2. Approach: Standard Binary Search
## *2. Hướng tiếp cận: Tìm kiếm nhị phân chuẩn*

### Logic
### *Logic*
1.  `left = 1, right = n`.
2.  While `left < right`:
    - `mid = left + (right - left) / 2`.
    - If `isBadVersion(mid)`: `right = mid`. (Because `mid` could be the answer).
    - Else: `left = mid + 1`. (Because `mid` is Good, answer > `mid`).
3.  Return `left`.

### Overflow Note
### *Lưu ý tràn số*
`mid = (left + right) / 2` can overflow if `left + right > MAX_INT`.
Use `mid = left + (right - left) / 2`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Time:** Reduces search space by half every step.
    *Thời gian Lôgarit: Giảm không gian tìm kiếm một nửa mỗi bước.*

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

**Input:** `n=5`, Bad=4.
1.  `L=1, R=5`. `mid=3`. `isBad(3)` -> False. `L=4`.
2.  `L=4, R=5`. `mid=4`. `isBad(4)` -> True. `R=4`.
3.  `L=4, R=4`. Stop. Return 4.

**Input:** `n=1`, Bad=1.
1.  `L=1, R=1`. Stop. Return 1. (Wait loop `L < R` handles this? No, loop doesn't run. Correct).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Fundamental Binary Search.
*Tìm kiếm nhị phân cơ bản.*
---
*Một khi lỗi lầm xuất hiện (bad version), nó kéo theo hệ quả mãi mãi. Tìm ra gốc rễ (first bad) càng sớm càng tốt để sửa chữa tương lai.*
Once a mistake appears (bad version), it carries consequences forever. Find the root (first bad) as soon as possible to fix the future.
