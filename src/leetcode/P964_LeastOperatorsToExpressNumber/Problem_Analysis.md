# 964. Least Operators to Express Number / Số lượng Toán tử ít nhất để biểu diễn số

## Problem Description / Mô tả bài toán
Given `x` and `target`, return the least number of operators (+, -, *, /) needed to express `target` using numbers `x`.
Cho `x` và `target`, hãy trả về số lượng toán tử (+, -, *, /) ít nhất cần thiết để biểu diễn `target` bằng cách sử dụng các số `x`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursion with Memoization (Base-x Representation) / Đệ quy với Memoization (Biểu diễn cơ số x)
We can express the target in base `x`.
Chúng ta có thể biểu diễn mục tiêu trong cơ số `x`.

Algorithm:
1. `dfs(target)`:
   - Find the largest power `p` such that `x^p <= target`.
   - Option 1: Use `x^p` multiple times: `count * (p operators) + dfs(target - count * x^p)`.
   - Option 2: Use `x^(p+1)` and subtract: `(count + 1) * (p+1 operators) + dfs((count+1) * x^(p+1) - target)`.
   - Special case: `p=0` (using `x/x`).

### Complexity / Độ phức tạp
- **Time**: O(log_{x} Target).
- **Space**: O(log_{x} Target).

---

## Analysis / Phân tích

### Approach: Greedy Base-x Decomposition
Treat the target as a value to be reached through powers of $X$. At each scale, decide whether to approach the target from below or overshot and subtract. Memoization tracks the optimal path for each remaining sub-target.
Coi mục tiêu là một giá trị cần đạt được thông qua các lũy thừa của $X$. Ở mỗi quy mô, hãy quyết định xem nên tiếp cận mục tiêu từ dưới lên hay vượt quá rồi trừ đi. Memoization theo dõi đường đi tối ưu cho mỗi mục tiêu phụ còn lại.

---
