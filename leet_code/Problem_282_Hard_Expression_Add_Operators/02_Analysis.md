# Analysis for Expression Add Operators
# *Phân tích cho bài toán Thêm toán tử vào Biểu thức*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui*

### The Challenge
### *Thách thức*
We need to insert `+`, `-`, `*` between digits.
Constraints:
1.  **Leading Zeros:** Numbers like `05` are invalid.
2.  **Operator Precedence:** `*` binds tighter than `+` and `-`. We must evaluate on the fly.
3.  **Overflow:** Intermediate sums can exceed Integer limits.

### Strategy: Backtracking with State
### *Chiến lược: Quay lui với Trạng thái*
Typical `evaluate()` function takes $O(N)$ for string. We cannot afford that inside recursion.
We maintain `currentEval` value.
When adding `+` or `-`, it's easy: `eval + curr` or `eval - curr`.
When adding `*`, logic:
`prevEval = A + B`. New op is `* C`.
Correct: `A + (B * C)`.
Correction Formula: `(prevEval - prevNum) + (prevNum * currNum)`.
So we need to pass `prevNum` (the last operand added) in recursion.

---

## 2. Approach: DFS with Multiplication Correction
## *2. Hướng tiếp cận: DFS với Sửa lỗi Nhân*

### Logic
### *Logic*
`dfs(index, path, eval, multed)`
- Base case: `index == num.length`. If `eval == target`, add `path`.
- Loop `i` from `index` to end:
    - Substring `currStr` = `num[index...i]`.
    - `currVal` = parse long(currStr).
    - **Leading Zero Check:** If `num[index] == '0'` and `i > index`, break (cannot have "05").
    - Recursive Calls:
        - **First number:** Just pick it. `dfs(i+1, str, currVal, currVal)`.
        - **Ops:**
            - `+`: `dfs(i+1, path + "+" + currStr, eval + currVal, currVal)`
            - `-`: `dfs(i+1, path + "-" + currStr, eval - currVal, -currVal)`
            - `*`: `dfs(i+1, path + "*" + currStr, eval - multed + multed * currVal, multed * currVal)`

### Note on `multed`
### *Lưu ý về `multed`*
For subtraction, `multed` is `-currVal` because effectively we added `(-currVal)`.
Then correction `(eval - (-currVal)) + (-currVal * upcoming)` works.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **One-Pass Evaluation:** No need to build string then parse. Evaluation happens live.
    *Đánh giá một lượt: Không cần xây dựng chuỗi rồi phân tích. Đánh giá diễn ra trực tiếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(4^N)$. 4 choices (join, +, -, *) per position roughly. $N=10$ is small.
    *Độ phức tạp thời gian: $O(4^N)$.*
*   **Space Complexity:** $O(N)$ depth.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "123", target 6.
1.  Start: `dfs(0, "", 0, 0)`
2.  Index 0, len 1 ("1"): `dfs(1, "1", 1, 1)`
    - Next "2":
        - `+`: `dfs(2, "1+2", 3, 2)` -> Next "3":
            - `+`: "1+2+3", eval 6. MATCH.
            - `*`: eval `3 - 2 + 2*3` = 7. No.
        - `*`: `dfs(2, "1*2", 2, 2)` -> Next "3":
            - `+`: "1*2+3", eval 5. No.
            - `*`: "1*2*3", eval `2 - 2 + 2*3` = 6. MATCH.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Key is the multiplication rollback `eval - Multed + Multed * current`.
*Chìa khóa là sự quay lui phép nhân.*
---
*Đôi khi một phần tử mới (phép nhân) thay đổi ý nghĩa của quá khứ (cộng/trừ trước đó). Khả năng điều chỉnh nhận thức (rollback) là dấu hiệu của trí tuệ.*
Sometimes a new element (multiplication) changes the meaning of the past (previous add/sub). The ability to adjust perception (rollback) is a sign of intelligence.
