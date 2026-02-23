# Analysis for Find the Celebrity
# *Phân tích cho bài toán Tìm Người nổi tiếng*

## 1. Problem Essence & Logical Deduction
## *1. Bản chất vấn đề & Suy luận logic*

### Definition
### *Định nghĩa*
Celebrity `C`:
1.  Everyone knows `C` (`indegree = n-1`).
2.  `C` knows NO ONE (`outdegree = 0`).

### The Elimination Game
### *Trò chơi loại trừ*
If `knows(A, B)` is true:
- `A` knows `B`. `A` cannot be celebrity (outdegree > 0).
- `B` *might* be celebrity.
If `knows(A, B)` is false:
- `A` doesn't know `B`. `A` *might* be celebrity.
- `B` cannot be celebrity (someone doesn't know `B`).

In **either case**, we eliminate exactly one candidate!
- True -> Eliminate A.
- False -> Eliminate B.

### Strategy
### *Chiến lược*
1.  **Candidate Selection (Pass 1):**
    - `candidate = 0`.
    - Loop `i` from 1 to `n-1`:
        - If `knows(candidate, i)`: `candidate = i`. (Old candidate disqualified, `i` is new potential).
    - After loop, `candidate` is the *only* person who *could* be the celebrity.
2.  **Verification (Pass 2):**
    - Check if `candidate` is actually a celebrity.
    - Loop `i` from 0 to `n-1`:
        - If `i == candidate`, continue.
        - If `knows(candidate, i)` (Celeb knows someone) -> Invalid.
        - If `!knows(i, candidate)` (Someone doesn't know Celeb) -> Invalid.
3.  If valid, return `candidate`. Else `-1`.

---

## 2. Approach: Two Pass Linear Scan
## *2. Hướng tiếp cận: Quét tuyến tính hai lượt*

### Logic
### *Logic*
1.  Find candidate using logic above. Limit `N` calls (roughly).
2.  Verify candidate. Limit `2N` calls (checking knows/known-by for all).
Total calls < `3N`. Fits constraint.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logic Density:** Each call `knows(a,b)` provides exactly 1 bit of information that definitively removes a node from the pool of size N.
    *Mật độ logic: Mỗi cuộc gọi cung cấp 1 bit thông tin loại bỏ chắc chắn một nút.*

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

**Input:** Graph where 1 is celeb.
0 knows 1. 1 knows none. 2 knows 1.
1.  **Pass 1:**
    - `cand = 0`. Check `knows(0, 1)` -> True. `cand = 1`.
    - `cand = 1`. Check `knows(1, 2)` -> False. `cand` stays 1.
    - End. Candidate 1.
2.  **Pass 2:**
    - Check 0: `knows(0, 1)`? Yes. `knows(1, 0)`? No. OK.
    - Check 2: `knows(2, 1)`? Yes. `knows(1, 2)`? No. OK.
    - Return 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Elegant two-pass solution.
*Giải pháp hai lượt thanh lịch.*
---
*Người nổi tiếng thật sự không cần phải biết ai, nhưng ai cũng phải biết họ. Vị thế được xác định bởi sự chú ý một chiều.*
A true celebrity needs to know no one, but everyone must know them. Status is defined by one-way attention.
