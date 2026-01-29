# 1111. Maximum Nesting Depth of Two Valid Parentheses Strings / Độ sâu Lồng ghép Tối đa của Hai Chuỗi Dấu ngoặc đơn Hợp lệ

## Problem Description / Mô tả bài toán
A string is a valid parentheses string if it meets standard definitions. The nesting depth `depth(S)` is the maximum number of nested parentheses.
Given a VPS `seq`, split it into two disjoint subsequences `A` and `B`, such that `A` and `B` are VPSs (and `A + B` covers `seq`).
We want to minimize `max(depth(A), depth(B))`.
Return an array `answer` where `answer[i]` is 0 if `seq[i]` belongs to `A`, and 1 if `seq[i]` belongs to `B`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Depth Balancing / Cân bằng Độ sâu Tham lam
We want to distribute the nesting levels evenly.
Level 1 -> A
Level 2 -> B
Level 3 -> A
Level 4 -> B
...
This splits depth `D` into `D/2` and `D - D/2`.
So `max(depth(A), depth(B))` will be approx `ceil(D/2)`.

Algorithm:
1. Iterate `seq`. Maintain current `depth`.
2. For `(`, increment depth. Assign to group `depth % 2`.
3. For `)`, assign to group `depth % 2`. Decrement depth.
   - Wait, logic check: `(` at depth 1 -> A. Next `(` at depth 2 -> B.
   - `)` matching depth 2 -> B. `)` matching depth 1 -> A.
   - Correct. `seq` is valid, so `)` always matches the most recent unmatched `(`.
   - We assign `(` based on its level. We assign `)` based on the level it closes.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Depth Parity Distribution
Distribute parentheses based on their nesting depth. Assigning parentheses at odd depths to one subsequence and even depths to another effectively halves the maximum nesting depth in each resulting subsequence. This minimizes the maximum depth as requested.
Phân phối các dấu ngoặc đơn dựa trên độ sâu lồng ghép của chúng. Việc gán các dấu ngoặc đơn ở độ sâu lẻ cho một chuỗi con và độ sâu chẵn cho một chuỗi con khác sẽ làm giảm một nửa độ sâu lồng ghép tối đa trong mỗi chuỗi con kết quả. Điều này giảm thiểu độ sâu tối đa theo yêu cầu.

---
