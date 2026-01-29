# 1499. Max Value of Equation / Giá trị Tối đa của Phương trình

## Problem Description / Mô tả bài toán
Points `points` (x, y), sorted by x. Integer `k`.
Max `yi + yj + |xi - xj|` for `|xi - xj| <= k`.
Since sorted, `xj >= xi` for `j > i`: `yi + yj + xj - xi = (yj + xj) + (yi - xi)`.
Maximize `(yj + xj) + (yi - xi)` for `xj - xi <= k` and `j > i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Deque
Iterate `j`.
We need to maximize `(yi - xi)` for `i < j` and `xi >= xj - k`.
Maintain a deque of indices `i` such that `xi` is valid (within window) and `yi - xi` is decreasing.
1. Remove outdated from front (`xj - xi > k`).
2. Calculate current value using front: `(yj + xj) + (yi - xi)`. Update Max.
3. Push current `j` to back: maintain decreasing order of `yj - xj`. Remove indices with `(y - x)` smaller than current `(yj - xj)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Sliding Window Maximum
Use deque to store pairs `(x, y - x)`.
Iterate points `p`.
Valid range constraint: `p.x - deque.first.x <= k`.
Pop front invalid.
If deque not empty, `ans = max(ans, p.y + p.x + deque.first.val)`.
Push `(p.x, p.y - p.x)`. Pop back if smaller.
Sử dụng deque để lưu trữ các cặp `(x, y - x)`.

---
