# Analysis for Wiggle Subsequence
# *Phân tích cho bài toán Chuỗi con Hình sin*

## 1. Problem Essence & Greedy Strategy
## *1. Bản chất vấn đề & Chiến lược Tham lam*

### The Challenge
### *Thách thức*
Finding the longest sequence that alternates its direction (up-down-up-down).

### Strategy: Peak and Valley Counting
### *Chiến lược: Đếm Đỉnh và Đáy*
Any continuous part of the array that is strictly increasing (or decreasing) only contributes **one** element to a potential wiggle sequence (either the start or the end of the slope).
1.  Maintain two states: `up` and `down`.
    - `up`: Length of the longest wiggle subsequence ending with an upward climb.
    - `down`: Length of the longest wiggle subsequence ending with a downward drop.
2.  Iterate through the array:
    - If `nums[i] > nums[i-1]`: An upward move can follow a downward drop. `up = down + 1`.
    - If `nums[i] < nums[i-1]`: A downward drop can follow an upward move. `down = up + 1`.
    - If `nums[i] == nums[i-1]`: No change in direction, skip.

---

## 2. Approach: Simple Greedy/DP
## *2. Hướng tiếp cận: Tham lam/DP Đơn giản*

### Logic
### *Logic*
(See above). At each step, we update the potential long-sequence endings.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear scan handles the whole problem efficiently.
    *Hiệu quả O(N): Duyệt tuyến tính xử lý hiệu quả bài toán.*
*   **O(1) Space:** only two variables needed.
    *Không gian O(1): Chỉ cần hai biến.*

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

**Input:** `[1, 7, 4, 9, 2, 5]`
1. $i=0$: Init `up=1, down=1`.
2. $1 \to 7$ (up): `up = down + 1 = 2`.
3. $7 \to 4$ (down): `down = up + 1 = 3`.
4. $4 \to 9$ (up): `up = down + 1 = 4`.
5. $9 \to 2$ (down): `down = up + 1 = 5`.
6. $2 \to 5$ (up): `up = down + 1 = 6`.
Result: 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Single pass counting directional changes.
*Một lần quét đếm sự thay đổi hướng.*
---
*Cuộc sống không phải một đường thẳng, nó là sự xen kẽ giữa những thăng (up) và trầm (down). Để hành trình (subsequence) trở nên dài nhất và ý nghĩa nhất, chúng ta cần biết cách trân trọng sự thay đổi hướng tại mỗi đỉnh (peak) và đáy (valley) mà ta đi qua.*
Life is not a straight line, it is an alternation between ups and downs. To make the journey (subsequence) the longest and most meaningful, we need to know how to appreciate the change in direction at each peak and valley that we pass through.
