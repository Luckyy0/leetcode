# 301. Remove Invalid Parentheses / Xóa Dấu Ngoặc Không Hợp Lệ

## Problem Description / Mô tả bài toán
Given a string `s` that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
Cho một chuỗi `s` chứa các dấu ngoặc và chữ cái, hãy xóa số lượng dấu ngoặc không hợp lệ ít nhất để làm cho chuỗi đầu vào hợp lệ.

Return a list of **unique strings** that are valid with the minimum number of removals. You may return the answer in **any order**.
Trả về danh sách các **chuỗi duy nhất** hợp lệ với số lượng xóa tối thiểu.

### Example 1:
```text
Input: s = "()())()"
Output: ["(())()","()()()"]
```

### Example 2:
```text
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
```

### Example 3:
```text
Input: s = ")("
Output: [""]
```

## Constraints / Ràng buộc
- `1 <= s.length <= 25`
- `s` consists of lowercase English letters and parentheses `'('` and `')'`.
- There will be at most `20` parentheses in `s`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### BFS (Breadth-First Search) for Shortest Path / BFS cho Đường Dẫn Ngắn Nhất
Since we want to find the **minimum number of removals**, BFS is a natural choice. We can treat the string as a node in a graph. An edge exists from string `S` to `S'` if `S'` can be obtained by removing exactly one parenthesis from `S`.
- Level 0: Original string.
- Level 1: Remove 1 char.
- Level 2: Remove 2 chars.
The first level where we find any valid string is the level corresponding to the minimum removals.

**Algorithm (BFS)**:
1.  Queue `q`, Set `visited`. Add `s`.
2.  `found = false`.
3.  While `q` not empty:
    - `cur = q.poll`.
    - If `isValid(cur)`:
        - `result.add(cur)`.
        - `found = true`.
    - If `found` is true, continue to consume current level (because other strings at same level might also be valid), but DO NOT generate next level (because we only want minimum removals).
    - If `!found`:
        - Generate all possible next strings by removing 1 char (if it's a parenthesis).
        - If not visited, add to queue.

### DFS with Pruning (Limited Depth) / DFS có Cắt Tỉa
Alternatively, calculate exactly how many left `(` and right `)` parentheses need to be removed first. Then use DFS to carefully remove them. This is often faster than BFS because it avoids generating invalid intermediate states blindly.
1.  Count `removeL` and `removeR`.
2.  Recursively iterate string.
    - If `char == '('`: try keeping it, or try removing it (if `removeL > 0`).
    - Same for `)`.
    - Stop when `removeL == 0` and `removeR == 0` and check validity.

I will implement the **DFS with Pruning** approach as it is generally more efficient for specific constraints and easier to implement strict duplicate avoidance.

**Algorithm (DFS)**:
1.  Calculate `remL` and `remR`:
    - Iterate `s`.
    - If `(`, `L++`.
    - If `)`, `if L > 0 then L-- else R++`.
2.  `dfs(index, left_count, right_count, remL, remR, current_string)`.
3.  Pruning: `if (right_count > left_count) return;` (Invalid prefix).

### Complexity / Độ phức tạp
- **Time**: Exponential in worst case `O(2^N)`, but heavily pruned.
- **Space**: O(N) recursion.

---

## Analysis / Phân tích

### Approach: Efficient DFS

**Edge Cases**:
1.  No parentheses to remove.
2.  All parentheses removed.

---
