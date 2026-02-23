# Analysis for Self Crossing
# *Phân tích cho bài toán Tự Cắt*

## 1. Problem Essence & Geometry
## *1. Bản chất vấn đề & Hình học*

### The Cases
### *Các trường hợp*
We are drawing a spiral. Crossing happens if the spiral stops expanding and starts shrinking, colliding with previous outer layers.
There are 3 specific geometric configurations where a line `i` crosses an older line:

1.  **4th Line Crossing:** `d[i]` crosses `d[i-3]`.
    Condition: `d[i] >= d[i-2]` AND `d[i-1] <= d[i-3]`.
    (Current line is long enough to reach previous parallel line, and previous perpendicular line was short enough to separate them).

2.  **5th Line Meeting:** `d[i]` meets `d[i-4]`.
    Condition: `d[i-1] == d[i-3]` (width exactly same) AND `d[i] + d[i-4] >= d[i-2]`.

3.  **6th Line Crossing (Bounded):** The spiral was expanding, then shrunk, then trapped.
    Condition:
    - `d[i-1] <= d[i-3]` (Current width fits inside)
    - `d[i] + d[i-4] >= d[i-2]` (Current length reaches boundary)
    - `d[i-1] + d[i-5] >= d[i-3]` (Boundary width check)
    - `d[i-2] > d[i-4]` (Was strictly expanding before)

Actually, it simplifies to identifying transitions from "Expanding Spiral" to "Shrinking Spiral".
If "Shrinking", it's safe unless it expands again (impossible if bounded).
Complexity usually handled by checking checking `i` against `i-3`, `i-4`, `i-5`.

### Strategy: Iterative Check
### *Chiến lược: Kiểm tra Lặp*
Loop `i` from 3 to `n`.
Check 3 conditions.
If any met, return true.

---

## 2. Approach: Conditional Check
## *2. Hướng tiếp cận: Kiểm tra Điều kiện*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*

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

**Input:** `[2, 1, 1, 2]`
i=3 (Length 2). `d[3]=2`.
Prev: `d[2]=1`, `d[1]=1`, `d[0]=2`.
Case 1: `d[3] >= d[1]`? (2 >= 1 Yes). `d[2] <= d[0]`? (1 <= 2 Yes).
Crosses! True.

**Input:** `[1, 2, 3, 4]`
i=3. `d[3]=4`. `d[1]=2`. `d[2]=3`. `d[0]=1`.
`d[3] >= d[1]` (Yes). `d[2] <= d[0]` (3 <= 1 No).
No cross. False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Geometry check. Memorize the 3 cases or visualize spiral intersection.
*Kiểm tra hình học. Ghi nhớ 3 trường hợp hoặc hình dung giao điểm xoắn ốc.*
---
*Đôi khi việc phát triển (expanding) quá nhanh mà không kiểm soát được giới hạn (boundaries) sẽ dẫn đến việc tự làm hại chính mình (self-crossing).*
Sometimes expanding too fast without controlling the boundaries leads to self-harm (self-crossing).
