# Analysis for Remove Invalid Parentheses
# *Phân tích cho bài toán Loại bỏ Dấu ngoặc Không hợp lệ*

## 1. Problem Essence & BFS
## *1. Bản chất vấn đề & BFS*

### The Challenge
### *Thách thức*
Remove *minimum* number of parentheses.
This hints at **shortest path** in a graph where edges represent removing 1 char.
BFS is ideal for finding the shortest path (minimum removals) to a target (valid state).

### Strategy: BFS
### *Chiến lược: BFS*
1.  Target: A string is valid if `balance == 0` at end and `balance >= 0` always.
2.  Start BFS with input string `s`.
3.  Level 0: Check `s`. If valid, add to result.
4.  If result not empty, stop (we found min removals).
5.  Else, generate Level 1: Remove each parenthesis `(` or `)` once from current level strings.
6.  Use a Set `visited` to avoid duplicates (e.g., removing first `(` vs removing second `(` in `((` results in same `(`).

### Optimization
### *Tối ưu hóa*
Given constraints (length 25), BFS is feasible. `O(2^N)`.
However, we can calculate strictly how many `(` and `)` need to be removed first to prune search space (DFS approach).
But BFS is more intuitive for "minimum removals" and handles the "all possible results" well.
Let's stick to simple BFS.

---

## 2. Approach: Breadth-First Search
## *2. Hướng tiếp cận: Tìm kiếm Chiều rộng*

### Logic
### *Logic*
1.  Queue `q`. Set `visited`.
2.  Add `s`.
3.  `found = false`.
4.  While `q` not empty:
    - Get current level size.
    - Loop through level:
        - `curr = q.poll()`.
        - If `isValid(curr)`:
            - `res.add(curr)`
            - `found = true`.
        - If `found` is true, continue (don't generate next level children for this node, but finish current level).
        - If `found` is false:
            - Generate children: Remove `s[i]` if `s[i]` is parenthese.
            - Add to queue if not visited.
    - If `found` is true, BREAK (don't go deeper).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Layered Search:** Guarantees minimum changes because we check 0 removals, then 1 removal, then 2...
    *Tìm kiếm theo lớp: Đảm bảo số thay đổi tối thiểu vì ta kiểm tra 0 lần xóa, rồi 1 lần xóa...*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Exponential $O(2^N)$. N=25 is small.
    *Độ phức tạp thời gian: Số mũ $O(2^N)$.*
*   **Space Complexity:** $O(2^N)$ for queue/set in worst case.
    *Độ phức tạp không gian: $O(2^N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `()())()`
Level 0: `()())()` (Invalid)
Level 1:
- Remove 0: `)())()` (Invalid)
- Remove 1: `(())()` (VALID!) -> Add to res. Found = true.
- Remove 2: `()()()` (VALID!) -> Add to res.
- ...
Stop after Level 1.
Result: `["(())()", "()()()"]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

BFS is the most direct conceptual mapping for "minimum steps".
*BFS là ánh xạ khái niệm trực tiếp nhất cho "số bước tối thiểu".*
---
*Đôi khi để đạt được sự hoàn hảo (validity), ta phải chấp nhận buông bỏ (remove) những gì dư thừa. Vấn đề là bỏ cái gì để mất mát là ít nhất (minimum).*
Sometimes to achieve perfection (validity), we must accept letting go (remove) of what is redundant. The question is what to discard so the loss is minimal.
